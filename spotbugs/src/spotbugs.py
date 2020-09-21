# encoding=utf-8
import sys, getopt
import os, shutil
import json
import io
import xml.dom.minidom
import platform

enableChecker = []
scanPath = ""
buildScript = ""
subPath = ""
outputJson = {
    "code": 0,
    "message": "scan begin",
    "defects": []
}

def loadInputJson(inputFile):
    f = io.open(inputFile, encoding='utf-8')
    setting = json.load(f)
    checkerCount = len(setting['openCheckers'])

    global enableChecker
    for i in range(0, checkerCount):
        checkerName = setting['openCheckers'][i]['checkerName']
        enableChecker.append(checkerName)
    print(enableChecker)

    if 'scanPath' in setting:
        global scanPath
        scanPath = setting['scanPath']
    
    if 'buildScript' in setting:
        global buildScript
        buildScript = setting['buildScript']
    
    if 'toolOptions' in setting and len(setting['toolOptions']) > 0:
        global subPath
        for option in setting['toolOptions']:
            if 'optionName' in option and option['optionName'] == 'subPath':
                subPath = option['optionValue']

def analyzeSpotBugs(spotBugsLog, outputfile):
    global enableChecker
    global scanPath
    allFiles = []
    for fpathe,dirs,fs in os.walk(scanPath):
        for f in fs:
            filename = os.path.join(fpathe,f)
            if filename.endswith(".java"):
                filename = filename.replace('\\', '/')
                allFiles.append(filename)

    dom = xml.dom.minidom.parse(spotBugsLog)
    root = dom.documentElement
    fileTags = root.getElementsByTagName('file')
    for f in fileTags:
        filePath = ""
        fileName = f.getAttribute('classname').strip()
        if fileName != "":
            fileName = fileName.replace('.', '/') + ".java"
        for afile in allFiles:
            if afile.strip().endswith(fileName):
                filePath = afile
                break
        for bug in f.getElementsByTagName('BugInstance'):
            jsonTemp = {
                "filePath": "",
                "line": "",
                "checkerName": "",
                "description": ""
            }
            jsonTemp['checkerName'] = bug.getAttribute('type').strip().replace('_', '-')
            if jsonTemp['checkerName'] not in enableChecker:
                continue
            jsonTemp['description'] = bug.getAttribute('message').strip()
            jsonTemp['line'] = bug.getAttribute('line').strip()
            try:
                if jsonTemp['line'] == "" or int(jsonTemp['line']) <= 0:
                    continue
            except ValueError:
                continue
            if platform.system() == "Windows":
                jsonTemp['filePath'] = ''.join(['/', filePath.replace(':', '')])
            else:
                jsonTemp['filePath'] = filePath
            if jsonTemp['checkerName'] != "" and jsonTemp['filePath'] != "" and jsonTemp['line'] != "" and jsonTemp['description'] != "":
                outputJson['defects'].append(jsonTemp)
    outputJson['defects'] = [dict(t) for t in set([tuple(d.items()) for d in outputJson['defects']])]
    outputJson['message'] = "scan complete"
    jsonData = json.dumps(outputJson)
    print(jsonData)
    filepath = os.path.dirname(outputfile)
    if not os.path.exists(filepath):
        os.makedirs(filepath)
    f = open(outputfile, 'w')
    f.write(jsonData)
    f.close()
    print('generate output file: ' + outputfile)

def deleteLogs(classFiles, spotBugsLog):
    if os.path.exists(classFiles):
        os.remove(classFiles)
        print("delete " + classFiles + " success.")
    if os.path.exists(spotBugsLog):
        os.remove(spotBugsLog)
        print("delete " + spotBugsLog + " success.")
    else:
        print(spotBugsLog + " not exists.")

def main(argv):
    inputfile = ''
    outputfile = ''
    try:
        opts, args = getopt.getopt(argv, "hi:o:", ["input=", "output="])
    except getopt.GetoptError:
        print('spotbugs.py --input <inputfile> --output <outputfile>')
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            print('spotbugs.py --input <inputfile> --output <outputfile>')
        elif opt in ("-i", "--input"):
            inputfile = arg
        elif opt in ("-o", "--output"):
            outputfile = arg
    loadInputJson(inputfile)

    global buildScript
    if buildScript != "":
        os.system(buildScript)

    global scanPath
    global subPath
    classFiles = scanPath + "/codecc-spotBugsClasses"
    allClasses = []
    for fpathe,dirs,fs in os.walk(scanPath):
        for f in fs:
            filename = os.path.join(fpathe,f)
            if filename.endswith(".class"):
                allClasses.append(filename)
    with open(classFiles, 'w') as f:
        for cla in allClasses:
            f.write(cla.strip() + '\n')

    spotBugsLog = scanPath + "/spotbugs.xml"
    command = "java -jar " + subPath + "/../lib/spotbugs.jar -textui -low -xdocs -output " + spotBugsLog + " -analyzeFromFile " + classFiles
    print("command: " + command)
    os.system(command)

    analyzeSpotBugs(spotBugsLog, outputfile)
    deleteLogs(classFiles, spotBugsLog)

if __name__ == "__main__":
    main(sys.argv[1:])