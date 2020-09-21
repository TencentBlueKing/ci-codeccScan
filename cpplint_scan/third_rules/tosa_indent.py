#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import json
tosa_space_unit = 4
tosa_tab_unit = 1

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    parse_option_info(option_info)
    for linenum in xrange(1, len(codeLineObj.raw_lines)):
        line = codeLineObj.raw_lines[linenum]
        initial_spaces = IndentLength(line)
        initial_tabs = TabLength(line)
        if ContainSymbol(line, '\t') or IsBadIndent(initial_spaces, line, linenum, codeLineObj.raw_lines):
            errorHandler(filePath, linenum, 'tosa/indent', 'Should use ' + str(tosa_space_unit) + '-space indent.')
        if ContainSymbol(line, ' ') or IsBadTabIndent(initial_tabs, line, linenum, codeLineObj.raw_lines):
            errorHandler(filePath, linenum, 'tosa/indent', 'Should use ' + str(tosa_tab_unit) + '-tab indent.')

def parse_option_info(option_info):
    global tosa_space_unit
    global tosa_tab_unit
    for option in json.loads(option_info):
        if 'checkerOptionName' in option and option['checkerOptionName'] == 'tosa-space':
            tosa_space_unit = int(option['checkerOptionValue'])
        if 'checkerOptionName' in option and option['checkerOptionName'] == 'tosa-tab':
            tosa_tab_unit = int(option['checkerOptionValue'])

def IndentLength(line):
    initial_spaces = 0
    while initial_spaces < len(line) and line[initial_spaces] == ' ':
        initial_spaces += 1
    return initial_spaces

def TabLength(line):
    initial_tab = 0
    while initial_tab < len(line) and line[initial_tab] == '\t':
        initial_tab += 1
    return initial_tab

def ContainSymbol(line, symbol):
  count = 0
  while count < len(line):
    if line[count] <> ' ' and line[count] <> '\t':
        return False
    if line[count] == symbol:
        return True
    count = count + 1
  return False

def IsBadIndent(initial_spaces, line, linenum, raw_lines):
    global tosa_space_unit
    if initial_spaces % tosa_space_unit == 0:
        return False
    if linenum == 0:
        return True
    if line == ' \\':
        return False
    prev_line = raw_lines[linenum - 1]
    if len(prev_line) < initial_spaces:
        return True
    if prev_line[initial_spaces - 1] in '(<[':
        return False  
    prev_indent = IndentLength(prev_line)
    if prev_indent == initial_spaces:
        return False  
    if ((len(prev_line) - initial_spaces > 2) and
        (prev_indent == initial_spaces - 2) and
        (prev_line[prev_indent:prev_indent+2] == ': ') and
        (prev_line[initial_spaces] != ' ')):
        return False  
    if (len(prev_line) > initial_spaces and
       not prev_line[initial_spaces].isspace() and
       prev_line[initial_spaces-1].isspace()):
      return False
    return True

def IsBadTabIndent(initial_spaces, line, linenum, raw_lines):
    global tosa_tab_unit
    if initial_spaces % tosa_tab_unit == 0:
        return False
    if linenum == 0:
        return True
    if line == ' \\':
        return False
    prev_line = raw_lines[linenum - 1]
    if len(prev_line) < initial_spaces:
        return True
    if prev_line[initial_spaces - 1] in '(<[':
        return False
    prev_indent = IndentLength(prev_line)
    if prev_indent == initial_spaces:
        return False
    if ((len(prev_line) - initial_spaces > 2) and
        (prev_indent == initial_spaces - 2) and
        (prev_line[prev_indent:prev_indent+2] == ': ') and
        (prev_line[initial_spaces] != ' ')):
        return False
    if (len(prev_line) > initial_spaces and
       not prev_line[initial_spaces] == '\t' and
       prev_line[initial_spaces-1] == '\t'):
        return False
    return True