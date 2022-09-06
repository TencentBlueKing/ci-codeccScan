import getopt
import json
import os
import sys
import xml
from xml.dom.minidom import Document
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
windToolPath = "C:\\data\\codecc_software\\resharper_scan\\tool\\inspectcode.exe  "


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

    if 'skipPaths' in jsonData:
        global skipPath
        skipPath = jsonData['skipPaths']

    print("enable checkers:" + str(enableChecker))
    print("checkerOptions:" + str(checkerOptions))

    file.close()


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


def executeResharperScanAndOutputFile(outputFile):
    print("start execute resharper tool scan")
    slnPath = str(getProjectClnPath(scanPath))
    print("sln path : " + slnPath)
    if slnPath == "":
        errorDefect = DefectPkg()
        errorDefect.code = 500
        errorDefect.message = "没有找到解决方案.sln路径！"
        writeOutputJson(outputFile, errorDefect)
        return
    xmlFile = str(slnPath.__hash__()) + ".xml"
    runCmd = windToolPath + "  " + slnPath + "  --jobs=4 --build --format=xml --output=" + xmlFile
    print("run cmd: " + runCmd)
    os.system(runCmd)
    print("resharper tool execute complete")
    print("start parsing the exported xml file")
    defect = DefectPkg()
    xmlFileOpen = open(xmlFile, encoding="utf-8")
    dom = xml.dom.minidom.parse(xmlFileOpen)
    elements = dom.documentElement
    ele = elements.getElementsByTagName("Issue")
    projectPath = str(slnPath)[0:slnPath.rindex("\\")]
    for e in ele:
        typeId = e.getAttribute("TypeId")
        if typeId in enableChecker:
            obj = DefectObj()
            filePath = str(e.getAttribute("File"))
            if not filePath.startswith(scanPath):
                filePath = projectPath + "\\" + filePath
            obj.filePath = filePath
            obj.checkerName = typeId
            obj.description = e.getAttribute("Message")
            if e.hasAttribute("Line"):
                obj.line = e.getAttribute("Line")
            else:
                obj.line = 0
            defect.defects.append(obj)
    xmlFileOpen.close()
    print("defect length: " + str(len(defect.defects)))
    writeOutputJson(outputFile, defect)


def writeOutputJson(filePath, defectData):
    print("start write output.json")
    openFile = open(str(filePath), "w")
    outString = json.dumps(defectData, default=lambda obj: obj.__dict__)
    openFile.write(outString)
    openFile.close()
    print("output.json write complete")


def getProjectClnPath(path):
    filePath = ""
    outPath = [path + "\\.git", path + "\\.temp"]
    for root, dirs, files in os.walk(path):
        if str(root).startswith(outPath[1]) or str(root).startswith(outPath[0]):
            continue
        for file in files:
            if str(file).endswith(".sln"):
                filePath = root + "\\" + file
        if filePath != "":
            break
    return filePath


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
    executeResharperScanAndOutputFile(outputJsonFile)


if __name__ == "__main__":
    main(sys.argv[1:])
