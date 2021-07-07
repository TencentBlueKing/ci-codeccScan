import os, sys
import json
import shutil

properties_info={}
checker_options = ''
current_path = ''
config_path = ''
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

config_path = current_path+'/../config'

rule_config_file = os.path.join(config_path, 'tencent_config.js')

def replace(file_path, old_str, new_str):
    try:
        f = open(file_path,'r+')
        all_lines = f.readlines()
        f.seek(0)
        f.truncate()
        for line in all_lines:
            line = line.replace(old_str, new_str)
            f.write(line)
        f.close()
    except Exception as e:
        raise Exception(e)

def cleanup_rule_config():
    if os.path.isfile(rule_config_file):
        os.remove(rule_config_file)
        
def generate_rule_config():
    try:
        shutil.copyfile(config_path+'/tencent_standard.js', rule_config_file)
    except Exception as e:
        raise Exception(e)             


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
        new_checker_list = {}
        #delete filter checkers && add market rules
        with open(rule_config_file, 'r') as file:
            config_data = json.load(file)
            checker_list = config_data['rules']
            for checker in checker_list.keys():
                if checker in checkers_list:
                    new_checker_list[checker] = checker_list[checker]
                    
        config_data['rules'] = new_checker_list

        #write new config
        with open(rule_config_file, 'w') as file:
            file.write('module.exports =')
            json.dump(config_data,file, sort_keys=True, indent=4, separators=(',', ':'))
            file.write(';')
    except Exception as e:
        raise Exception(e)
        