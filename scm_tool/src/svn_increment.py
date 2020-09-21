import sys,subprocess,json,os
import util

options = {}

def increment_run(increment_path, pre_revision, svn_increment_options):
    increment_files = {}
    update_file_list = []
    delete_file_list = []
    get_latest_version = 'svn info --show-item revision'
    increment_command = 'svn diff --non-interactive  --no-auth-cache --trust-server-cert -r '+pre_revision+':HEAD --summarize '+svn_increment_options

    p = subprocess.Popen(get_latest_version, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        increment_files['latestRevision'] = bytes.decode(line.strip())
        print('diffSourceVision: '+pre_revision)
        print('diffTargetVison: '+increment_files['latestRevision'])
        break
        
    p = subprocess.Popen(increment_command, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True)
    for line in p.stdout:
        line = bytes.decode(line.strip())[1:].replace(' ','')
        file_path = os.path.join(increment_path,line)
        if os.path.isfile(file_path) and not util.is_binary_file(file_path):
            update_file_list.append(file_path.replace('//', '/'))
        else:
            delete_file_list.append(file_path.replace('//', '/'))
                    
    increment_files['updateFileList'] = update_file_list
    print('diffFileList: '+'\n'.join(update_file_list))
    increment_files['deleteFileList'] = delete_file_list
    print('deleteFileList: '+'\n'.join(delete_file_list))
    
    return increment_files 
    
if __name__ == "__main__":
    input_data = {}
    increment_files = {}
    increment_repo_list = []
    svn_increment_options = ''
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
            svn_increment_options += ' --username '+input_data['svn_user']
        if 'svn_password' in input_data:
            svn_increment_options += ' --password '+input_data['svn_password']
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
                    util.check_svn_version(workspacke_path)
                    if pre_revision == '':
                        pre_revision = 'PREV'
                    increment_files = increment_run(workspacke_path, pre_revision, svn_increment_options)
                    if increment_files != {}:
                        increment_repo_list.append(increment_files)
            if 'output' in options and len(increment_repo_list) > 0:
                with open(options['output'], 'w', encoding='utf-8') as file:
                    print('generate output json file: '+options['output'])
                    file.write(json.dumps({"scm_increment": increment_repo_list}, sort_keys=True, indent=4))
    else:
         print("Usage %s --xxx=xxx" % sys.argv[0])
         print('--input: the file path of input the json file for tool to scan')
         print('--output the file path of output the result')
            