# coding=utf-8
import sys, getopt
import os, shutil
import json
import io
import datetime

enableChecker = []
scanPath = ""
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

def analyzeWarning(warningLog, outputfile):
    global enableChecker
    with open(warningLog) as f:
        for lines in f:
            if 'warning:' in lines and '[-W' in lines:
                jsonTemp = {
                    "filePath": "",
                    "line": "",
                    "checkerName": "",
                    "description": ""
                }
                fileTemps = lines.split(':')
                for i in range(0, len(fileTemps)):
                    if fileTemps[i].strip().startswith('/') or fileTemps[i].strip().startswith('.'):
                        jsonTemp['filePath'] = fileTemps[i].strip()
                        if(i < len(fileTemps) - 1):
                            jsonTemp['line'] = fileTemps[i+1]
                            break
                warningTemps = lines.split('warning:')
                for warningTemp in warningTemps:
                    if '[-W' in warningTemp:
                        tags = warningTemp.split('[-W')
                        if len(tags) < 2:
                            print('description or checkerName will be lost')
                        else:
                            checker = tags[1].strip()[:-1]
                            if checker in enableChecker:
                                jsonTemp['description'] = tags[0]
                                jsonTemp['checkerName'] = checker
                        break
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

def deleteLog(warnLogLoc):
    if os.path.exists(warnLogLoc):
        os.remove(warnLogLoc)
        print("delete codecc-warning.log success.")
    else:
        print("codecc-warning.log not exists can't be deleted.")


def main(argv):
    inputfile = ''
    outputfile = ''
    try:
        opts, args = getopt.getopt(argv, "hi:o:", ["input=", "output="])
    except getopt.GetoptError:
        print('clangwarning.py --input <inputfile> --output <outputfile>')
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            print('clangwarning.py --input <inputfile> --output <outputfile>')
        elif opt in ("-i", "--input"):
            inputfile = arg
        elif opt in ("-o", "--output"):
            outputfile = arg
    loadInputJson(inputfile)

    global scanPath
    warnLogLoc = scanPath + "/codecc-warning.log"
    if not os.path.exists(warnLogLoc):
        print("--'codecc-warning.log' file not exists, please compile and generate again--")
    else:
        analyzeWarning(warnLogLoc, outputfile)
        deleteLog(warnLogLoc)

if __name__ == "__main__":
    main(sys.argv[1:])
