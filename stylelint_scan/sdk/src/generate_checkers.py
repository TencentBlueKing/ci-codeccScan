import sys
import config
import json
if __name__ == "__main__" :
    rule_config_file = config.config_path+'/tencent_standard.js'
    checkers_dec_file = config.config_path+'/checkers_dec.txt'
    checkers_json = config.current_path + '/../../checkers.json'
    checkers_dec_dict = {}
    checker_severity = {}
    all_checkers = []
    with open(checkers_dec_file, 'r') as file:
        for line in file.readlines():
            line = line.strip()
            if ':' in line:
                checker_name = line.split(':',1)[0]
                checker_dec = line.split(':', 1)[1]
                severity = 1
                if '#' in checker_name:
                    severity = checker_name.split('#', 1)[0]
                    checker_name = checker_name.split('#', 1)[1]
                checkers_dec_dict[checker_name] = checker_dec
                checker_severity[checker_name] = severity

    with open(rule_config_file, 'r') as file:
        config_data = json.load(file)
        checker_list = config_data['rules']
        for checker_name in checker_list.keys():
            checker = {}
            checker['checkerName'] = checker_name
            if checker_name in checker_severity:
                checker['severity'] = checker_severity[checker_name]
            else:
                checker['severity'] = 1
            checker['checkerCategory'] = "CODE_FORMAT"
            checker['checkerType'] = "代码块相关"
            checker['checkerTypeSort'] = "1"
            if checker_name in checkers_dec_dict:
                checker['checkerDesc'] = checkers_dec_dict[checker_name]
            else:
                checker['checkerDesc'] = ''
            checker['checkerLanguage'] = [ "CSS" ]
            checker['checkerRecommend'] = "SYSTEM_DEFAULT"
            checker['checkerTag'] = ["系统推荐"]
            checker['checkerProps'] = []
            checker['editable'] = "true"
            all_checkers.append(checker)
    
    with open(checkers_json, 'w', encoding='utf-8') as file:
        print('generate output json file: '+checkers_json)
        file.write(json.dumps(all_checkers, sort_keys=True, indent=4, ensure_ascii=False))