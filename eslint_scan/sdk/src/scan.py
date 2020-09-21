import sys
import os,re
import json
import subprocess
import config
import multiprocessing

options = {}

def foreach_file_list(scan_path_list, skip_path_list):
    file_list = []
    filenames = _ExpandDirectories(scan_path_list)
    for file_path in filenames:
        if check_path_match_skip(file_path, skip_path_list):
            file_list.append(file_path)
    return file_list

def _ExpandDirectories(filenames):
  expanded = set()
  for filename in filenames:
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
    if os.path.splitext(filename)[1][1:] in GetAllExtensions():
      filtered.append(filename)

  return filtered

def GetAllExtensions():
    return set(['vue','es6','js', 'ts', 'tsx'])

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
    
def scan(filename, config_path, third_rules, skip_path_list):
    file_defects = []
    cmd_result = []
    skip_option = ''
    for skip_path in skip_path_list:
        if '' != skip_path:
            skip_option += ' --ignore-pattern \"'+skip_path+'\"'
    cmd = "eslint --no-eslintrc -f json -c %s --rulesdir %s %s \"%s\" " % (config_path, third_rules, skip_option, filename)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            cmd_result.append(line)
    finally:
        p.terminate()
        p.wait()
    
    try:
        if ''.join(cmd_result) != '' and not 'No files matching the pattern' in ''.join(cmd_result):
            data = json.loads(''.join(cmd_result))
            for elem in data:
                if 'filePath' in elem and check_path_match_skip(elem['filePath'], skip_path_list):
                    if 'messages' in elem:
                        messages_info = elem['messages']
                        for msg in messages_info:
                            defect = {}
                            if 'line' in msg:
                                defect['line'] = msg['line']
                            if 'ruleId' in msg:
                                defect['checkerName'] = msg['ruleId']
                            if 'message' in msg:
                                defect['description'] = msg['message']
                            if 'filePath' in elem:
                                defect['filePath'] = elem['filePath']
                            if defect != {}:
                                file_defects.append(defect)
    except:
        print('pase failed file '+filename)
        
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
            
            #清除规则配置文件
            config.cleanup_rule_config
            
            #生成规则配置文件
            config_type = 'standard'
            config.generate_rule_config(config_type)
            config.merge_third_rule_config()

            if os.path.isfile(config.rule_config_file):
                #更新规则配置文件
                config.update_rule_config(input_data)
                
                #获取过滤路径列表
                if 'skipPaths' in input_data:
                    skip_path_list = input_data['skipPaths']
                
                scan_path_list = []
                #增量扫描
                if 'scanType' in input_data and input_data['scanType'] == 'increment':
                    for file_path in input_data['incrementalFiles']:
                        if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0 and check_path_match_skip(file_path, input_data['whitePathList']):
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
                    result_list[index] = process_analyze.apply_async(scan, (scan_path, config.rule_config_file, config.third_rules, skip_path_list),)
                process_analyze.close()
                process_analyze.join()  
                for result in result_list:
                    if not isinstance(result, int) and isinstance(result.get(), list) and len(result.get()) > 0:
                        all_file_defects.extend(result.get())
                    
            output_data['defects'] = all_file_defects
            if 'output' in options:
                with open(options['output'], 'w', encoding='utf-8') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')
