#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    for linenum in range(len(codeLineObj.raw_lines)):
        if codeLineObj.raw_lines[linenum].endswith('\r'):
            errorHandler(filename, linenum, 'tosa/cr', 1, 'One or more unexpected \\r (^M) found; better to use only a \\n')