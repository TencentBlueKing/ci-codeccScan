import sys
import os
import re
import json
import subprocess
import config
import multiprocessing
from threading import Timer

options = {}

def find_scm_dir_path(file_folder_path, scm_type):
    scm_dir = file_folder_path
    while True:
        if scm_dir == '/':
            return ""
        scm_dir += '/.'+scm_type
        if os.path.isdir(scm_dir):
            break
        elif os.path.isfile(scm_dir):
            break
        else:
            scm_dir = os.path.dirname(os.path.dirname(scm_dir))
    return os.path.dirname(scm_dir)

class ExpandDirectories(object):

    def __init__(self, filenames):
        self.filenames = filenames

    def expand_dirs(self):
        expanded = set()
        for filename in self.filenames:
            if not os.path.isdir(filename):
                expanded.add(filename)
                continue

            for root, _, files in os.walk(filename):
                for loopfile in files:
                    fullname = os.path.join(root, loopfile)
                    if fullname.startswith('.' + os.path.sep):
                        fullname = fullname[len('.' + os.path.sep):]
                    expanded.add(fullname)

        filtered = []
        for filename in expanded:
            if os.path.splitext(filename)[1][1:] in self.get_all_extensions():
                filtered.append(filename)

        return filtered

    def get_all_extensions(self):
        return set(['c++','cc','CPP','cpp','cxx','pcc','H','h','hh','hpp','hxx'])

def foreach_file_list(scan_path_list, skip_path_list):
    file_list = []
    exdirs = ExpandDirectories(scan_path_list)
    filenames = exdirs.expand_dirs()
    for file_path in filenames:
        if check_path_match_skip(file_path, skip_path_list):
            file_list.append(file_path)
    return file_list

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
    
def scan(filename, config_path, third_rules, skip_path_list, root_path):
    file_defects = []
    cmd_result = []
    cmd = ''
    # if 'PY27_PATH' in os.environ:
    #     os.environ['PATH'] = os.environ['PY27_PATH']+os.pathsep+os.environ['PATH']
    if os.path.isdir(filename):
        cmd = "python3 %s/../../tool/cpplint_external.py --output=codecc --root=%s --cfg=%s \
              --third-rule-path=%s --recursive \"%s\" " % \
              (config.current_path, root_path, config.rule_config_file, third_rules, filename)
    else:
        cmd = "python3 %s/../../tool/cpplint_external.py --output=codecc --root=%s --cfg=%s \
              --third-rule-path=%s \"%s\" " % \
              (config.current_path, root_path, config.rule_config_file, third_rules, filename)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    try:
        timer = Timer(60, p.kill)
        timer.start()
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            if '->' in line and not 'Done processing' in line:
                cmd_result.append(line)
    finally:
        timer.cancel()
        p.terminate()
        p.wait()
    
    for elem in cmd_result:
        error_smg = elem.split('->')
        if os.path.isfile(error_smg[0]) and check_path_match_skip(error_smg[0], skip_path_list) \
           and str(error_smg[1]) != 'None':
            defect = {}
            defect['filePath'] = error_smg[0]
            defect['line'] = error_smg[1]
            defect['checkerName'] = error_smg[2]
            defect['description'] = error_smg[3]
            if defect != {}:
                file_defects.append(defect)
    return file_defects

if __name__ == "__main__" :
    if len(sys.argv) > 2:
        input_data = {}
        output_data = {}
        skip_path_list = []
        all_file_defects = []
        project_name = " "
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

            if os.path.isfile(config.rule_config_file):
                #更新规则配置文件
                config.update_rule_config(input_data)
                
                #获取过滤路径列表
                if 'skipPaths' in input_data:
                    skip_path_list = input_data['skipPaths']
                
                scan_path_list = []

                #get program_name
                if 'repos' in input_data and input_data['repos'] != []:
                    repos = input_data['repos'][0]
                    if "git" in repos['scmType']:
                        project_name = repos['url'].split('/')[-1].split('.git')[0]
                        print("git_project_name: " + project_name)
                    else:
                        project_name = repos['url'].split('/')[-1].split('_proj')[0]
                        print("svn_project_name: " + project_name)

                #增量扫描
                if 'scanType' in input_data and input_data['scanType'] == 'increment':
                    for file_path in input_data['incrementalFiles']:
                        if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0 \
                            and check_path_match_skip(file_path, input_data['whitePathList']):
                            continue
                        scan_path_list.append(file_path)
                #全量扫描
                elif 'scanType' in input_data and input_data['scanType'] == 'full':
                    if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0:
                        for white_path in input_data['whitePathList']:
                            if os.path.isdir(white_path) or os.path.isfile(white_path):
                                scan_path_list.append(white_path)
                    elif 'scanPath' in input_data and os.path.isdir(input_data['scanPath']):
                        scan_path_list.append(input_data['scanPath'])
                
                scan_file_path_list = foreach_file_list(scan_path_list, skip_path_list)
                pool_processes = 1
                if multiprocessing:
                    pool_processes = multiprocessing.cpu_count()
                process_analyze = multiprocessing.Pool(processes = int(pool_processes))
                result_list = [i for i in range(len(scan_file_path_list))]
                for index, scan_path in enumerate(scan_file_path_list):
                    # root_path = input_data['scanPath']
                    # root_path_git = find_scm_dir_path(scan_path, 'git')
                    # if root_path_git != '':
                    #     root_path = root_path_git
                    # else:
                    #     root_path_svn = find_scm_dir_path(scan_path, 'svn')
                    #     if root_path_svn != '':
                    #         root_path = root_path_svn
                    result_list[index] = process_analyze.apply_async(scan, (scan_path, config.rule_config_file, \
                                                                     config.third_rules, skip_path_list, project_name),)
                process_analyze.close()
                process_analyze.join()
                for result in result_list:
                    try:
                        if not isinstance(result, int) and isinstance(result.get(), list) and len(result.get()) > 0:
                            all_file_defects.extend(result.get())
                    except:
                        pass
                    
            output_data['defects'] = all_file_defects
            if 'output' in options:
                with open(options['output'], 'w') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
        print("Usage %s --xxx=xxx" % sys.argv[0])
        print('--input: the file path of input the json file for tool to scan')
        print('--output the file path of output the result')