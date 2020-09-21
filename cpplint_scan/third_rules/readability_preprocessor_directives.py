#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Yibo

def runChecker(filePath, codeLineObj, errorHandler,option_info):
    for i in range(1, len(codeLineObj.lines), 1):
        aline = codeLineObj.lines[i]
        if "#" in aline:
            if aline[0] != "#":
                errorHandler(filePath, i, 'readability/preprocessor_directives', 'The hash mark that starts a preprocessor directive should always be at the beginning of the line.')