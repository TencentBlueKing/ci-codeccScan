import os
import sys
import xml.etree.ElementTree as ET

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

rule_config_file = os.path.join(config_path, 'tencent_config.xml')         

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
        tree = ET.ElementTree(file=rule_config_file)
        
        for elem in tree.iter():
            #delete checker
            if 'Rule' == elem.tag and not elem.attrib['Name'] in checkers_list:
                for enable_elem in elem.iter():
                    if 'BooleanProperty' in enable_elem.tag and enable_elem.attrib['Name'] == 'Enabled':
                        enable_elem.text = 'False'
            #update checker option
            if 'Name' in elem.attrib and elem.attrib['Name'] in checker_options:
                elem.text = str(checker_options[elem.attrib['Name']])  

        with open(rule_config_file, 'wb') as file:
            tree.write(file, 'utf-8')

    except Exception as e:
        raise Exception(e)
        