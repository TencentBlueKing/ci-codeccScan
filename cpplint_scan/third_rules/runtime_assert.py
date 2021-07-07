#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import re

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    for linenum in range(1, len(codeLineObj.raw_lines)):
        line = codeLineObj.raw_lines[linenum]
        if re.search(r'[\s\{\}\);]?assert\(.*\);', line, re.I):
            errorHandler(filePath, linenum, 'runtime/assert', 'Use function assert() with caution, please check if you need to delete it.')