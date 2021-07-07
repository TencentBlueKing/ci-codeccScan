import sys
import subprocess
import json
import os
import xml.etree.ElementTree as ET
import util

options = {}

def get_info(dir_path):
    scm_info = {}
    scm_info['scmType'] = 'svn'
    info_data = []
    cmd = "svn info --xml "+dir_path
    try:
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            info_data.append(line)
    finally:
        p.terminate()
        p.wait()

    try:
        root = ET.fromstring(' '.join(info_data))
        for elem in root.iter():
            if "commit" == elem.tag:
                scm_info['revision'] = elem.attrib['revision']
            elif "author" == elem.tag:
                scm_info['fileUpdateAuthor'] = elem.text
            elif "date" == elem.tag:
                date_format = "%Y-%m-%d %H:%M:%S"
                if 'T' in str(elem.text):
                    date_format = "%Y-%m-%dT%H:%M:%S.%fZ"
                scm_info['fileUpdateTime'] = int(str(util.datetime_to_timestamp(\
                                                 str(elem.text).rsplit(' ', 1)[0], date_format))+'000')
            elif "url" == elem.tag:
                scm_info['url'] = elem.text
            elif "root" == elem.tag:
                scm_info['rootUrl'] = elem.text
    except:
        scm_info = {}
    
    if scm_info != {}:
        scm_info['branch'] = ''

    return scm_info
    
if __name__ == "__main__":
    scm_info_list = []
    if len(sys.argv) > 2:
        for i in range(len(sys.argv)-1):
            if not "=" in sys.argv[i+1] or not "--" in sys.argv[i+1]:
                print("Usage %s --xxx=xxx" % sys.argv[0])
                sys.exit()
        for i in range(len(sys.argv)-1):
            tmp = sys.argv[i+1].split("=",1)
            options[tmp[0].replace("--","")] = str(tmp[1]).strip()
        
        if 'input' in options and os.path.isfile(options['input']):
            with open(options['input'], 'r', encoding='utf-8') as file:
                input_data = json.load(file)
        if 'dir_path_list' in input_data:
            for dir_path in input_data['dir_path_list']:
                if os.path.isdir(dir_path):
                    os.chdir(dir_path)
                    util.check_svn_version(dir_path)
                    scm_info_list.append(get_info(dir_path))
                    
        if len(scm_info_list) >0 and 'output' in options:
            with open(options['output'], 'w', encoding='utf-8') as file:
                print('generate output json file: '+options['output'])
                file.write(json.dumps({"scm_info": scm_info_list}, sort_keys=True, indent=4))
    else:
        print("Usage %s --xxx=xxx" % sys.argv[0])
        print('--input: the file path of input the json file for tool to scan')
        print('--output the file path of output the result')
            