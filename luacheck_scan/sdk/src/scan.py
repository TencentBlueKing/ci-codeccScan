# 保存执行的规范 使用 --enable选项
import getopt
import json
import os
import re
import sys
import time
from os import walk

enableChecker = []
checkerOptions = []
incrementalFiles = ""
# 保存扫描路径 工具路径忽略有问题，暂时不支持
scanPath = " "
scanType = "full"
# 忽略扫描路径
skipPath = []
projName = ""


def loadInputJson(inputJson):
    file = open(inputJson, encoding="UTF-8")
    jsonData = json.load(file)
    print(jsonData)
    checkCount = len(jsonData["openCheckers"])
    global projName
    projName = jsonData["projName"]

    global enableChecker
    global checkerOptions

    for i in range(0, checkCount):
        enableChecker.append(jsonData["openCheckers"][i]["checkerName"])

        if "checkerOptions" not in jsonData["openCheckers"][i]:
            continue

        checkerOptionsCount = len(jsonData["openCheckers"][i]["checkerOptions"])
        print("checkerOptionsCount: " + str(checkerOptionsCount))
        for check in range(0, checkerOptionsCount):
            checkName = jsonData["openCheckers"][i]["checkerName"]
            checkerOptionsName = jsonData["openCheckers"][i]["checkerOptions"][check]["checkerOptionName"]
            checkerOptionsValue = jsonData["openCheckers"][i]["checkerOptions"][check]["checkerOptionValue"]
            checkerOptions.append({"key": checkName + "." + checkerOptionsName,
                                   "value": checkerOptionsValue})

    if 'incrementalFiles' in jsonData:
        global incrementalFiles
        incrementalFilesCount = len(jsonData['incrementalFiles'])
        for i in range(incrementalFilesCount):
            if jsonData['incrementalFiles'][i].endswith('.py'):
                incrementalFiles += jsonData['incrementalFiles'][i] + " "

    if 'scanPath' in jsonData:
        global scanPath
        scanPath = jsonData['scanPath']

    if 'scanType' in jsonData:
        global scanType
        scanType = jsonData['scanType']

    # if 'skipPaths' in jsonData:
    #     global skipPath
    #     skipPath = jsonData['skipPaths']

    print("enable checkers:" + str(enableChecker))
    print("checkerOptions:" + str(checkerOptions))

    file.close()


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


def get_luacheckrc_path(path):
    filePath = ""
    for root, dirs, files in walk(path):
        for file in files:
            if str(file).endswith(".luacheckrc"):
                filePath = root + "/" + file
        if filePath != "":
            break
    return filePath


def parsingPerformLog(fileName):
    print("start parsing perform log file: " + fileName)
    defectPackage = DefectPkg()
    try:
        file = open(fileName, encoding="UTF-8")
        parsingFileName = ""
        while True:
            line = str(file.readline())
            if line == "" or line.startswith("Total"):
                break
            lineLen = len(line)
            if lineLen == 1:
                continue

            line = line.replace('\\', '/')
            if line.startswith("Checking"):
                find = line.find(".lua", 0, lineLen)
                parsingFileName = line[9:find + 4]
                continue
            defect = DefectObj()
            defect.filePath = parsingFileName

            left = 0
            mao = 0
            for i in range(len(parsingFileName), lineLen):
                if line[i] == "(":
                    left = i
                elif line[i] == ")":
                    defect.checkerName = line[left + 1:i]
                    defect.description = line[i + 2:lineLen - 1]
                    defectPackage.defects.append(defect)
                    break
                elif line[i] == ":":
                    if mao == 0:
                        mao = i
                    elif defect.line == 0:
                        defect.line = line[mao + 1:i]
        defectPackage.code = 200
        defectPackage.message = "Scan complete!"
        file.close()
    except getopt.GetoptError:
        print("parsing perform log is failure")
        defectPackage.code = 500
        defectPackage.message = "Scan failure!!!"
    print("parsing perform log complete")
    return defectPackage


class DefectObj(object):
    def __init__(self):
        self.filePath = ''
        self.line = 0
        self.checkerName = ''
        self.description = ''


