#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel

def runChecker(filePath, codeLineObj, errorHandler,option_info):
    for linenum, line in enumerate(codeLineObj.raw_lines):
      if u'\ufffd' in line:
        errorHandler(filePath, linenum, 'readability/utf8', 'Line contains invalid UTF-8 (or Unicode replacement character).')