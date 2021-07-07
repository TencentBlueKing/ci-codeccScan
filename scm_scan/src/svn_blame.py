import sys
import util
import subprocess
import os
import json
import xml.etree.ElementTree as ET
import util
import multiprocessing

options = {}

def set_file_info(commits):
    if 'changeRecords' in commits:
        commits['branch'] = ''
        info_data = []
        file_path = commits['filePath']
        file_folder_path = os.path.dirname(file_path)
        os.chdir(file_folder_path)
        cmd = 'svn info  --xml '+file_path
        info_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                    shell=True, start_new_session=True)
        try:
            for line in info_cmd.stdout:
                line = bytes.decode(line.strip()) 
                info_data.append(line)
        finally:
            info_cmd.terminate()
            info_cmd.wait()
        try:
            root = ET.fromstring(' '.join(info_data))
            for elem in root.iter():
                if "relative-url" == elem.tag:
                    commits['fileRelPath'] =  str(elem.text).replace('^', '').replace('//', '/')
                if "url" == elem.tag:
                    commits['url'] = elem.text
                if "root" == elem.tag:
                    commits['rootUrl'] = elem.text
                if "commit" == elem.tag:
                    commits['revision'] = elem.attrib['revision']
                    for subelem in elem.iter():
                        if "date" == subelem.tag:
                            date_format = "%Y-%m-%d %H:%M:%S"
                            if 'T' in subelem.text:
                                date_format = "%Y-%m-%dT%H:%M:%S.%fZ"
                            commits['fileUpdateTime'] = int(str(util.datetime_to_timestamp(subelem.text, \
                                                            date_format))+'000')
        except:
            commits = {}
    return commits
    
def blame_run(file_path, svn_blame_options):
    commits = {}
    xml_data = []
    if os.path.isfile(file_path):
        file_folder_path = os.path.dirname(file_path)
        if not os.path.exists(file_folder_path):
            return set_file_info(commits) 
        os.chdir(file_folder_path)
        cmd = 'svn blame --non-interactive  --no-auth-cache --trust-server-cert --xml %s %s ' % \
              (svn_blame_options, file_path)
        blame_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                          shell=True, start_new_session=True)
        try:
            for line in blame_cmd.stdout:
                line = bytes.decode(line.strip()) 
                xml_data.append(line)
        except:
            commits = {}
        finally:
            blame_cmd.terminate()
            blame_cmd.wait()
        try:
            records = set([])
            commit = {}
            change_records = []
            root = ET.fromstring(' '.join(xml_data))
            for elem in root.iter():
                if "entry" == elem.tag:
                    info = {}
                    for subelem in elem.iter():
                        if "author" == subelem.tag:
                            info['author'] = subelem.text
                            info['authorMail'] = subelem.text
                        if "date" == subelem.tag:
                            date_format = "%Y-%m-%d %H:%M:%S"
                            if 'T' in subelem.text:
                                date_format = "%Y-%m-%dT%H:%M:%S.%fZ"
                            info['lineUpdateTime'] = int(str(util.datetime_to_timestamp(subelem.text, \
                                                         date_format))+'000')
                        if "commit" == subelem.tag:
                            info['lineRevisionId'] = subelem.attrib['revision']
                            info['lineShortRevisionId'] = subelem.attrib['revision']
                    if info != {}:
                        base64_info = util.base64toencode(util.str_to_bytes(json.dumps(info)))
                        records.add(base64_info)
                        if base64_info in commit:
                            line_num = int(elem.attrib['line-number'])
                            lines = commit[base64_info]
                            zoom_lines = util.zoom_list(lines, line_num)
                            commit[base64_info] = zoom_lines
                        else:
                            zoom_lines = []
                            zoom_lines.append(int(elem.attrib['line-number']))
                            commit[base64_info] = zoom_lines
            for base64_info in records:
                info = json.loads(util.base64todecode(base64_info))
                info['lines'] = commit[base64_info]
                change_records.append(info)
            if len(change_records) > 0:
                commits['changeRecords'] = change_records
            if 'changeRecords' in commits:
                commits['filePath'] = file_path
        except:
            commits = {}
    commits = set_file_info(commits)         
    return commits

if __name__ == "__main__":
    files_scm_blame = []
    svn_blame_options = ''
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
        if 'svn_user' in input_data:
            svn_blame_options += ' --username '+input_data['svn_user']
        if 'svn_password' in input_data:
            svn_blame_options += ' --password '+input_data['svn_password']
        if 'file_path_list' in input_data:
            pool_processes = 1
            if multiprocessing:
                pool_processes = multiprocessing.cpu_count()
            process_analyze = multiprocessing.Pool(processes = int(pool_processes))
            result_list = [i for i in range(len(input_data['file_path_list']))]
            change_svn_path = False
            for index, file_path in enumerate(input_data['file_path_list']):
                #检查svn version
                if not change_svn_path:
                    dir_path = os.path.dirname(file_path)
                    if not os.path.exists(dir_path):
                        continue
                    os.chdir(dir_path)
                    util.check_svn_version(dir_path)
                    change_svn_path = True
                try:
                    file_path = file_path.strip()
                    result_list[index] = process_analyze.apply_async(blame_run, (file_path,svn_blame_options,))
                except:
                    print('svn blame except '+file_path)
            process_analyze.close()
            process_analyze.join()
            for result in result_list:
                try:
                    if not isinstance(result, int) and isinstance(result.get(), dict) and result.get() != {}:
                        file_scm_blame = result.get()
                        file_scm_blame['scmType'] = 'svn'
                        files_scm_blame.append(file_scm_blame)
                except:
                    pass
        with open(options['output'], 'w', encoding='utf-8') as file:
            print('generate output json file: '+options['output'])
            file.write(json.dumps(files_scm_blame, sort_keys=True, indent=4))
    else:
        print("Usage %s --xxx=xxx" % sys.argv[0])
        print('--input: the file path of input the json file for tool to scan')
        print('--output the file path of output the result')