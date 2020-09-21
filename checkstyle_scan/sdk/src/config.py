import os, sys
import json
import re
import xml.etree.ElementTree as ET

properties_info={}
current_path = ''
config_path = ''
third_rules = ''
tencent_checker_style='com.tencent.checks.'
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

config_path = current_path+'/../config'
third_rules = current_path+'/../../third_rules'

rule_config_file = os.path.join(config_path, 'tencent_config.xml')

def update_rule_config(properties_info):
    try:
        #get the config
        tree = ET.ElementTree(file=rule_config_file)
        root = tree.getroot()
        
        #get the open checker and option
        checkers_list = ['SuppressWarningsHolder']
        checker_options = {}
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                if 'checkerName' in checker and 'nativeChecker' in checker:
                        if checker['nativeChecker'] == True:
                            checkers_list.append(checker['checkerName'])
                        else:
                            checkers_list.append(tencent_checker_style+''+checker['checkerName'])
                if 'checkerOptions' in checker:
                    options = {}
                    for option in checker['checkerOptions']:
                        if 'checkerOptionName' in option and 'checkerOptionValue' in option:
                            options[option['checkerOptionName']] = option['checkerOptionValue']
                    if checker['nativeChecker'] == True:
                        checker_options[checker['checkerName']] = json.dumps(options)
                    else:
                        checker_options[tencent_checker_style+''+checker['checkerName']] = json.dumps(options)
        
        #delete skip_checkers && add market rules
        for module in root.findall('module'):
            if module.attrib['name'] != 'TreeWalker' and not module.attrib['name'] in checkers_list and not re.search('Filter$', str(module.attrib['name'])):
                root.remove(module)
            elif module.attrib['name'] == 'TreeWalker':
                for tree_walker_module in module.findall('module'):
                    if not tree_walker_module.attrib['name'] in checkers_list and not re.search('Filter$', str(tree_walker_module.attrib['name'])):
                        module.remove(tree_walker_module)

        #update checker option
        for module in root.findall('module'):
            if module.attrib['name'] != 'TreeWalker' and module.attrib['name'] in checkers_list and module.attrib['name'] in checker_options:
                option_list =  json.loads(checker_options[module.attrib['name']])
                keys = option_list.keys()
                for key in keys:
                    if key == 'tokens':
                        if isinstance(option_list[key], list):
                            for token in option_list[key]:
                                ET.SubElement(module, 'property', attrib={'name':key, 'value':token})
                        else:
                            ET.SubElement(module, 'property', attrib={'name':key, 'value':option_list[key]})
                    else:
                        for prop in module.findall('property'):
                            if key == prop.attrib['name']:
                                prop.attrib['value'] = option_list[key]
                                break
                        else:
                            ET.SubElement(module, 'property', attrib={'name':key, 'value':option_list[key]})
            elif module.attrib['name'] == 'TreeWalker':
                for tree_walker_module in module.findall('module'):
                    if tree_walker_module.attrib['name'] in checkers_list and tree_walker_module.attrib['name'] in checker_options:
                        option_list =  json.loads(checker_options[tree_walker_module.attrib['name']])
                        keys = option_list.keys()
                        for key in keys:
                            if key == 'tokens':
                                if isinstance(option_list[key], list):
                                    for token in option_list[key]:
                                        ET.SubElement(tree_walker_module, 'property', attrib={'name':key, 'value':token})
                                else:
                                    ET.SubElement(tree_walker_module, 'property', attrib={'name':key, 'value':option_list[key]})
                            else:
                                for prop in tree_walker_module.findall('property'):
                                    if key == prop.attrib['name']:
                                        prop.attrib['value'] = option_list[key]
                                        break
                                else:
                                    ET.SubElement(tree_walker_module, 'property', attrib={'name':key, 'value':option_list[key]})
        with open(rule_config_file, 'wb') as file:
            file.write('<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE module PUBLIC "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">'.encode('utf8'))
            tree.write(file, 'utf-8')

    except Exception as e:
        raise Exception(e)
        