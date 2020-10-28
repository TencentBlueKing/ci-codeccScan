import json
import sys, getopt
sys.path.append('./third/')
import io
import os, shutil
from biplist import *

enableChecker = ""
checkerOptions = []
scanPath = ""
scanType = "full"
binPath = ""
subPath = ""
buildScript = ""
outputJson = {
    "code": 0,
    "message": "Scan begin",
    "defects": []
}

#load input.json file
def loadInputJson(inputFile):
    f = io.open(inputFile, encoding='utf-8')
    setting = json.load(f)
    #print(setting['openCheckers'])
    checkerCount = len(setting['openCheckers'])

    global enableChecker
    global checkerOptions
    for i in range(0, checkerCount):
        checkerName = setting['openCheckers'][i]['checkerName']
        enableChecker += " -enable-checker " + checkerName.replace("-", ".").replace("..", "-")

        ##checkerOption begin
        if 'checkerOptions' not in setting['openCheckers'][i]:
            continue
        ##checkerOption end

    if 'scanPath' in setting:
        global scanPath
        scanPath = setting['scanPath']

    if 'scanType' in setting:
        global scanType
        scanType = setting['scanType']
    
    if 'toolOptions' in setting and len(setting['toolOptions']) > 0:
        global binPath
        global buildScript
        for option in setting['toolOptions']:
            if 'optionName' in option and option['optionName'] == 'subPath':
                binPath = option['optionValue']
            if 'optionName' in option and option['optionName'] == 'SHELL':
                shellOption = option['optionValue'].split('\n')
                for s in range(0, len(shellOption)):
                    if shellOption[s].strip() != "":
                        if not shellOption[s].strip().startswith('#'):
                            buildScript = " " + shellOption[s]
                            break
     
    print("enableCheckers:" + enableChecker)

#analyze tmp plist files
def analyzePlist(tmpLogLoc, outputfile):
    global outputJson
    global scanPath
    for parent, dirnames, filenames in os.walk(tmpLogLoc):
        for filename in filenames:
            if filename.endswith('.plist'):
                plist = readPlist(parent + '/' + filename)
                if(plist['files'] != []):
                    for diagnostic in plist['diagnostics']:
                        jsonTemp = {
                        "filePath": plist['files'][0],
                        "line": diagnostic['location']['line'],
                        "checkerName": diagnostic['check_name'].replace("-", "--").replace(".", "-"),
                        "description": diagnostic['description']
                    }
                        outputJson['defects'].append(jsonTemp)
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

#remove plistTemp logs
def removePlist(tmpLogLoc):
    delList = os.listdir(tmpLogLoc)
    for f in delList:
        filePath = os.path.join(tmpLogLoc, f)
        if os.path.isfile(filePath):
            os.remove(filePath)
        elif os.path.isdir(filePath):
            shutil.rmtree(filePath)


#main function
def main(argv):
    inputfile = ''
    outputfile = ''
    try:
        opts, args = getopt.getopt(argv, "hi:o:", ["input=", "output="])
    except getopt.GetoptError:
        print('objcscan.py --input <inputfile> --output <outputfile>')
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            print('objcsan.py --input <inputfile> --output <outputfile>')
        elif opt in ("-i", "--input"):
            inputfile = arg
        elif opt in ("-o", "--output"):
            outputfile = arg
    loadInputJson(inputfile)

    global scanPath
    global subPath
    global binPath
    global buildScript
    #scanLoc = "/Users/codecc/Desktop/clang8.0-static-analyzer/bin/"
    tmpLogLoc = scanPath + "/tmp/"
    #tmpPath = scanLoc + tmpLogLoc
    if not os.path.exists(tmpLogLoc):
        os.makedirs(tmpLogLoc)
    else:
        removePlist(tmpLogLoc)

    scanCmd = binPath + "/scan-build -plist"
    disableAllCmd = "".join([
        " -disable-checker core.CallAndMessage -disable-checker core.DivideZero -disable-checker core.DynamicTypePropagation -disable-checker core.NonNullParamChecker -disable-checker core.NonnilStringConstants ",
        " -disable-checker core.NullDereference -disable-checker core.StackAddressEscape -disable-checker core.UndefinedBinaryOperatorResult -disable-checker core.VLASize ",
        " -disable-checker core.builtin.BuiltinFunctions -disable-checker core.builtin.NoReturnFunctions "
        " -disable-checker core.uninitialized.ArraySubscript -disable-checker core.uninitialized.Assign -disable-checker core.uninitialized.Branch -disable-checker core.uninitialized.CapturedBlockVariable ",
        " -disable-checker core.uninitialized.UndefReturn -disable-checker cplusplus.InnerPointer -disable-checker cplusplus.Move -disable-checker cplusplus.NewDelete ",
        " -disable-checker cplusplus.NewDeleteLeaks -disable-checker cplusplus.SelfAssignment -disable-checker deadcode.DeadStores -disable-checker nullability.NullPassedToNonnull ",
        " -disable-checker nullability.NullReturnedFromNonnull -disable-checker osx.API -disable-checker osx.NumberObjectConversion -disable-checker osx.OSObjectRetainCount ",
        " -disable-checker osx.ObjCProperty -disable-checker osx.SecKeychainAPI -disable-checker osx.cocoa.AtSync -disable-checker osx.cocoa.AutoreleaseWrite -disable-checker osx.cocoa.ClassRelease ",
        " -disable-checker osx.cocoa.Dealloc -disable-checker osx.cocoa.IncompatibleMethodTypes -disable-checker osx.cocoa.Loops -disable-checker osx.cocoa.MissingSuperCall -disable-checker osx.cocoa.NSAutoreleasePool ",
        " -disable-checker osx.cocoa.NSError -disable-checker osx.cocoa.NilArg -disable-checker osx.cocoa.NonNilReturnValue -disable-checker osx.cocoa.ObjCGenerics -disable-checker osx.cocoa.RetainCount ",
        " -disable-checker osx.cocoa.RunLoopAutoreleaseLeak -disable-checker osx.cocoa.SelfInit -disable-checker osx.cocoa.SuperDealloc -disable-checker osx.cocoa.UnusedIvars ",
        " -disable-checker osx.cocoa.VariadicMethodTypes -disable-checker osx.coreFoundation.CFError -disable-checker osx.coreFoundation.CFNumber -disable-checker osx.coreFoundation.CFRetainRelease ",
        " -disable-checker osx.coreFoundation.containers.OutOfBounds -disable-checker osx.coreFoundation.containers.PointerSizedValues -disable-checker security.insecureAPI.UncheckedReturn ",
        " -disable-checker security.insecureAPI.getpw -disable-checker security.insecureAPI.gets -disable-checker security.insecureAPI.mkstemp ",
        " -disable-checker security.insecureAPI.mktemp -disable-checker security.insecureAPI.vfork -disable-checker unix.API -disable-checker unix.Malloc -disable-checker unix.MallocSizeof ",
        " -disable-checker unix.MismatchedDeallocator -disable-checker unix.Vfork -disable-checker unix.cstring.BadSizeArg -disable-checker unix.cstring.NullArg "
    ])
    logOutCmd = " -o " + tmpLogLoc
    
    global enableChecker
    enableCheckerCmd = enableChecker
    
    print("command: " + scanCmd + disableAllCmd + logOutCmd + enableCheckerCmd + buildScript)
    os.system(scanCmd + disableAllCmd + logOutCmd + enableCheckerCmd + buildScript)

    analyzePlist(tmpLogLoc, outputfile)


if __name__ == "__main__":
    main(sys.argv[1:])