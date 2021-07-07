import sys
import util
import subprocess
import os
import re
import json
import multiprocessing

options = {}

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
    
def set_file_info(commits):
    if 'changeRecords' in commits:
        file_path = commits['filePath']
        file_folder_path = os.path.dirname(file_path)
        git_root_path = find_git_dir_path(file_folder_path)
        commits['fileRelPath'] = file_path.replace(git_root_path, '').replace('//', '/')
        cmd = 'git log --pretty=format:%h '+util.format_file_path(file_path)
        log_revision_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                            shell=True, start_new_session=True)
        try:
            for line in log_revision_cmd.stdout:
                commits['revision'] = bytes.decode(line.strip())
                break
        finally:
            log_revision_cmd.terminate()
            log_revision_cmd.wait()
        cmd = 'git log --pretty=format:%H '+util.format_file_path(file_path)
        log_revision_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                            shell=True, start_new_session=True)
        try:
            for line in log_revision_cmd.stdout:
                commits['longRevision'] = bytes.decode(line.strip())
                break
        finally:
            log_revision_cmd.terminate()
            log_revision_cmd.wait()
        cmd = 'git log --pretty=format:\"%ad\"  --date=raw --reverse '+ util.format_file_path(file_path)
        log_changetime_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                              shell=True, start_new_session=True)
        try:
            for line in log_changetime_cmd.stdout:
                line = bytes.decode(line.strip())
                line = line.rsplit(' ', 1)[0]
                commits['fileUpdateTime'] = int(str(line)+'000')
                break
        finally:
            log_changetime_cmd.terminate()
            log_changetime_cmd.wait()
        cmd = 'git branch '
        branch_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                      shell=True, start_new_session=True)
        try:
            for line in branch_cmd.stdout:
                line = line.decode().strip()
                if '*' in line:
                    git_branch = line.split('*')[1]
                    if 'no branch' in git_branch:
                        commits['branch'] = 'master'
                    elif ')' in git_branch and ' ' in git_branch:
                        commits['branch'] = git_branch.rstrip().rsplit(' ', 1)[1].replace(')', '')
                    else:
                        commits['branch'] = git_branch.strip()
                    break
        finally:
            branch_cmd.terminate()
            branch_cmd.wait()
        cmd = 'git remote -v '
        url_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                   shell=True, start_new_session=True)
        try:
            for line in url_cmd.stdout:
                url = line.decode().strip()
                if 'origin' in url and '(fetch)' in url:
                    url = url.replace('origin', '').replace('(fetch)', '').replace(' ', '').strip()
                if 'http://' in url and '@' in url:
                    url = 'http://'+url.split('@')[1]
                commits['url'] = url
                break
        finally:
            url_cmd.terminate()
            url_cmd.wait()
    
    return commits
    
def blame_run_new(file_path):
    commits = {}
    try:
        if os.path.isfile(file_path):
            file_folder_path = os.path.dirname(file_path)
            os.chdir(file_folder_path)
            cmd = 'git blame %s --line-porcelain ' % (util.format_file_path(file_path))
            blame_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                         shell=True, start_new_session=True)
            try:
                commit = {}
                info = {}
                records = set([])
                change_records = []
                for line in blame_cmd.stdout:
                    try:
                        line = bytes.decode(line.strip()) 
                        if re.search('^[a-z0-9]{20,}', line):
                            if info != {}:
                                base64_info = util.base64toencode(util.str_to_bytes(json.dumps(info)))
                                records.add(base64_info)
                            info = {}
                            info['lineRevisionId'] = line.split(' ')[0]
                            if line.split(' ')[0] in commit:
                                line_num = int(line.split(' ')[2])
                                lines = commit[line.split(' ')[0]]
                                zoom_lines = util.zoom_list(lines, line_num)
                                commit[line.split(' ')[0]] = zoom_lines
                            else:
                                zoom_lines = []
                                zoom_lines.append(int(line.split(' ')[2]))
                                commit[line.split(' ')[0]] = zoom_lines
                            info['lineShortRevisionId'] = str(line.split(' ')[0])[0:8]
                        elif re.search('^author ', line) and not '=' in line:
                            info['author'] = line.split(' ', 1)[1]
                        elif re.search('^author-mail ', line):
                            info['authorMail'] = line.split(' ', 1)[1]
                        elif re.search('^author-time ', line):
                            info['lineUpdateTime'] = int(str(line.split(' ', 1)[1])+'000')
                    except:
                        continue
                if info != {}:
                    base64_info = util.base64toencode(util.str_to_bytes(json.dumps(info)))
                    records.add(base64_info)
                for base64_info in records:
                    try:
                        info = json.loads(util.base64todecode(base64_info))
                        info['lines'] = commit[info['lineRevisionId']]
                        change_records.append(info)
                    except:
                        continue
                if len(change_records) > 0:
                    commits['changeRecords'] = change_records
            finally:
                blame_cmd.terminate()
                blame_cmd.wait()

            if 'changeRecords' in commits:
                commits['filePath'] = file_path
        commits = set_file_info(commits)
    except:
        pass
    return commits

