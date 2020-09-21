#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import re

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    for line in xrange(1, min(len(codeLineObj.raw_lines), 11)):
      if re.search(r'Tencent is pleased to support the open source community by making', codeLineObj.raw_lines[line], re.I): return
    errorHandler(filePath, 1, 'tosa/copyright', 'No copyright is found')