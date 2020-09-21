import sys
import os,re
import json
import subprocess
import traceback
import hashlib
import base64

current_path = ''
options = {}
dup_line_count = 0
dup_total_line_count = 0
dupc_files = []
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

lang_map = {
    "1" : "cs",
    "2" : "cpp",
    "4" : "java",
    "8" : "php",
    "16" : "objectivec",
    "32" : "python",
    "64" : "ecmascript;vue",
    "128" : "ruby",
    "512" : "go",
    "1024" : "swift",
    "4096" : "kotlin"
}
cloc_lang_map = {
    "1" : "C#",
    "2" : "'C++','C/C++ Header','C'",
    "4" : "Java",
    "8" : "PHP",
    "16" : "'Objective C','Objective C++','C/C++ Header'",
    "32" : "Python",
    "64" : "'JavaScript','Vuejs Component'",
    "128" : "Ruby",
    "512" : "Go",
    "1024" : "Swift",
    "4096" : "Kotlin"
}

lang_suffix = {
    "cs" : ".cs",
    "cpp" : ".c;.ec;.pgc;.C;.c++;.cc;.CPP;.cpp;.cxx;.inl;.pcc;.H;.h;.hh;.hpp;.hxx;",
    "java" : ".java",
    "php" : ".php;.php3;.php4;.php5",
    "objectivec" : ".m;.mm",
    "python" : ".py;.pyw",
    "ecmascript" : ".es6;.js",
    "vue": ".vue",
    "ruby" : ".rb",
    "go" : ".go",
    "swift" : ".Swift",
    "kotlin" : ".kt"
}

lang_list="'C#','C++','C/C++ Header','C','Java','PHP','Objective C','Objective C++','C/C++ Header','Python','JavaScript','Vuejs Component','Ruby','Go','Swift','Kotlin'"

suffix_lang_array = ['.cs','.c','.ec','.pgc','.C','.c++','.cc','.CPP','.cpp','.cxx','.inl','.pcc','.H','.h','.hh','.hpp','.hxx','.java','.php','.php3','.php4','.php5','.phtml','.vue','.rake','.rb','.go','.Swift','.m','.mm','.py','.pyw','.es6','.js','.kt','.kts']

def list_all_files(root_path, list_file_path, skip_path_list):
    with open(list_file_path, 'a+', encoding='utf-8') as file:
        for path,dir_list,file_list in os.walk(root_path) :  
            for file_name in file_list:
                file_path = os.path.join(path, file_name)
                if check_path_match_skip(file_path, skip_path_list) and os.path.splitext(file_path)[-1] in suffix_lang_array and os.path.isfile(file_path) :
                    file.write(file_path+'\n')

def merge_intervals(intervals):
    """
    A simple algorithm can be used:
    1. Sort the intervals in increasing order
    2. Push the first interval on the stack
    3. Iterate through intervals and for each one compare current interval
    with the top of the stack and:
    A. If current interval does not overlap, push on to stack
    B. If current interval does overlap, merge both intervals in to one
        and push on to stack
    4. At the end return stack
    """
    si = sorted(intervals, key=lambda tup: tup[0], reverse=False)
    merged = []
    for tup in si:
        if not merged:
            merged.append(tup)
        else:
            b = merged.pop()
            if b[1] >= tup[0]:
                if b[1] >= tup[1]:
                    merged.append(b)
                else:
                    new_tup = tuple([b[0], tup[1]])
                    merged.append(new_tup)
            else:
                merged.append(b)
                merged.append(tup)
    return merged

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

def map_language(language_suffix):
    return lang_map.get(language_suffix, None)

def get_md5(code_fragment):
    md5_obj = hashlib.md5()
    md5_obj.update(code_fragment.encode(encoding='utf-8'))
    md5 = md5_obj.hexdigest() #生成md5
    return md5

def skip_error_msg(line):
    msg_list = ['Digest::MD5 not installed', 'Complex regular subexpression recursion limit', 'Unable to read', 'Diff error', 'exceeded timeout', 'Neither file nor directory']
    for msg in msg_list:
        if msg in line:
            return True
    return False

