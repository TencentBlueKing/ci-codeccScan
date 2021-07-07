#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import re
import json

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    tosa_function_name_length = parse_option_info(option_info)
    for linenum in range(1, len(codeLineObj.raw_lines)):
        line = codeLineObj.raw_lines[linenum]
        regexp = r'\w+\s+(([\w_]+)::([\w_]+))|\w+\s+([\w_]+)\W*\('
        result = re.search(regexp, line, re.I)
        function_name = ""
        if not result:
            continue
        else:
            testString = result.group()
            if  "else" in line and "if" in line:
                continue
            elif "return" in testString or "="  in testString or "define" in line:
                continue
            splitArray = testString.rstrip('(').split(' ')
            if len(splitArray) == 1:
                function_name = splitArray[0]
            else:
                classFuncArray = splitArray[1].split("::")
                function_name = classFuncArray[len(classFuncArray)-1] 
        if len(function_name) > tosa_function_name_length:
            errorHandler(filePath, linenum, 'tosa/fn_name_length', 'function name too long, exceeds ' + str(tosa_function_name_length) + ' characters')

def parse_option_info(option_info):
    tosa_function_name_length = 35
    for option in json.loads(str(option_info)):
        if 'checkerOptionName' in option and option['checkerOptionName'] == 'fn-name-length':
            tosa_function_name_length = int(option['checkerOptionValue'])
            break
    return  tosa_function_name_length