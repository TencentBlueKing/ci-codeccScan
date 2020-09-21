# -*- coding: utf-8 -*-
#
# Tencent is pleased to support the open source community by making this available.
# Copyright (C) 2016THL A29 Limited, a Tencent company. All rights reserved.
# Licensed under the BSD 3-Clause License (the "License"); you may not use this
# file except in compliance with the License. You may obtain a copy of the License at
#
# https://opensource.org/licenses/BSD-3-Clause
#
# Unless required by applicable law or agreed to in writing, software distributed
# under the License is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS
# OF ANY KIND, either express or implied. See the License for the specific language
# governing permissions and limitations under the License.
#

import tokenize
import re
import sys
from codecs import lookup, BOM_UTF8

from pylint.interfaces import IRawChecker
from pylint.interfaces import IAstroidChecker
from pylint.interfaces import ITokenChecker
from pylint.checkers import BaseChecker
from pylint.checkers import utils

cookie_re = re.compile(r'^[ \t\f]*#.*?coding[:=][ \t]*([-\w.]+)')
blank_re = re.compile(br'^[ \t\f]*(?:[#\r\n]|$)')

def _get_normal_name(orig_enc):
    """Imitates get_normal_name in tokenizer.c."""
    # Only care about the first 12 characters.
    enc = orig_enc[:12].lower().replace("_", "-")
    if enc == "utf-8" or enc.startswith("utf-8-"):
        return "utf-8"
    if enc in ("latin-1", "iso-8859-1", "iso-latin-1") or \
       enc.startswith(("latin-1-", "iso-8859-1-", "iso-latin-1-")):
        return "iso-8859-1"
    return orig_enc

def _detect_encoding(readline):
    """
    The detect_encoding() function is used to detect the encoding that should
    be used to decode a Python source file.  It requires one argument, readline,
    in the same way as the tokenize() generator.

    It will call readline a maximum of twice, and return the encoding used
    (as a string) and a list of any lines (left as bytes) it has read in.

    It detects the encoding from the presence of a utf-8 bom or an encoding
    cookie as specified in pep-0263.  If both a bom and a cookie are present,
    but disagree, a SyntaxError will be raised.  If the encoding cookie is an
    invalid charset, raise a SyntaxError.  Note that if a utf-8 bom is found,
    'utf-8-sig' is returned.

    If no encoding is specified, then the default of 'utf-8' will be returned.
    """
    try:
        filename = readline.__self__.name
    except AttributeError:
        filename = None
    bom_found = False
    encoding = None
    default = 'utf-8'
    def read_or_stop():
        try:
            return readline()
        except StopIteration:
            return b''

    def find_cookie(line):
        try:
            # Decode as UTF-8. Either the line is an encoding declaration,
            # in which case it should be pure ASCII, or it must be UTF-8
            # per default encoding.
            line_string = line.decode('utf-8')
        except UnicodeDecodeError:
            msg = "invalid or missing encoding declaration"
            if filename is not None:
                msg = '{} for {!r}'.format(msg, filename)
            raise SyntaxError(msg)

        match = cookie_re.match(line_string)
        if not match:
            return None
        encoding = _get_normal_name(match.group(1))
        try:
            codec = lookup(encoding)
        except LookupError:
            # This behaviour mimics the Python interpreter
            if filename is None:
                msg = "unknown encoding: " + encoding
            else:
                msg = "unknown encoding for {!r}: {}".format(filename,
                        encoding)
            raise SyntaxError(msg)

        if bom_found:
            if encoding != 'utf-8':
                # This behaviour mimics the Python interpreter
                if filename is None:
                    msg = 'encoding problem: utf-8'
                else:
                    msg = 'encoding problem for {!r}: utf-8'.format(filename)
                raise SyntaxError(msg)
            encoding += '-sig'
        return encoding

    first = read_or_stop()
    if first.startswith(BOM_UTF8):
        bom_found = True
        first = first[3:]
        default = 'utf-8-sig'
    if not first:
        return default, []

    encoding = find_cookie(first)
    if encoding:
        return encoding, [first]
    if not blank_re.match(first):
        return default, [first]

    second = read_or_stop()
    if not second:
        return default, [first]

    encoding = find_cookie(second)
    if encoding:
        return encoding, [first, second]

    return default, [first, second]

