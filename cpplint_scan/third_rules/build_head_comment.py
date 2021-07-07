#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel

def runChecker(filePath, codeLineObj, errorHandler, option_info):

    hasVersion = False
    hasModule = False
    hasAuthor = False
    for line in range(1, min(len(codeLineObj.raw_lines), 11)):
        if 'Module' in codeLineObj.raw_lines[line]:
            hasModule = True
        if 'Version' in codeLineObj.raw_lines[line]:
            hasVersion = True
        if 'Author' in codeLineObj.raw_lines[line]:
            hasAuthor = True

    if (not hasVersion) or (not hasModule) or (not hasAuthor):
           errorHandler(filePath, 1, 'build/head_comment', 'file header should contains Version/Module/Author tags')
