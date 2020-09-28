import sys,subprocess,json,os
import platform
import util

options = {}
os_type = platform.system()

def find_git_dir_path(file_folder_path):
    git_dir = file_folder_path
    while True:
        git_dir += '/.git'
        if os.path.isdir(git_dir):
            break
        elif os.path.isfile(git_dir):
            break
        else:
            git_dir = os.path.dirname(os.path.dirname(git_dir))
    return os.path.dirname(git_dir)

def get_git_dir_path(file_path):
    git_dir_path = ''
    cmd = 'git ls-remote --get-url'
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        line = bytes.decode(line.strip())
        if not 'fatal:' in line:
            git_dir_path = find_git_dir_path(file_path)
    return git_dir_path

def submodule_run(increment_files, git_dir_path, increment_path, pre_revision):
    
    update_file_list = []
    delete_file_list = []
    if 'updateFileList' in increment_files:
        update_file_list = increment_files['updateFileList']
    if 'deleteFileList' in increment_files:
        delete_file_list = increment_files['deleteFileList']

    submodule_increment_command = 'git diff --submodule=diff --name-only'
    increment_command = 'git diff HEAD '+pre_revision+' --name-only'
    p = subprocess.Popen(submodule_increment_command, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        submodule_path = os.path.join(git_dir_path,bytes.decode(line.strip()))
        if os.path.isdir(submodule_path):
            os.chdir(submodule_path)
            p = subprocess.Popen(increment_command, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
            for subline in p.stdout:
                file_path = os.path.join(submodule_path,bytes.decode(subline.strip()))
                if os.path.isfile(file_path) and not util.is_binary_file(file_path):
                    update_file_list.append(file_path.replace('//', '/'))
                else:
                    delete_file_list.append(file_path.replace('//', '/'))
    os.chdir(increment_path)
    
    increment_files['updateFileList'] = update_file_list
    increment_files['deleteFileList'] = delete_file_list
    
    return increment_files
    
def increment_run(git_dir_path, pre_revision):
    increment_files = {}
    update_file_list = []
    delete_file_list = []
    get_latest_version = 'git rev-parse --short HEAD'
    increment_command = 'git diff HEAD '+pre_revision+' --name-only'
    increment_rename_command = 'git log HEAD...'+pre_revision+' --summary | grep \'^ rename\''
    if os_type == "Windows":
        increment_rename_command = 'git log HEAD...'+pre_revision+' --summary | findstr \"^^ rename\"'
    
    p = subprocess.Popen(get_latest_version, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        increment_files['latestRevision'] = bytes.decode(line.strip())
        print('diffSourceVision: '+pre_revision)
        print('diffTargetVison: '+increment_files['latestRevision'])
        break
    
    p = subprocess.Popen(increment_command, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        file_path = os.path.join(git_dir_path,bytes.decode(line.strip()))
        if os.path.isfile(file_path)  and not util.is_binary_file(file_path):
            update_file_list.append(file_path.replace('//', '/'))
        else:
            delete_file_list.append(file_path.replace('//', '/'))
    
    p = subprocess.Popen(increment_rename_command, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        move_path = bytes.decode(line.strip()).replace('rename ', '').replace('(100%)', '')
        if not '{' in move_path and not '}' in move_path and '=>' in move_path:
            move_path = move_path.split('=>')[1].replace(' ', '')
        elif '{' in move_path and '}' in move_path and '=>' in move_path:
            content_list = util.get_middleStr_list(move_path,'{','}')
            for content in content_list:
                move_path = move_path.replace(content.split('=>')[0], '').replace('}', '')
            move_path = move_path.replace('=>', '').replace(' ', '')
        file_path = os.path.join(git_dir_path,move_path)
        if os.path.isfile(file_path)  and not util.is_binary_file(file_path):
            update_file_list.append(file_path.replace('//', '/'))
        else:
            delete_file_list.append(file_path.replace('//', '/'))
                    
    increment_files['updateFileList'] = update_file_list
    print('diffFileList: '+'\n'.join(update_file_list))
    increment_files['deleteFileList'] = delete_file_list
    print('deleteFileList: '+'\n'.join(delete_file_list))
    
    return increment_files 
    
def check_revison(pre_revision):
    check_commit = 'git cat-file -t '+pre_revision
    p = subprocess.Popen(check_commit, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        if not 'commit' in bytes.decode(line.strip()):
            print('pre_version '+str(pre_revision)+' is not exist')
            return False
    return True

if __name__ == "__main__":
    input_data = {}
    increment_files = {}
    increment_repo_list = []
    git_dir_path = ''
    output_info = {}
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
        if 'scm_increment' in input_data:
            for scm_increment in input_data['scm_increment']:
                pre_revision = ''
                workspacke_path = ''
                if 'pre_revision' in scm_increment:
                    pre_revision = scm_increment['pre_revision']
                if 'workspacke_path' in scm_increment:
                    workspacke_path = scm_increment['workspacke_path']
                if os.path.isdir(workspacke_path):
                    os.chdir(workspacke_path)
                    git_dir_path = get_git_dir_path(workspacke_path)
                    if pre_revision == '':
                        pre_revision = 'HEAD^'
                        if os_type == "Windows":
                            pre_revision = 'HEAD^^'
                    else:
                        if check_revison(pre_revision):
                            output_info['is_pre_revision'] = True
                        else:
                            output_info['is_pre_revision'] = False
                            pre_revision = ''
                    if git_dir_path != '' and pre_revision != '' :
                        try:
                            increment_files = increment_run(git_dir_path, pre_revision)
                            increment_files = submodule_run(increment_files, git_dir_path, workspacke_path, pre_revision)
                            increment_repo_list.append(increment_files)
                        except:
                            print('git_increment except '+git_dir_path)
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
    
            