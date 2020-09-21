import os, sys
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
    global checker_options
    try:
        checkers_list = []
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                checker_info = ''
                if 'checkerName' in checker:
                    checker_info = '+'+checker['checkerName']
                if 'checkerOptions' in checker:
                    checker_info += '#'+json.dumps(checker['checkerOptions'])
                checkers_list.append(checker_info)
        with open(rule_config_file, 'w') as file:
            file.write('-\n')
            for checker in checkers_list:
                file.write(checker+'\n')
    except Exception as e:
        raise Exception(e)
        