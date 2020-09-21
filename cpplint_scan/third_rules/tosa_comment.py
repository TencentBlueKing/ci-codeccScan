#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import re

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    concLine = ""
    for line in codeLineObj.raw_lines:
        concLine += line + '\n'   
    singleLineList = re.findall("//[^\n]*", concLine)   
    multi_line_count = 0
    multi_flag = False
    for line in codeLineObj.raw_lines:
        if "/*" in line or multi_flag == True:
            multi_flag = True
        if "*/" in line:
            multi_flag = False
        multi_line_count += 1 
    total_comment_line = multi_line_count + len(singleLineList) - 2
    ratio = total_comment_line * 1000  / (len(codeLineObj.raw_lines)-2)
    if ratio < 100:
        errorHandler(filePath, 1, "tosa/comment", "comment ratio is [%.2f%%], should more than 10%%" % float(ratio/1000.0*100)  )