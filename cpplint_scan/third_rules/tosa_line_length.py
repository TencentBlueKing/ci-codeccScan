
#!/usr/bin/env python
# -*- coding:utf-8 -*-
# Author:Camel
import json

def runChecker(filePath, codeLineObj, errorHandler, option_info):
    count = 0
    tosa_line_length = parse_option_info(option_info)
    for line in codeLineObj.raw_lines:
        count = count + 1
        if len(line.strip()) > tosa_line_length:
            errorHandler(filePath, count-1, 'tosa/line_length', 'Line length exceeds ' + str(tosa_line_length) + ' characters')

def parse_option_info(option_info):
    tosa_line_length = 120
    for option in json.loads(str(option_info)):
        if 'checkerOptionName' in option and option['checkerOptionName'] == 'line-length':
            tosa_line_length = int(option['checkerOptionValue'])
            break
    return  tosa_line_length
