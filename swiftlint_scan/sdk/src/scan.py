# encoding utf-8
import json
import sys, getopt
# import yaml
import os
import re
import logging
import ruamel.yaml

scanPath = ""
enableChecker = []
checkerOptions = []

## is or not is a number
def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        pass
 
    try:
        import unicodedata
        unicodedata.numeric(s)
        return True
    except (TypeError, ValueError):
        pass
 
    return False


def str_to_bool(str):
    return True if str.lower() == 'true' else False


def check_path_match_skip(file_path, skip_path_list):
    file_path = file_path.replace('\\', '/')
    no_skip = True
    try:
        for skip in skip_path_list:
            if re.search(skip, file_path):
                return False
    except:
        pass
    return no_skip

## loadInput and generate .swiftlint.yml to project path
def loadInputJson(inputFile):
    f = open(inputFile, encoding='utf-8')
    setting = json.load(f)
    checkerCount = len(setting['openCheckers'])

    ## 初始化规则信息
    global enableChecker
    global checkerOptions
    for i in range(0, checkerCount):
        checkerInfo = setting['openCheckers'][i]
        enableChecker.append(checkerInfo['checkerName'])

        if 'checkerOptions' not in checkerInfo:
            continue
        checkerOptionCount = len(checkerInfo['checkerOptions'])
        # print("checkerOptionCount: " + str(checkerOptionCount))
        checkerName = checkerInfo['checkerName']
        checkerOptionList = {}
        for j in range(0, checkerOptionCount):
            checkerOptionName = checkerInfo['checkerOptions'][j]['checkerOptionName']
            checkerOptionValue = checkerInfo['checkerOptions'][j]['checkerOptionValue']
            if is_number(checkerOptionValue):
                checkerOptionValue = int(checkerOptionValue)
            elif checkerOptionValue in ["true", "false"]:
                checkerOptionValue = bool(checkerOptionValue)
            checkerOptionList[checkerOptionName] = checkerOptionValue
        checkerOptions.append({'key': checkerName, 'value': checkerOptionList})
    
    config = {}
    config['only_rules'] = enableChecker
    for option in checkerOptions:
        config[option['key']] = option['value']

    ## 初始化路径白名单
    white_path_list = []
    #增量扫描
    if 'scanType' in setting and setting['scanType'] == 'increment':
        for file_path in setting['incrementalFiles']:
            if 'whitePathList' in setting and len(setting['whitePathList']) > 0 \
                and check_path_match_skip(file_path, setting['whitePathList']):
                continue
            white_path_list.append(file_path)
    #全量扫描
    elif 'scanType' in setting and setting['scanType'] == 'full':
        if 'whitePathList' in setting and len(setting['whitePathList']) > 0:
            for white_path in setting['whitePathList']:
                if os.path.isdir(white_path) or os.path.isfile(white_path):
                    white_path_list.append(white_path)
        elif 'scanPath' in setting and os.path.isdir(setting['scanPath']):
            white_path_list.append(setting['scanPath'])

    config['included'] = white_path_list

    ## 初始化路径黑名单
    # skipPaths = []
    # S = ruamel.yaml.scalarstring.DoubleQuotedScalarString
    # for skipPth in setting['skipPaths']:
    #     skipPaths.append(S(skipPth))
    # config['excluded'] = skipPaths
    # config['excluded'] = setting['skipPaths']

    config['reporter'] = "json"

    global scanPath
    if 'scanPath' in setting:
        scanPath = setting['scanPath']
    file = open(scanPath + "/.swiftlint.yml", 'w', encoding='utf-8')
    yaml = ruamel.yaml.YAML()

    yaml.indent(mapping=4, sequence=2, offset=2)

    yaml.dump(config, file)
    file.close()

def analyzeFromFile(logFile, outputfile):
    result = {
        "code": 0,
        "message": "swiftlint scan completed!",
        "defects": []
    }
    if os.path.exists(logFile):
        if not os.path.getsize(logFile):
            print(logFile, " is empty!")
        else:
            f = open(logFile, encoding='utf-8')
            try:
                defects = json.load(f)
                defectsCount = len(defects)
                for i in range(0, defectsCount):
                    res = {}
                    res["filePath"] = defects[i]["file"].replace('\\', '')
                    res["line"] = defects[i]["line"]
                    res["checkerName"] = defects[i]["rule_id"]
                    res["description"] = defects[i]["reason"]
                    result["defects"].append(res)
            except Exception as e:
                logging.exception(e)
    jsonData = json.dumps(result)
    file = open(outputfile, 'w', encoding='utf-8')
    file.write(jsonData)
    file.close()

def printUsage(cmdName):
    print("Usage %s --input=<inputfile> --output=<outputfile>" % cmdName)
    print('--input: the file path of input the json file for tool to scan')
    print('--output: the file path of output the result')

def main(argv):
    if len(argv) <= 2:
        printUsage(argv[0])
    else:
        inputfile = ''
        outputfile = ''
        try:
            opts, args = getopt.getopt(argv[1:], "hi:o:", ["input=","output="])
        except getopt.GetoptError:
            printUsage(argv[0])
            sys.exit(2)
        for opt, arg in opts:
            if opt == '-h':
                printUsage(argv[0])
                sys.exit()
            elif opt in ("-i", "--input"):
                inputfile = arg
            elif opt in ("-o", "--output"):
                outputfile = arg

        #获取input数据
        if not inputfile is None and os.path.isfile(inputfile):
            loadInputJson(inputfile)
            logFile = scanPath + "/codecc-swiftlint.json"
            appCmd = "swiftlint > " + logFile

            print("command: " + appCmd)
            ## swiftlint only check in project dir
            os.chdir(scanPath)
            os.system("pwd")
            print("enter path: " + scanPath)
            os.system(appCmd)

            analyzeFromFile(logFile, outputfile)


if __name__ == "__main__":
    main(sys.argv)