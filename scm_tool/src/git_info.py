import sys,subprocess,json,os

options = {}

def get_info(git_dir_path):
    scm_info = {}
    scm_info['scmType'] = 'git'
    cmd = 'git branch '
    branch_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
    try:
        for line in branch_cmd.stdout:
            line = line.decode().strip()
            if '*' in line:
                git_branch = line.split('*')[1]
                scm_info['branch'] = git_branch.strip().replace('HEAD detached at ', '').replace('(', '').replace(')', '')
                break
    finally:
        branch_cmd.terminate()
        branch_cmd.wait()
    
    log_num = '-1'
    if 'branch' in scm_info and scm_info['branch'] == 'devops-virtual-branch':
        log_num = '-2'
    
    cmd = "git log --pretty=format:\"%an->%h->%H->%ad\" --date=raw "+log_num
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        try:
            line = line.decode().strip()
        except:
            line = line.decode('GBK').strip()
        if "->" in line:
            msg_array = line.split('->')
            if len(msg_array) == 4:
                scm_info['fileUpdateAuthor'] = msg_array[0]
                scm_info['revision'] = msg_array[1]
                scm_info['commitID'] = msg_array[2]
                scm_info['fileUpdateTime'] = int(str(msg_array[3]).rsplit(' ', 1)[0]+'000')
         

    
    # cmd = 'git ls-remote --get-url '
    cmd = 'git remote -v '
    url_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
    try:
        for line in url_cmd.stdout:
            url = line.decode().strip()
            if 'origin' in url and '(fetch)' in url:
                url = url.replace('origin', '').replace('(fetch)', '').replace(' ', '').strip()
            if 'http://' in url and '@' in url:
                url = 'http://'+url.split('@')[1]
            elif 'https://' in url and '@' in url:
                url = 'https://'+url.split('@')[1]
            scm_info['url'] = url
            break
    finally:
        url_cmd.terminate()
        url_cmd.wait()
    
    return scm_info

def get_submodule(git_dir_path, scm_info):
    module_list = []
    module_info = {}
    gitmodule_path = git_dir_path+'/.gitmodules'
    if os.path.exists(gitmodule_path):
        with open(gitmodule_path, 'r', encoding = 'utf-8') as gitmodules_file:
            for line in gitmodules_file.readlines():
                if '[submodule' in line and module_info:
                    module_list.append(module_info)
                    module_info = {}
                if not '[submodule' in line:
                    if '=' in line and 'url' in line:
                        url = line.strip().split('=')[1].replace(' ','')
                        submodule = ''
                        if '@' in url:  
                            submodule = str(url.split('@')[1]).split('/',1)[1].replace('.git', '')
                        if 'http://' in url and '@' in url:
                            url = 'http://'+url.split('@')[1]
                        elif 'https://' in url and '@' in url:
                            url = 'https://'+url.split('@')[1]
                        module_info['url'] = url
                        module_info['subModule'] = submodule
    if module_info != {}:
        module_list.append(module_info)

    scm_info['subModules'] = module_list
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
        os.system('git --version')
        if 'dir_path_list' in input_data:
            for dir_path in input_data['dir_path_list']:
                if os.path.isdir(dir_path):
                    os.chdir(dir_path)
                    scm_info = get_info(dir_path)
                    scm_info = get_submodule(dir_path, scm_info)
                    scm_info_list.append(scm_info)
                    
        if len(scm_info_list) >0 and 'output' in options:
            with open(options['output'], 'w', encoding='utf-8') as file:
                print('generate output json file: '+options['output'])
                file.write(json.dumps({"scm_info": scm_info_list}, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')
            