def _match_module_docstring(tokens):
    """Return a matched module docstring token, None otherwise."""

    for idx, token in enumerate(tokens):
        tok_type = token[0]

        # The first STRING token represents the module docstring.
        if tok_type == tokenize.STRING:
            return token

        # others are not docstring.
        if sys.version_info < (3, 0):
            if tok_type not in (tokenize.COMMENT, tokenize.NL, tokenize.INDENT):\
                break
        else:
            if tok_type not in (tokenize.ENCODING, tokenize.COMMENT, tokenize.NL, tokenize.INDENT):
                break

    return None


def _match_docstring(tokens):
    """Return a matched docstring token, None otherwise."""

    # match class and function definition.
    if tokens[0][1] not in ('class', 'def'):
        return

    # find ':' in the "def func():"
    colons = (idx for idx, token in enumerate(tokens) if token[1] == ':')
    colon_idx = next(colons, None)
    if colon_idx is None:
        return None

    for token in tokens[colon_idx + 1:]:
        tok_type = token[0]

        # The first STRING token represents the docstring.
        if tok_type == tokenize.STRING:
            return token

        # Others are not docstring.
        if tok_type not in (tokenize.NL, tokenize.NEWLINE, tokenize.INDENT):
            break

    return None


class FormatChecker(BaseChecker):
    __implements__ = (IRawChecker, ITokenChecker, IAstroidChecker)

    # configuration section name
    name = "format"
    msgs = {
        'C9901': (
            'Unexpected file encoding. Found %s, expected %s.',
            'unexpected-file-encoding',
            'Used when there is different file encoding than expected.'
        ),
        'C9902': (
            'Function name too long(%s/%s)',
            'function-name-too-long',
            'Used when a name is longer than a given number of characters.'
        ),
        'C9903': (
            '缺少腾讯开源协议声明，请联系公司法务获取',
            'missing-license',
            'Used when a file has no license.'
        ),
        'C9904': (
            'Low comment ratio. Found %s%%, expected %s%%.',
            'low-comment-ratio',
            'Used when the comment ratio is lower than expected.'
        ),
        'C9905': (
            "Bad space indentation. %s",
            "bad-space-indentation",
            "Used when an unexpected number of indentation's spaces has been found."
        ),
    }

    # configuration options
    options = (
        (
            "max-function-name-length",
            {
                "default": 35,
                "type": "int",
                "metavar": "<int>",
                "help": "Maximum number of characters on a function/method name.",
            },
        ),
        (
            "min-comment-ratio",
            {
                "default": 10,
                "type": "int",
                "metavar": "<int>",
                "help": "Minimum number of required comment ratio.",
            },
        ),
        (
            "space-indent-size",
            {
                "default": 4,
                "type": "int",
                "metavar": "<int>",
                "help": "The number of spaces indentation (default is 4).",
            }
        ),
    )

    def process_module(self, node):
        """Process module and search for missing license."""

        license_found = False

        with node.stream() as stream:
            readline = stream.readline
            self._check_source_encoding(readline)

        with node.stream() as stream:
            for (line_num, line) in enumerate(stream):
                if line_num > 10:
                    break

                if b"Tencent is pleased to support the open source community" in line:
                    license_found = True

        if not license_found:
            self.add_message("missing-license", line=0)

    def process_tokens(self, tokens):
        """Process tokens and search for:
        -   unexpected file encoding.
        -   low-comment-ratio.
        """

        self._check_comment_ratio(tokens)
        self._check_space_indentation(tokens)

    def _check_source_encoding(self, readline):
        try:
            detect_encoding = tokenize.detect_encoding
        except AttributeError:
            detect_encoding = _detect_encoding

        try:
            encoding, _ = detect_encoding(readline)
        except SyntaxError:
            encoding = "Unknown"

        if encoding != 'utf-8':
            self.add_message("unexpected-file-encoding", line=0, args=(encoding, 'utf-8'))


    def _check_comment_ratio(self, tokens):
        line_num = 0
        empty_lines = 0
        comment_lines = 0

        # match module's docstring
        docstring = _match_module_docstring(tokens)
        if docstring:
            comment_lines += docstring[3][0] - docstring[2][0] + 1

        for idx, token in enumerate(tokens):
            if token[2][0] != line_num:
                line_num = token[2][0]

            # match empty line.
            if tokens[idx][0] == tokenize.NL and tokens[idx - 1][0] in (tokenize.NL, tokenize.NEWLINE):
                empty_lines += 1

            # match comment line.
            if token[0] == tokenize.COMMENT:
                comment_lines += 1

            # match docstring.
            docstring = _match_docstring(tokens[idx:])
            if docstring:
                comment_lines += docstring[3][0] - docstring[2][0] + 1

        line_num -= 1  # to be ok with "wc -l"

        code_line_num = line_num - empty_lines
        if code_line_num <= 0:
            return

        comment_ratio = comment_lines / code_line_num * 100
        min_comment_ratio = self.config.min_comment_ratio
        if comment_ratio < min_comment_ratio:
            self.add_message("low-comment-ratio", line=0,
                             args=("{0:.2f}".format(comment_ratio), min_comment_ratio))

    @utils.check_messages('function-name-too-long')
    def visit_functiondef(self, node):
        """Check function name too long """
        self._check_name(node.name, node)

    def _check_name(self, name, node):
        if isinstance(name, str):
            name = name.encode('utf-8')

        max_characters = self.config.max_function_name_length
        if len(name) > max_characters:
            self.add_message("function-name-too-long", line=node.lineno, args=(len(name), max_characters))

    def _check_space_indentation(self, tokens):
        indents = [0]
        check_equal = False
        line_num = 0

        for idx, (tok_type, token, start, _, line) in enumerate(tokens):
            if start[0] != line_num:
                line_num = start[0]

            if tok_type == tokenize.NEWLINE:
                # a program statement, or ENDMARKER, will eventually follow,
                # after some (possibly empty) run of tokens of the form
                #     (NL | COMMENT)* (INDENT | DEDENT+)?
                # If an INDENT appears, setting check_equal is wrong, and will
                # be undone when we see the INDENT.
                check_equal = True
            elif tok_type == tokenize.INDENT:
                check_equal = False
                self._check_indent_level(token, indents[-1] + 1, line_num)
                indents.append(indents[-1] + 1)
            elif tok_type == tokenize.DEDENT:
                # there's nothing we need to check here!  what's important is
                # that when the run of DEDENTs ends, the indentation of the
                # program statement (or ENDMARKER) that triggered the run is
                # equal to what's left at the top of the indents stack
                check_equal = True
                if len(indents) > 1:
                    del indents[-1]
            elif tok_type == tokenize.NL:
                # do nothing.
                pass
            elif tok_type not in (tokenize.COMMENT, tokenize.ENCODING if sys.version_info >= (3, 0) else None):
                # This is the first concrete token following a NEWLINE, so it
                # must be the first token of the next program statement, or an
                # ENDMARKER; the "line" argument exposes the leading whitespace
                # for this statement; in the case of ENDMARKER, line is an empty
                # string, so will properly match the empty string with which the
                # "indents" stack was seeded
                if check_equal:
                    check_equal = False
                    self._check_indent_level(line, indents[-1], line_num)

    def _check_indent_level(self, line, expected, line_num):
        level = 0
        indent_size = self.config.space_indent_size
        indent_str = "".join((" " for i in range(indent_size)))

        while line[:indent_size] == indent_str:
            line = line[indent_size:]
            level += 1

        extra_space = 0
        while line and line[0] in " \t":
            if line[0] != ' ':
                self.add_message("bad-space-indentation", line=line_num, args="Tabs must not be used")
                return
            extra_space += 1
            line = line[1:]

        if level != expected or extra_space > 0:
            message = "Found %s spaces, expected %s" % ((level * indent_size + extra_space), expected * indent_size)
            self.add_message("bad-space-indentation", line=line_num, args=message)

def register(linter):
    """required method to auto register this checker"""
    linter.register_checker(FormatChecker(linter))
