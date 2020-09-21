import os, sys
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
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                if 'checkerName' in checker:
                    checkers_list.append(checker['checkerName'])
        tree = ET.ElementTree(file=rule_config_file)
        root = tree.getroot()
        for elem in root.findall('rule'):
            if not elem.attrib['ref'] in checkers_list and "Squiz.Functions.FunctionDeclarationArgumentSpacing" != elem.attrib['ref']:
                root.remove(elem)
        with open(rule_config_file, 'wb') as file:
            tree.write(file, 'utf-8')

    except Exception as e:
        raise Exception(e)
        