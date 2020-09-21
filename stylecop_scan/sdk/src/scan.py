import sys
import os,re
import json
import subprocess
import config
import xml.etree.ElementTree as ET
import traceback
import time

options = {}
stop_status = 0

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
    global stop_status
    file_defects = []
    result_xml = config.current_path+'/result.xml'
    if os.path.isdir(filename):
        cmd = "mono %s/../../tool/bin/StyleCopCLI.exe -set %s -cs \"%s\" -r -out \"%s\"" % (config.current_path, config.rule_config_file, filename+'/*', result_xml)
    else:
        if os.path.isfile(filename) and not str(filename).endswith('.cs'):
            return file_defects
        cmd = "mono %s/../../tool/bin/StyleCopCLI.exe -set %s -cs \"%s\" -out \"%s\"" % (config.current_path, config.rule_config_file, filename, result_xml)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            continue
    finally:
        p.terminate()
        p.wait()
    
    if os.path.isfile(result_xml):
        try:
            tree = ET.ElementTree(file=result_xml)
            for elem in tree.iter():
                if "Violation" == elem.tag:
                    if elem.attrib['Rule'] == 'CurlyBracketsForMultiLineStatementsMustNotShareLine' or elem.attrib['Rule'] == 'SyntaxException':
                        continue
                    if not check_path_match_skip(elem.attrib['Source'], skip_path_list):
                        continue
                    defect = {}
                    defect['filePath'] = elem.attrib['Source']
                    defect['checkerName'] = elem.attrib['Rule']
                    defect['description'] = elem.text
                    defect['line'] = elem.attrib['LineNumber']
                    if defect != {}:
                        file_defects.append(defect)
        except Exception:
            err_msg = "---------------%s---------------\n%s\n%s\n" % (filename, result_xml, traceback.format_exc())
            print(err_msg)
        #delete reulst xml
        os.remove(result_xml)
    # else:
    #     if stop_status > 0:
    #         raise Exception('Run failed as the result.xml can not found!')
    #     stop_status += 1
    #     time.sleep(10)
    #     file_defects = scan(filename, config_path, third_rules, skip_path_list)
        
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
                        if os.path.isdir(input_data['scanPath']):
                            for item in os.listdir(input_data['scanPath']):
                                if not '.temp' in item: 
                                    itemsrc=os.path.join(input_data['scanPath'],item)
                                    scan_path_list.append(itemsrc)
                for scan_path in scan_path_list:
                    file_defects = scan(scan_path, config.rule_config_file, config.third_rules, skip_path_list)
                    if len(file_defects) > 0:
                        all_file_defects.extend(file_defects)
                    
            output_data['defects'] = all_file_defects
            if 'output' in options:
                with open(options['output'], 'w', encoding='utf-8') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_data, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')