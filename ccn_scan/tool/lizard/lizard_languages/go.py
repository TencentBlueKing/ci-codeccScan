'''
Language parser for Go lang
'''

from .code_reader import CodeReader
from .clike import CCppCommentsMixin
from .golike import GoLikeStates


class GoReader(CodeReader, CCppCommentsMixin):
    # pylint: disable=R0903

    ext = ['go']
    language_names = ['go']

    def __init__(self, context):
        super(GoReader, self).__init__(context)
        self.parallel_states = [GoStates(context)]

    @staticmethod
    def generate_tokens(source_code, addition='', token_class=None):
        return CodeReader.generate_tokens(source_code, r"|\`(?s).*?\`", token_class)


class GoStates(GoLikeStates):  # pylint: disable=R0903
    pass