def account_total_codes_for_lang(scan_path):
    global dup_total_line_count
    global lang_list
    cmd_result = []
    os.chmod(current_path+'/../../tool/cloc-1.82.pl', 0o755)
    cmd = "%s/../../tool/cloc-1.82.pl --skip-uniqueness --exclude-dir=.temp --include-lang=%s --json \"%s\" " % (current_path, lang_list, scan_path)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
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
            cloc_lang_list = lang_list.split(',')
            for lang in cloc_lang_list:
                lang = lang.replace('\'', '')
                if lang in data:
                    info = data[lang]
                    if 'code' in info:
                        dup_total_line_count += int(info['code'])
                    if 'blank' in info:
                        dup_total_line_count += int(info['blank'])
                    if 'comment' in info:
                        dup_total_line_count += int(info['comment'])
        except:
            print(cmd_result)
            traceback.print_exc()  

def scan(filename, suffix, skip_path_list):
    global dup_line_count
    global dupc_files
    cmd_result = []
    file_info = {}
    file_block_info = {}
    file_path_list = []
    os.chmod(current_path+'/../../tool/dupc/bin/run.sh', 0o755)
    cmd = "%s/../../tool/dupc/bin/run.sh cpd --minimum-tokens 100 --format csv_with_linecount_per_file --encoding utf-8 --filelist %s --language %s --skip-lexical-errors 2>/dev/null" % (current_path, filename, suffix)
    p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            cmd_result.append(line)
    finally:
        p.terminate()
        p.wait()

    for elem in cmd_result:
        dup_block_list = []
        if 'tokens,occurrences' in elem or 'Excluding ' in elem:
            continue
        try:
            fingerprint = get_md5(elem)
            block_num = elem.split(',', 2)[1].strip()
            elem = elem.split(',', 2)[2].strip()
            block_list = elem.split(',')
            for index in range(int(block_num)):
                if int(index*3+3) > int(len(block_list)):
                    break
                dup_block_list.append(','.join(block_list[index*3:index*3+3]))
            if len(dup_block_list) > 10000:
                continue
        except:
            print('pase elem '+elem)
        for dup in dup_block_list:
            try:
                options = dup.split(',')
                file_path = options[2].strip()
                if not check_path_match_skip(file_path, skip_path_list) or not os.path.splitext(file_path)[-1] in lang_suffix.get(suffix).split(';'):
                    continue
                single_dup_lines = options[1].strip()
                start_lines = int(options[0].strip())
                end_lines = int(start_lines) + int(single_dup_lines)
                block = {'start_lines': start_lines, 'end_lines': end_lines, 'finger_print': fingerprint}
                if not file_path in file_block_info:
                    file_block_info[file_path] = {'block_list':[json.dumps(block)]}
                    file_path_list.append(file_path)
                else:
                    file_block = file_block_info[file_path]
                    block_list = file_block['block_list']
                    block_list.append(json.dumps(block))
                    file_block['block_list'] =  block_list
                    file_block_info[file_path] = file_block
                
                if not file_path in file_info:
                    total_lines = 0
                    if os.path.isfile(file_path):
                        with open(file_path, "rb") as code_file:
                            data = code_file.read()
                            data = str(data).replace('\\r\\n','\\n').replace('\\r','\\n')
                            data_array = str(data).split('\\n')
                            total_lines = len(data_array)
                    file_info[file_path] = {'block_num': 1, 'dup_lines_list': [(start_lines, end_lines)], 'total_lines': int(total_lines)}
                else:
                    file_info[file_path]['block_num'] += 1
                    file_info[file_path]['dup_lines_list'].append((start_lines, end_lines))
            except Exception:
                err_msg = "---------------%s---------------\n%s\n" % (file_path, traceback.format_exc())
                print(err_msg)

    if len(file_path_list) > 0:
        for file_path in file_path_list:
            try:
                if file_path in file_info and file_info[file_path] != {} and file_path in file_block_info and file_block_info[file_path] != {}:
                    dup_file = file_info[file_path]
                    dup_file['file_path'] = file_path
                    file_block = file_block_info[file_path]
                    block_tmp_list = []
                    for block in list(set(file_block['block_list'])):
                        block_tmp_list.append(json.loads(block))
                    dup_file['block_list'] = block_tmp_list
                    file_merge_lines_intervals = merge_intervals(dup_file['dup_lines_list'])
                    dup_file.pop('dup_lines_list')
                    retain_size = len(file_merge_lines_intervals)
                    lang_buffer = 1000
                    current_buffer = 0
                    start = 0
                    is_stop=False
                    dup_line_number = 0
                    while 1:
                        if retain_size > lang_buffer:
                            retain_size -= lang_buffer
                            current_buffer = lang_buffer
                            is_stop=False
                        else:
                            current_buffer = retain_size
                            is_stop=True 
                        line_temp =  abs(eval(str(file_merge_lines_intervals[start:start+current_buffer]).replace(' ','').replace('),(',')+(').replace(',', '-').replace('[','').replace(']','')))
                        dup_line_number += line_temp
                        start += current_buffer
                        if is_stop:
                            break
                    dup_file['dup_lines'] = dup_line_number
                    dup_line_count += int(dup_line_number)
                    dup_file['dup_rate'] = '{:.2f}'.format(float(dup_file['dup_lines'] / dup_file['total_lines']*100))+'%'
                    dupc_files.append(dup_file)
            except:
                print('pase failed '+filename)

