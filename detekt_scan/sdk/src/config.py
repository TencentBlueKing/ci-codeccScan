import os, sys
import json
import yaml
import re

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

rule_config_file = os.path.join(config_path, 'tencent_config.yml')

def is_valid_detekt_rule_set(set_name):
    rule_set = ["comments", "complexity", "empty-blocks", \
        "exceptions", "formatting", "naming", "performance", \
            "potential-bugs", "style"]
    return set_name in rule_set

def update_rule_config(properties_info):
    global checker_options
    try:
        #get the config
        with open(rule_config_file, 'r', encoding='utf-8') as file:
            config_dict = yaml.load(file.read())
        
        #get the open checker and option
        checkers_list = []
        checker_options = {}
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                if 'checkerName' in checker:
                    checkers_list.append(checker['checkerName'])
                if 'checkerOptions' in checker:
                    options = {}
                    for option in checker['checkerOptions']:
                        if 'checkerOptionName' in option and 'checkerOptionValue' in option:
                            options[option['checkerOptionName']] = option['checkerOptionValue']
                    checker_options[checker['checkerName']] = json.dumps(options)
        
        for rule_set_key, rule_set_value in config_dict.items():
            if is_valid_detekt_rule_set(rule_set_key):
                for checker in rule_set_value.keys():
                    if re.match("([A-Z][a-z]+)+", checker):
                        if checker in checkers_list:
                            config_dict[rule_set_key][checker]['active'] = True
                        else:
                            config_dict[rule_set_key][checker]['active'] = False
                for rule_key, rule_value in checker_options.items():
                    if rule_key in checkers_list and rule_key in rule_set_value:
                        for option_key, option_value in json.loads(rule_value).items():
                            config_dict[rule_set_key][rule_key][option_key] = option_value
        
        #update checker config
        with open(rule_config_file, 'w') as file:
            yaml.dump(config_dict, file, default_flow_style=False)

    except Exception as e:
        raise Exception(e)
        