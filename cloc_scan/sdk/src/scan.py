import sys
import os,re
import json
import subprocess
import traceback

options = {}
languages = set([])
current_path = ''
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

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
    
def skip_error_msg(line):
    msg_list = ['Digest::MD5 not installed', 'Complex regular subexpression recursion limit', 'Unable to read', 'Diff error', 'exceeded timeout', 'Neither file nor directory']
    for msg in msg_list:
        if msg in line:
            return True
    return False

def scan(filename, skip_path_list):
    global languages
    file_defects = []
    cmd_result = []
    cmd = ''
    os.chmod(current_path+'/../../tool/cloc-1.82.pl', 0o755)
    if os.path.isdir(filename):
        cmd = "%s/../../tool/cloc-1.82.pl --exclude-dir=.temp --by-file-by-lang --json \"%s\" " % (current_path, filename)
    else:
        cmd = "%s/../../tool/cloc-1.82.pl --exclude-dir=.temp --list-file=%s --by-file-by-lang --json " % (current_path,filename)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    try:
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            if skip_error_msg(line):
                continue
            cmd_result.append(line)
    finally:
        p.terminate()
        p.wait()
    
    if ''.join(cmd_result) != '':
        try:
            data = json.loads(''.join(cmd_result))
            if 'by_file' in data:
                by_file_json_data = data['by_file']
                for key in by_file_json_data.keys():
                    if os.path.isfile(key) and check_path_match_skip(key, skip_path_list):
                        filedata = {}
                        filedata["filePath"] = key
                        info = by_file_json_data[key]
                        if 'language' in info:
                            languages.add(info['language'])
                        filedata = dict(filedata, **info)
                        file_defects.append(filedata)
        except:
            print(''.join(cmd_result))
            traceback.print_exc()  

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
                
                #获取过滤路径列表
                if 'skipPaths' in input_data:
                    skip_path_list = input_data['skipPaths']
                
                file_scan_path_list = []
                folder_scan_path_list = []
                #增量扫描
                if 'scanType' in input_data and input_data['scanType'] == 'increment':
                    for file_path in input_data['incrementalFiles']:
                        if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0 and check_path_match_skip(file_path, input_data['whitePathList']):
                            continue
                        if os.path.isfile(file_path):
                            file_scan_path_list.append(file_path)
                        elif os.path.isdir(file_path):
                            folder_scan_path_list.append(file_path)
                #全量扫描
                elif 'scanType' in input_data and input_data['scanType'] == 'full':
                    if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0:
                        for white_path in input_data['whitePathList']:
                            if os.path.isfile(white_path):
                                file_scan_path_list.append(white_path)
                            elif os.path.isdir(white_path):
                                folder_scan_path_list.append(white_path)
                    elif 'scanPath' in input_data and os.path.isdir(input_data['scanPath']):
                        folder_scan_path_list.append(input_data['scanPath'])


                if len(file_scan_path_list) > 0:
                    fileslist = current_path+'/fileslist.txt'
                    with open(fileslist, 'w', encoding='utf-8') as files_list:
                        for file_path in file_scan_path_list:
                            files_list.write(file_path+'\n')
                    file_defects = scan(fileslist, skip_path_list)
                    if len(file_defects) > 0:
                        all_file_defects.extend(file_defects)
                
                if len(folder_scan_path_list) > 0:
                    for scan_path in folder_scan_path_list:
                        file_defects = scan(scan_path, skip_path_list)
                        if len(file_defects) > 0:
                            all_file_defects.extend(file_defects)
                    
            output_data['defects'] = all_file_defects
            output_data["tool_name"] = 'cloc'
            if len(languages) > 0:
              output_data['languages'] = ';'.join(languages)
            if 'output' in options:
                with open(options['output'], 'w') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')