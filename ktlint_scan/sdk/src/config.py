import os
import sys
import json
import re
import xml.etree.ElementTree as ET

properties_info={}
current_path = ''
if 'python' in sys.executable:
    current_path = sys.path[0]
else:
    current_path = os.path.dirname(os.path.realpath(sys.executable))

def update_rule_config(properties_info):
    checkers_list = []
    try:
        if 'openCheckers' in properties_info:
            for checker in properties_info['openCheckers']:
                checker_info = ''
                if 'checkerName' in checker:
                    checkers_list.append(checker['checkerName'])
    except Exception as e:
        raise Exception(e)
    return checkers_list