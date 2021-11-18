import os
import sys
import json
import shutil

properties_info={}
checker_options = ''
current_path = ''
config_path = ''
third_rules = ''
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

config_path = current_path+'/../config'
third_rules = current_path+'/../../third_rules'

rule_config_file = os.path.join(config_path, 'tencent_config.txt')         
    
def update_rule_config(properties_info):
    try:
        checkers_list = []
        checker_options = {}
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                if 'checkerName' in checker:
                    checkers_list.append(checker['checkerName'])
                if 'checkerOptions' in checker:
                    for option in checker['checkerOptions']:
                        if 'checkerOptionName' in option and 'checkerOptionValue' in option:
                            checker_options[option['checkerOptionName']] = option['checkerOptionValue']

        with open(rule_config_file, "w", encoding = 'utf-8') as file:
            file.write('[MESSAGES CONTROL]\n')
            file.write('[FORMAT]\n')
            file.write('disable=all\n')
            file.write('enable='+','.join(checkers_list)+'\n')
            for key in checker_options.keys():
                file.write(key+'='+checker_options[key]+'\n')

    except Exception as e:
        raise Exception(e)
        