def blame_run_old(file_path):
    commits = {}
    if os.path.isfile(file_path):
        file_folder_path = os.path.dirname(file_path)
        os.chdir(file_folder_path)
        cmd = 'git blame %s -tln ' % (util.format_file_path(file_path))
        blame_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                     shell=True, start_new_session=True)
        try:
            commit = {}
            records = set([])
            change_records = []
            for line in blame_cmd.stdout:
                try:
                    line = bytes.decode(line.strip()) 
                    line = line.replace('-', '+').replace(' +', '+')
                    info = {}
                    info['lineRevisionId'] = line.split(' ')[0].replace('^', '')
                    info['lineShortRevisionId'] = str(info['lineRevisionId'])[0:8]
                    if info['lineRevisionId'] in commit:
                        line_num = int(line[line.index(' '):line.index('(')])
                        lines = commit[info['lineRevisionId']]
                        zoom_lines = util.zoom_list(lines, line_num)
                        commit[info['lineRevisionId']] = zoom_lines
                    else:
                        zoom_lines = []
                        line_num = int(line[line.index(' '):line.index('(')])
                        zoom_lines.append(line_num)
                        commit[info['lineRevisionId']] = zoom_lines
                    sub_line = line[line.index('(')+1:line.index('+')]
                    info['lineUpdateTime'] = int(sub_line.rsplit(' ', 1)[1]+'000')
                    info['author'] = str(sub_line.rsplit(' ', 1)[0]).strip()
                    info['authorMail'] = str(sub_line.rsplit(' ', 1)[0]).strip()
                    base64_info = util.base64toencode(util.str_to_bytes(json.dumps(info)))
                    records.add(base64_info)
                except:
                    continue

            for base64_info in records:
                try:
                    info = json.loads(util.base64todecode(base64_info))
                    info['lines'] = commit[info['lineRevisionId']]
                    change_records.append(info)
                except:
                    continue

            if len(change_records) > 0:
                commits['changeRecords'] = change_records
        finally:
            blame_cmd.terminate()
            blame_cmd.wait()
            
        if 'changeRecords' in commits:
            commits['filePath'] = file_path
    
    commits = set_file_info(commits)

    return commits

if __name__ == "__main__":
    files_scm_blame = []
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
        
        blame_new = True
        current_version = ''
        cmd = 'git --version '
        version_cmd = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, \
                                       shell=True, start_new_session=True)
        try:
            for line in version_cmd.stdout:
                line = line.decode().strip()
                if 'git version' in line:
                    num_list = line.replace('git version', '').replace(' ', '').split('.')
                    if len(num_list) > 2:
                        num_list = num_list[:2]
                    current_version = '.'.join(num_list)
                break
        finally:
            version_cmd.terminate()
            version_cmd.wait()
        
        if current_version != '':
            blame_new = util.compare_version(current_version, '1.8')

        if 'file_path_list' in input_data:
            result_list = [i for i in range(len(input_data['file_path_list']))]
            pool_processes = 1
            if multiprocessing:
                if len(result_list) > 10000:   
                    pool_processes = int(multiprocessing.cpu_count()/2)
                else:
                    pool_processes = multiprocessing.cpu_count()
            process_analyze = multiprocessing.Pool(processes = int(pool_processes))
            for index, file_path in enumerate(input_data['file_path_list']):
                try:
                    file_path = file_path.strip()
                    if blame_new:
                        result_list[index] = process_analyze.apply_async(blame_run_new, (file_path,))
                    else:
                        result_list[index] = process_analyze.apply_async(blame_run_old, (file_path,))
                except:
                    print('git blame except '+file_path)
            process_analyze.close()
            process_analyze.join()
            for result in result_list:
                try:
                    if not isinstance(result, int) and isinstance(result.get(), dict) and result.get() != {}:
                        file_scm_blame = result.get()
                        file_scm_blame['scmType'] = 'git'
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