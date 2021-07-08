import sys
import os
import re
import json
import subprocess
import config
import re
import traceback
import xml.etree.ElementTree as ET

options = {}

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
    
def get_classpath(root_dir):
    class_paths = []
    for root, dir, files in os.walk(root_dir):
        for file in files:
            file_path = os.path.join(root, file)
            if file_path.endswith('.jar'):
                class_paths.append(file_path)
    return ':'.join(class_paths)

def scan(filename, config_path, third_rules, skip_path_list):
    error_info = []
    file_defects = []
    skip_option = ''
    result_xml = config.current_path+'/result.xml'
    class_path = get_classpath(config.current_path+'/../../tool/')
    for skip_path in skip_path_list:
        if '' != skip_path and not '$' in skip_path:
            skip_option += ' -x \"'+skip_path+'\"'
    if os.path.isdir(filename):
        cmd = "java -classpath %s com.puppycrawl.tools.checkstyle.Main %s -c %s -f xml \"%s\" -o \"%s\"" \
          % (class_path, skip_option, config.rule_config_file, filename, result_xml)
    else:
        cmd = "java -classpath %s com.puppycrawl.tools.checkstyle.Main %s -c %s -f xml -inc-file-path \"%s\" -o \"%s\"" \
          % (class_path, skip_option, config.rule_config_file, filename, result_xml)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            if "Caused by:" in line.decode('utf-8'):
                error_info.append(line.decode('utf-8'))
    finally:
        p.terminate()
        p.wait()
    
    if "".join(error_info) != "":
        defect = {}
        defect['filePath'] = "ParseError"
        defect['line'] = "1"
        defect['checkerName'] = "ParseError"
        defect['description'] = "<br>".join(error_info)
        file_defects.append(defect)

    if os.path.isfile(result_xml):
        try:
            tree = ET.ElementTree(file=result_xml)
            for elem in tree.iter():
                if elem.tag == "file":
                    file_path = elem.attrib['name']
                    if not file_path.endswith('.java'):
                        continue
                    if not check_path_match_skip(file_path, skip_path_list):
                        continue
                    for sub_elem in elem.iter():        
                        if sub_elem.tag == "error":
                            defect = {}
                            defect['filePath'] = file_path
                            defect['line'] = sub_elem.attrib['line']
                            if not 'onesdk.' in sub_elem.attrib['source'] \
                               and len(sub_elem.attrib['source'].rsplit('.', 1)) > 1:
                                short_checker = sub_elem.attrib['source'].rsplit('.', 1)[1]
                                defect['checkerName'] = short_checker
                                if short_checker.endswith('Check'):
                                    defect['checkerName'] = short_checker[:-5]
                            else:
                                defect['checkerName'] = sub_elem.attrib['source']
                            defect['description'] = sub_elem.attrib['message']
                            if defect != {}:
                                file_defects.append(defect)
        except Exception:
            err_msg = "---------------%s---------------\n%s\n%s\n" % (filename, result_xml, traceback.format_exc())
            print(err_msg)
    
        #clean result
        os.remove(result_xml)
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

            if os.path.isfile(config.rule_config_file):
                #更新规则配置文件
                config.update_rule_config(input_data)
                
                #获取过滤路径列表
                if 'skipPaths' in input_data:
                    skip_path_list = input_data['skipPaths']
                
                file_scan_path_list = []
                folder_scan_path_list = []
                #增量扫描
                if 'scanType' in input_data and input_data['scanType'] == 'increment':
                    for file_path in input_data['incrementalFiles']:
                        if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0 \
                           and check_path_match_skip(file_path, input_data['whitePathList']):
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
                    fileslist = config.current_path+'/fileslist.txt'
                    with open(fileslist, 'w', encoding='utf-8') as files_list:
                        for file_path in file_scan_path_list:
                            files_list.write(file_path+'\n')
                    file_defects = scan(fileslist, config.rule_config_file, config.third_rules, skip_path_list)
                    if len(file_defects) > 0:
                        all_file_defects.extend(file_defects)
                
                if len(folder_scan_path_list) > 0:
                    for scan_path in folder_scan_path_list:
                        file_defects = scan(scan_path, config.rule_config_file, config.third_rules, skip_path_list)
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