if __name__ == "__main__" :
    if len(sys.argv) > 2:
        input_data = {}
        output_data = {}
        skip_path_list = []
        all_result_json = {}
        language = ''
        list_file_path = current_path+'/file_list.txt'
        if os.path.exists(list_file_path):
            os.remove(list_file_path)
        open(list_file_path, "w") 
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
                        
            #全量扫描
            if 'scanPath' in input_data and os.path.isdir(input_data['scanPath']):
                white_path_list = []
                if 'whitePathList' in input_data and len(input_data['whitePathList']) > 0:
                    white_path_list = input_data['whitePathList']
                if len(white_path_list) > 0:
                    for path in white_path_list:
                        if os.path.isdir(path):
                            list_all_files(path, list_file_path, skip_path_list)
                            account_total_codes_for_lang(path)
                else:
                    list_all_files(input_data['scanPath'], list_file_path, skip_path_list)
                    account_total_codes_for_lang(input_data['scanPath'])

                if 'language' in input_data:
                    language = input_data['language']
                    for code_lang in lang_map.keys():
                        check_num = int(language) & int(code_lang)
                        if int(check_num) != 0:
                            for suffix in map_language(code_lang).split(';'):
                                if 'vue' in suffix:
                                    vue_file_path = current_path+'/vue_file_list.txt'
                                    with open(vue_file_path, 'w', encoding='utf-8') as vuefile:
                                        with open(list_file_path, 'r', encoding='utf-8') as listfile:
                                            for line in listfile.readlines():
                                                line = line.strip()
                                                if line.endswith('.vue'):
                                                    vuefile.write(line+'\n')
                                    scan(vue_file_path, suffix, skip_path_list)
                                else:
                                    scan(list_file_path, suffix, skip_path_list)
            
            if 'output' in options and len(dupc_files) > 0:
                all_result_json['defects'] = dupc_files
                all_result_json['dup_line_count'] = dup_line_count
                all_result_json['total_line_count'] = dup_total_line_count
            else:
                all_result_json['defects'] = []
                all_result_json['dup_line_count'] = 0
                all_result_json['total_line_count'] = 0
            with open(options['output'], 'w', encoding='utf-8') as file:
                print('generate output json file: '+options['output'])
                file.write(json.dumps(all_result_json, sort_keys=True, indent=4))
    else:
        print("Usage %s --xxx=xxx" % sys.argv[0])
        print('--input: the file path of input the json file for tool to scan')
        print('--output the file path of output the result')