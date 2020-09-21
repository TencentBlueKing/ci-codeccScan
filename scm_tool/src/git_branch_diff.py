import sys,subprocess,json,os
import platform
import re

options = {}
os_type = platform.system()

def check_workspace(workspace, source_branch):
    if os.path.exists(workspace) and os.path.isdir(workspace):
        os.chdir(workspace)
        cmd = 'git branch'
        branch_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
        try:
            for line in branch_cmd.stdout:
                line = line.decode().strip()
                if '*' in line:
                    git_branch = line.split('*')[1].strip()
                    if git_branch == source_branch or 'devops-virtual-branch' == git_branch:
                        return True
        finally:
            branch_cmd.terminate()
            branch_cmd.wait()
    print('##[error]the workspace '+workspace+' is branch '+source_branch+' please check it')
    return False

def get_diff_file_list(workspace, source_branch, target_branch):
    diff_file_list = []
    if os.path.exists(workspace) and os.path.isdir(workspace):
        os.chdir(workspace)
        cmd = 'git diff origin/'+target_branch+'...origin/'+source_branch+' --numstat'
        print('diff file list with '+source_branch+'...'+target_branch)
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
        try:
            for line in p.stdout:
                print(line)
                line = str(line.decode().strip()).rsplit('\t', 1)[1]
                if not os.path.exists(workspace+os.sep+line):
                    continue
                diff_file_list.append(workspace+os.sep+line)
        finally:
            p.terminate()
            p.wait()
    return diff_file_list

def get_diff_file_change_lines(workspace, source_branch, target_branch, file_path):
    file_diff_lines = {}
    lines_list = []
    strat_line = ''
    line_account= 0
    if os.path.exists(workspace) and os.path.isdir(workspace):
        os.chdir(workspace)
        cmd = 'git diff origin/'+target_branch+'...origin/'+source_branch+' '+file_path
        print('diff lines with '+source_branch+'...'+target_branch+' in '+file_path)
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
        try:
            for line in p.stdout:
                line = line.decode().strip()
                if re.search('^@@',line):
                    str_tmp = line.split('@@')[1]
                    strat_line = str(str_tmp.split('+')[1].strip()).split(',')[0]
                    line_account = 0
                elif re.search('^-',line) or re.search('^---',line) or re.search('^\+\+\+',line):
                    continue
                # elif re.search('^\+',line) and line_account != 0:
                elif re.search('^\+',line):
                    lines_list.append(int(strat_line) + int(line_account))
                    line_account += 1
                else:
                    line_account += 1
        except:
            print('diff lines failed with '+source_branch+'...'+target_branch+' in '+file_path)
        finally:
            p.terminate()
            p.wait()
    if len(lines_list) > 0:
        file_diff_lines['filePath'] = file_path
        file_diff_lines['diffLineList'] = lines_list
    return file_diff_lines

if __name__ == "__main__":
    input_data = {}
    increment_files = {}
    increment_repo_list = []
    git_dir_path = ''
    output_info = {}
    source_branch = ''
    target_branch = ''
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
        if 'bk_ci_hook_source_branch' in input_data:
            source_branch = input_data['bk_ci_hook_source_branch']
        if 'bk_ci_hook_target_branch' in input_data:
            target_branch = input_data['bk_ci_hook_target_branch']

        if 'workspace' in input_data:
            for workspace in input_data['workspace']:
                if check_workspace(workspace, source_branch):
                    diff_file_list = []
                    file_list = get_diff_file_list(workspace, source_branch, target_branch)
                    increment_files['updateFileList'] = file_list
                    increment_files['deleteFileList'] = []
                    for file_path in file_list:
                        if not os.path.isfile(file_path):
                            continue
                        file_diff_lines = get_diff_file_change_lines(workspace, source_branch, target_branch, file_path)
                        if file_diff_lines != {}:
                            diff_file_list.append(file_diff_lines)
                    increment_files['diffFileList'] = diff_file_list
                    increment_repo_list.append(increment_files)
            if len(increment_repo_list) > 0:
                output_info['scm_increment'] = increment_repo_list
            if 'output' in options and output_info != {}:
                with open(options['output'], 'w', encoding='utf-8') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps(output_info, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')
    
            