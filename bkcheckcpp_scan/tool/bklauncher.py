import json
import sys, getopt
import yaml
import os
import multiprocessing

enableChecker = ""
checkerOptions = []
incrementalFiles = ""
scanPath = " "
scanType = "full"

def loadInputJson(inputFile):
    f = open(inputFile, encoding='utf-8')
    setting = json.load(f)
    #print(setting)
    checkerCount = len(setting['openCheckers'])

    global enableChecker
    global checkerOptions
    for i in range(0, checkerCount):
        enableChecker += setting['openCheckers'][i]['checkerName']
        if i+1 != checkerCount:
            enableChecker += ","

        #print("i="+str(i))
        if 'checkerOptions' not in setting['openCheckers'][i]:
            continue
        checkerOptionCount = len(setting['openCheckers'][i]['checkerOptions'])
        print("checkerOptionCount:" + str(checkerOptionCount))
        for j in range(0, checkerOptionCount):
            checkerName = setting['openCheckers'][i]['checkerName']
            checkerOptionName = setting['openCheckers'][i]['checkerOptions'][j]['checkerOptionName']
            checkerOptionValue = setting['openCheckers'][i]['checkerOptions'][j]['checkerOptionValue']
            checkerOptions.append({'key':checkerName+"."+checkerOptionName, 'value':checkerOptionValue})

    if 'incrementalFiles' in setting:
        global incrementalFiles
        incrementalFilesCount = len(setting['incrementalFiles'])
        for i in range(incrementalFilesCount):
            incrementalFiles += setting['incrementalFiles'][i].strip()
            if i+1 != incrementalFilesCount:
                incrementalFiles += ","

    if 'scanPath' in setting:
        global scanPath
        scanPath = setting['scanPath']

    if 'scanType' in setting:
        global scanType
        scanType = setting['scanType']

    print("enable checkers:" + enableChecker)
    print("checkerOptions:" + str(checkerOptions))

def writeYamlConfig():

    file = open("bkcheck_cpp_config.yml", 'w', encoding='utf-8')

    global checkerOptions
    global enableChecker
    global incrementalFiles
    config = {'CheckOptions':checkerOptions, 'Checks':enableChecker, 'IncrmentFiles':incrementalFiles}
    yaml.dump(config, file)
    file.close()


def main(argv):
   inputfile = ''
   outputfile = ''
   try:
      opts, args = getopt.getopt(argv,"hi:o:",["input=","output="])
   except getopt.GetoptError:
      print ('bklauncher.py --input <inputfile> --output <outputfile>')
      sys.exit(2)
   for opt, arg in opts:
      if opt == '-h':
         print ('bklauncher.py --input <inputfile> --output <outputfile>')
         sys.exit()
      elif opt in ("-i", "--input"):
         inputfile = arg
      elif opt in ("-o", "--output"):
         outputfile = arg
   loadInputJson(inputfile)
   writeYamlConfig()

   appCmd = "java -jar /usr/codecc/tool_scan/bkcheck/cpp/bkcheck-cpp.jar "
   outputCmd = " --output " + outputfile
   formatCmd = " --format json "
   configCmd = " --config bkcheck_cpp_config.yml "
   threadNum = " -j 4 " 
   fileCmd = ""

   global scanType
   if scanType == "full":
       fileCmd = scanPath

   
   print("cpu_count:" + str(multiprocessing.cpu_count()));
   print("command:" + appCmd + outputCmd + formatCmd + configCmd + threadNum  + fileCmd)
   os.system(appCmd + outputCmd + formatCmd + configCmd + fileCmd)

if __name__ == "__main__":
   main(sys.argv[1:])
