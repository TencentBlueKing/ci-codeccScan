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

rule_config_file = os.path.join(config_path, 'tencent_config.js')
third_rule_config_file = os.path.join(config_path, 'third_config.js')

def cleanup_rule_config():
    if os.path.isfile(rule_config_file):
        os.remove(rule_config_file)
        
def generate_rule_config(config_type):
    try:
        shutil.copyfile(config_path+'/tencent_standard.js', rule_config_file)
    except Exception as e:
        raise Exception(e)             
        
def merge_third_rule_config():
    config_data = {}
    checker_list = {}
    with open(third_rule_config_file, 'r') as file:
        third_config_data = json.load(file)
        if 'rules' in third_config_data:
            checker_list = third_config_data['rules']
    if checker_list != {}:
        with open(rule_config_file, 'r') as file:
            config_data = json.load(file)
            rules_list = config_data['rules']
            checker_list = dict(rules_list, **checker_list)
            config_data['rules'] = checker_list
    if config_data != {}:
        with open(rule_config_file, 'w') as file:
            file.write(json.dumps(config_data, sort_keys=True, indent=4, separators=(',', ':')))

def update_rule_config(properties_info):
    try:
        checkers_list = []
        checker_options = {}
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                if 'checkerName' in checker:
                    checkers_list.append(checker['checkerName'])
                if 'checkerOptions' in checker:
                    checker_options[checker['checkerName']] = checker['checkerOptions']

        config_data = {}
        #delete filter checkers && add market rules
        with open(rule_config_file, 'r') as file:
            config_data = json.load(file)
            checker_list = config_data['rules']
            delete_checkers_list = []
            for checker in checker_list.keys():
                if not checker in checkers_list:
                    delete_checkers_list.append(checker)
            for delete_checker in delete_checkers_list:
                if delete_checker in config_data['rules']:
                    config_data['rules'][delete_checker]='off'

        #update checker option
        map_checker = {'max-len':'{ "code": xxx }'}
        for key in checker_options.keys():
            for option in checker_options[key]:
                checker_value = ''
                if 'checkerOptionValue' in option:
                    checker_value = option['checkerOptionValue']
                if str(checker_value).isdigit():
                    checker_value = int(checker_value)
                else:
                    checker_value = str(checker_value)
                if key in map_checker.keys():
                    checker_value = json.loads(map_checker[key].replace('xxx', str(checker_value)))
                config_data['rules'][key]= ["error", checker_value]
            
        #write new config
        with open(rule_config_file, 'w') as file:
            file.write('module.exports =')
            json.dump(config_data,file, sort_keys=True, indent=4, separators=(',', ':'))
            file.write(';')
    except Exception as e:
        raise Exception(e)
        