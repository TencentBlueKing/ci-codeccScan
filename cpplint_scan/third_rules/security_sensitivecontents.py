#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Kennyli
# 检查是否包含需要保密的信息

def runChecker(filePath, codeLineObj, errorHandler, option_info):

        hasSensitiveWords = False
        for line in range(1, min(len(codeLineObj.raw_lines), 11)):
            if u'敏感词' in codeLineObj.raw_lines[line]:
                hasSensitiveWords = True
                errorHandler(filePath, line, 'security/sensitivecontents', 'file contains sensitive contents')