class DefectPkg(object):
    def __init__(self):
        self.code = 0
        self.message = ''
        self.defects = list()


def createFileLog(defectPkg, outputFileName):
    file = open(str(outputFileName), "w")
    outString = json.dumps(defectPkg, default=lambda obj: obj.__dict__)
    file.write(outString)
    file.close()
    print("output.json create complete")


def main(argv):
    inputJsonFile = ""
    outputJsonFile = ""

    try:
        opts, args = getopt.getopt(argv, "hi:o:", ["input=", "output="])
    except getopt.GetoptError:
        print('scan.py -i <inputfile> -o <outputfile> or --input <inputfile> -- output <output.json>')
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            print('scan.py -i <inputfile> -o <outputfile> or --input <inputfile> -- output <output.json>')
            sys.exit()
        elif opt in ("-i", "--input"):
            inputJsonFile = arg
        elif opt in ("-o", "--output"):
            outputJsonFile = arg
    if inputJsonFile == "" or outputJsonFile == "":
        print('scan.py -i <inputfile> -o <outputfile> or --input <inputfile> -- output <output.json>')
        sys.exit()

    loadInputJson(inputJsonFile)

    appCmd = "luacheck "
    codeCmd = " --codes --no-cache --no-color "
    configFileCmd = " --config "
    configPath = get_luacheckrc_path(scanPath)
    if configPath != "":
        configFileCmd = configFileCmd + configPath
    else:
        configFileCmd = ""
    enableCmd = " --only ["
    enableCheckerCount = len(enableChecker)
    # 因为如果使用str直接将数组输出的话，元素中间会有空格，这会导致luacheck无法执行
    # 所以使用for循环添加 skip一样
    isEnable = False
    if enableCheckerCount > 0:
        isEnable = True
        for index in range(0, enableCheckerCount):
            # 只能过滤警告不能过滤错误
            if enableChecker[index].startswith("E"):
                continue
            enableCmd += enableChecker[index][1:]
            if index + 1 != enableCheckerCount:
                enableCmd += ","
        enableCmd += "] "
    # 工具文件忽略有问题，暂时忽略掉文件过滤
    # skipCmd = " --exclude-files ["
    # isSkip = False
    # skipPathCount = len(skipPath)
    # if skipPathCount > 0:
    #     isSkip = True
    #     for i in range(0, skipPathCount):
    #         skipCmd += ("'" + skipPath[i] + "'")
    #         if i + 1 != skipPathCount:
    #             skipCmd += ','
    #     skipCmd += "]"
    configCmd = ""
    for i in range(0, len(checkerOptions)):
        options = checkerOptions[i]
        key = options.get("key")
        value = options.get("value")
        # 最大行长：
        if key == "W631.lineMax":
            configCmd += (" --max-line-length" + " " + value)
        # 以代码结尾的行最大长度
        elif key == "W631.codeMax":
            configCmd += (" --max-code-line-length" + " " + value)
        # 设置字符串中行的最大允许长度
        elif key == "W631.stringMax":
            configCmd += (" -max-string-line-length" + " " + value)
        # 设置注释行的最大长度
        elif key == "W631.commentMax":
            configCmd += (" --max-comment-line-length" + " " + value)
        # 设置函数最大的复杂度
        elif key == "W561.max":
            configCmd += (" --max-cyclomatic-complexity" + " " + value)

    runCmd = appCmd + codeCmd + scanPath + configFileCmd
    if isEnable:
        runCmd += enableCmd
    # if isSkip:
    #     runCmd += skipCmd

    ti = time.time()
    newTime = round(ti * 1000)
    logFileName = scanPath + "/luacheck-codecc-" + projName + "-" + str(newTime) + ".log"
    print("log file name is :" + logFileName)
    runCmd += " | tee " + logFileName
    print("cmd : " + runCmd)

    os.system(runCmd)

    parsingData = parsingPerformLog(logFileName)
    createFileLog(parsingData, outputJsonFile)


if __name__ == "__main__":
    main(sys.argv[1:])
