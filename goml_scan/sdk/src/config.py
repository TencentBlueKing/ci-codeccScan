import os
import sys

properties_info={}
checker_options = ''
checkers_list = []
current_path = ''
config_path = ''
third_rules = ''
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

config_path = current_path+'/../config'
third_rules = current_path+'/../../third_rules'

def update_rule_config(properties_info):
    global checker_options
    global checkers_list
    try:
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                checker_info = ''
                if 'checkerName' in checker:
                    checker_info = checker['checkerName']
                if 'checkerOptions' in checker:
                    for option in checker['checkerOptions']:
                        if 'checkerOptionName' in option and 'checkerOptionValue' in option:
                            checker_options += ' --'+option['checkerOptionName']+'='+option['checkerOptionValue']
                checkers_list.append(checker_info)

    except Exception as e:
        raise Exception(e)
