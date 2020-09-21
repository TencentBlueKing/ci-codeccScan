import sys
import os,re
import json
import subprocess
import multiprocessing
from threading import Timer

current_path = ''
options = {}
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

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
    return set(['cs','c','C','c++','cc','CPP','cpp','cxx','pcc','H','h','hh','hpp','hxx','java','php','php3','php4','php5','phtml','vue','rb','go','Swift','m','mm','py','pyw','es6','js','ts','tsx'])

def foreach_file_list(scan_path_list, skip_path_list):
    file_list = []
    filenames = _ExpandDirectories(scan_path_list)
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
    
def scan(filename, ccn_number, skip_path_list):
    file_ccn_info = {}
    file_defects = []
    cmd_result = []
    cmd = "python3 %s/../../tool/lizard/lizard.py \"%s\" -w -C %s -L 100000 " % (current_path, filename, ccn_number)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        timer = Timer(60, p.kill)
        timer.start()
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            cmd_result.append(line)
    finally:
        timer.cancel()
        p.terminate()
        p.wait()

    for elem in cmd_result:
        try:
            if '->' in elem and os.path.exists(elem.split('->',1)[0]) and check_path_match_skip(elem.split('->',1)[0], skip_path_list):
                ccn_function_list = elem.split('->')
                if len(ccn_function_list) != 7:
                    continue
                defect = {}
                defect['filePath']=ccn_function_list[0].replace('//','/') #filename
                defect['function_name']=ccn_function_list[1] #function_name
                defect['long_name']=ccn_function_list[2] #function_long_name
                defect['function_lines']=ccn_function_list[3] #function_lines
                defect['startLine']=ccn_function_list[3].split('-') [0]#function_lines
                defect['endLine']=ccn_function_list[3].split('-') [1] #function_lines
                defect['total_lines']=ccn_function_list[4] #total_lines
                defect['ccn']=ccn_function_list[5] #ccn
                defect['condition_lines']=ccn_function_list[6].replace(' ', '').replace('{','').replace('}','') #condition_lines
                file_defects.append(defect)
            elif ':' in elem and os.path.exists(elem.split(':', 1)[0]) and check_path_match_skip(elem.split(':', 1)[0], skip_path_list):
                ccn_list = elem.split(':')
                if len(ccn_list) != 2:
                    continue
                ccn_summary = {}
                ccn_summary['file_path'] = ccn_list[0] #filename
                ccn_summary['total_ccn_count'] = ccn_list[1] #total_ccn
                file_ccn_info['files_ccn'] = ccn_summary
        except:
            print('pase filed '+elem)
            
    file_ccn_info['file_defects'] = file_defects
    return file_ccn_info

def ts_scan(filename, ccn_number, skip_path_list):
    file_ccn_info = {}
    file_defects = []
    cmd_result = []
    average_ccn_list = []
    cmd = "%s/../../tool/complexity/bin/complexity-linux -t --threshold %s  \"%s\" " % (current_path, 0, filename)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        timer = Timer(60, p.kill)
        timer.start()
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            cmd_result.append(line)
    finally:
        timer.cancel()
        p.terminate()
        p.wait()
    for elem in cmd_result:
        try:
            if len(elem.split(',')) == 11 and os.path.exists(elem.split(',')[6].replace('\"','')) and check_path_match_skip(elem.split(',')[6].replace('\"',''), skip_path_list):
                ccn_function_list = elem.split(',')
                if int(ccn_function_list[1]) >= int(ccn_number):
                    defect = {}
                    defect['filePath']=ccn_function_list[6].replace('\"','').replace('//','/') #filename
                    defect['function_name']=ccn_function_list[7] #function_name
                    defect['long_name']=ccn_function_list[8] #function_long_name
                    defect['function_lines']=ccn_function_list[0] #function_lines
                    defect['startLine']=ccn_function_list[9]#function_lines
                    defect['endLine']=ccn_function_list[10] #function_lines
                    defect['total_lines']=ccn_function_list[4] #total_lines
                    defect['ccn']=ccn_function_list[1] #ccn
                    defect['condition_lines']='' #condition_lines
                    file_defects.append(defect)
                average_ccn_list.append(str(ccn_function_list[1]))
        except:
            print('pase filed '+elem)
    
    if len(average_ccn_list) > 0:
        ccn_summary = {}
        ccn_summary['file_path'] = filename
        ccn_summary['total_ccn_count'] = abs(eval('+'.join(average_ccn_list))/len(average_ccn_list))
        file_ccn_info['files_ccn'] = ccn_summary
    file_ccn_info['file_defects'] = file_defects
    return file_ccn_info
    
if __name__ == "__main__" :
    if len(sys.argv) > 2:
        input_data = {}
        output_data = {}
        skip_path_list = []
        all_file_defects = []
        files_ccn = []
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
            
            #生成规则配置文件
            ccn_number = 20
            if 'openCheckers' in input_data:
                for checker_option in input_data['openCheckers']:
                    if 'checkerName' in checker_option and 'CCN_threshold' in checker_option['checkerName']:
                        checkerOptions = checker_option['checkerOptions']
                        for option in checkerOptions:
                            if 'checkerOptionName' in option and 'ccn_threshold' in option['checkerOptionName'] and option['checkerOptionValue'] != '':
                                ccn_number = int(option['checkerOptionValue'])
                                break
                        break
                
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
                if scan_path.endswith('.ts') or scan_path.endswith('.tsx'):
                    result_list[index] = process_analyze.apply_async(ts_scan, (scan_path, ccn_number, skip_path_list),)
                else:
                    result_list[index] = process_analyze.apply_async(scan, (scan_path, ccn_number, skip_path_list),)
            process_analyze.close()
            process_analyze.join()
            for result in result_list:
                if not isinstance(result, int) and isinstance(result.get(), dict) and result.get() != {}:
                    ccn_info = result.get()
                    if len(ccn_info['file_defects']) > 0:
                        all_file_defects.extend(ccn_info['file_defects'])
                    if 'files_ccn' in ccn_info:
                        files_ccn.append(ccn_info['files_ccn'])
            
            if len(files_ccn) > 0:
                output_data['filesTotalCCN'] = files_ccn

            output_data['defects'] = all_file_defects
            if 'output' in options:
                with open(options['output'], 'w', encoding='utf-8') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')