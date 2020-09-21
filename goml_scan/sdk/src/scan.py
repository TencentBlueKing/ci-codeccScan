import sys
import os,re
import json
import subprocess
import config
import re
import traceback

bug_arrary = set([])
options = {}
default_disable_linter = ''
build_failed_disable_linter = ''
go_build_faild_skip_error=['cannot find package', 'invalid operation:', 'cannot range over']
default_skip_linter = ['lll', 'gocyclo', 'testify', 'test', 'dupl', 'gotypex', 'megacheck', 'goimports']
for linter in default_skip_linter:
    default_disable_linter += " --disable="+linter+" "
go_build_faild_skip_linter=['maligned','varcheck','structcheck','unparam','errcheck','gotype','interfacer','unconvert'] 
for linter in go_build_faild_skip_linter:
    build_failed_disable_linter += " --disable="+linter+" " 
os.environ["GO15VENDOREXPERIMENT"]='1'

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
    
def transate_line(line):
    line = line.replace('->vet->', '->vet->vet/vet->')
    if '->gas->' == line and ",xxx" in line:
        line = line.replace(',xxx', '')
    return line

def build_error_check(result):
    
    if '->gotype->' == result and "could not import" in result:
        return True
    
    if "error:" in result and "No such file or directory" in result:
        return True
        
    if "unknown field" in result and "struct literal" in result:
        return True
        
    if "not declared by package" in result:
        return True 
    
    if "package" in result and "expected" in result:
        return True 
        
    if result.count('->') != 4:
        return True
        
    #对内容重复的告警进行去重
    if result in bug_arrary:
        return True
    else:
        bug_arrary.add(result)

    #过滤编译失败出现的无效告警
    for go_build_failed_error in go_build_faild_skip_error:
        if go_build_failed_error in result:
            return True
    
    #去除默认屏蔽linter告警：
    for skip_check in default_skip_linter:
        if '->'+skip_check+'->' in result:
            return True         
    
    for skip_check in go_build_faild_skip_linter:
        if '->'+skip_check+'->' in result:
            return True
    
    #实现自定义过滤规则
    data = result.split('->')
    check = data.pop(3) 
    if not check in config.checkers_list:
        return True
    
    return False

def scan(filename, third_rules, skip_path_list):
    file_defects = []
    cmd_result = []
    skip_option = ''
    for skip_path in skip_path_list:
        if '' != skip_path:
            skip_option += ' --skip=\"'+skip_path+'\"'
    if os.path.isdir(filename):
        cmd = "gometalinter %s/... --sort=path --deadline=60m --format={{.Path.Abs}}'->'{{.Line}}'->'{{.Linter}}'->'{{.Message}} --enable-all %s %s %s %s --exclude=vendor -j 2 ; nakedret %s" % (filename, skip_option, config.checker_options, default_disable_linter, build_failed_disable_linter, filename)
    else:
        cmd = "gometalinter %s --sort=path --deadline=60m --format={{.Path.Abs}}'->'{{.Line}}'->'{{.Linter}}'->'{{.Message}} --enable-all %s %s %s %s --exclude=vendor -j 2 ; nakedret %s" % (filename, skip_option, config.checker_options, default_disable_linter, build_failed_disable_linter, filename)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            try:
                line = bytes.decode(line.strip()) 
                line = transate_line(line)
                if '->' in line and not build_error_check(line):
                    cmd_result.append(line)
            except:
                pass
    finally:
        p.terminate()
        p.wait()

    for data in cmd_result:
        data = data.split('->')
        if check_path_match_skip(data[0], skip_path_list):
            if not os.path.exists(data[0]): continue
            defect = {}
            defect['filePath'] = data[0]
            defect['line'] = data[1]
            defect['checkerName'] = data[3]
            defect['description'] = data[4]
            if defect != {}:
                file_defects.append(defect)
    
    return file_defects

if __name__ == "__main__" :
    if len(sys.argv) > 2:
        input_data = {}
        output_data = {}
        skip_path_list = []
        all_file_defects = []
        for i in range(len(sys.argv)-1):
            if not "=" in sys.argv[i+1] or not "--" in sys.argv[i+1]:
                print("Usage %s --xxx=xxx" % sys.argv[0])
                sys.exit()
        for i in range(len(sys.argv)-1):
            tmp = sys.argv[i+1].split("=",1)
            options[tmp[0].replace("--","")] = str(tmp[1]).strip()
        if 'input' in options and os.path.isfile(options['input']):
            #获取input数据
            with open(options['input'], 'r', encoding='utf-8') as file:
                input_data = json.load(file) 

            #更新规则配置文件
            config.update_rule_config(input_data)
            
            #设置GOPATH
            workspace = input_data['scanPath']
            if 'toolOptions' in input_data:
                for option in input_data['toolOptions']:
                    if 'optionName' in option and 'go_path' in option['optionName']:
                        workspace += '/'+option['optionValue']
                        break
            os.environ["GOPATH"] = workspace

            goml_path = config.current_path+'/../../tool/gometalinter/bin'
            if os.path.exists(goml_path):
                for item in os.listdir(goml_path):  
                    itemsrc=os.path.join(goml_path,item) 
                    os.chmod(itemsrc, 0o755)
                os.environ['PATH'] =  goml_path + os.pathsep +os.environ['PATH']

            #获取过滤路径列表
            if 'skipPaths' in input_data:
                skip_path_list = input_data['skipPaths']

            scan_path_list = []
            #全量扫描
            if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0:
                for white_path in input_data['whitePathList']:
                    if os.path.isdir(white_path) or os.path.isfile(white_path):
                        scan_path_list.append(white_path)
            elif 'scanPath' in input_data and os.path.isdir(input_data['scanPath']):
                scan_path_list.append(input_data['scanPath'])

            for scan_path in scan_path_list:
                file_defects = scan(scan_path, config.third_rules, skip_path_list)
                if len(file_defects) > 0:
                    all_file_defects.extend(file_defects)
                    
            output_data['defects'] = all_file_defects
            if 'output' in options:
                with open(options['output'], 'w') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')