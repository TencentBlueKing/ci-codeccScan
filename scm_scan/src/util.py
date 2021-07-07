import datetime
import time
import unicodedata
import base64
import os
import re
import itertools
import codecs
import subprocess
import xml.etree.ElementTree as ET

#: BOMs to indicate that a file is a text file even if it contains zero bytes.
_TEXT_BOMS = (
    codecs.BOM_UTF16_BE,
    codecs.BOM_UTF16_LE,
    codecs.BOM_UTF32_BE,
    codecs.BOM_UTF32_LE,
    codecs.BOM_UTF8,
    )

def format_file_path(file_path):
    return file_path.replace('(','\(').replace(')','\)').replace(' ', '\ ')
    
def check_svn_version(dir_path):
    info_data = []
    cmd = "svn info --xml "+dir_path
    try:
        p = subprocess.Popen(cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True, start_new_session=True)
        for line in p.stdout:
            line = bytes.decode(line.strip()) 
            info_data.append(line)
        ET.fromstring(' '.join(info_data))
    except:
        os.environ["PATH"] = "/opt/CollabNet_Subversion/bin/:" + os.environ["PATH"]
    finally:
        p.terminate()
        p.wait()

def compare_version(from_version, to_version):
    fromVersion = tuple(int(val) for val in from_version.split('.'))
    toVersion = tuple(int(val) for val in to_version.split('.'))
    if fromVersion < toVersion:
        return False
    return True

def is_binary_file(file_path):
    with open(file_path, 'rb') as file:
        initial_bytes = file.read(8192)
        file.close()
        for bom in _TEXT_BOMS:
            if initial_bytes.startswith(bom):
                continue
            else:
                if b'\0' in initial_bytes:
                    return True
    return False
    
def datetime_to_timestamp(str_datetime, format):
    date_time = datetime.datetime.strptime(str_datetime, format)
    return int(datetime.datetime.timestamp(date_time))
    
def zoom_list(lines, line_num):
    end_nums = len(lines)-1
    if isinstance(lines[end_nums], list):
        sub_line_nums = lines[end_nums]
        if (line_num - sub_line_nums[1]) == 1:
            sub_line_nums[1] = line_num
            lines[end_nums] = sub_line_nums
        else:
            lines.append(line_num)
    elif (line_num - lines[end_nums]) == 1:
        lines[end_nums] = [lines[end_nums], line_num]
    else:
        lines.append(line_num)
    return lines
    
def add_skip_path(skip_paths, stream_code_path,find_path, sub_path_list):
    if os.path.isdir(find_path):
        for item in os.listdir(find_path):
            if item == '.svn' or item == '.git':
                continue
            skip_item = os.path.join(find_path, item)
            if not os.path.isdir(skip_item):
                continue
            if not skip_item in ''.join(sub_path_list):
                skip_paths += ';.*'+skip_item.replace(stream_code_path, '')
            else:
                if (skip_item not in sub_path_list) and ((skip_item+"/") not in sub_path_list):
                    skip_paths = add_skip_path(skip_paths, stream_code_path, skip_item, sub_path_list)
    return skip_paths
    
def get_datetime():
    return datetime.datetime.now().strftime('%Y-%m-%d_%H.%M.%S')

def date_time(format):
    return datetime.datetime.now().strftime(format)
    
def compare(time1,time2):
    t1 = time.strptime(time1, '%Y-%m-%dT%H:%M:%S')
    t2 = time.strptime(time2, '%Y-%m-%dT%H:%M:%S')
    return t1 < t2
    
def is_number(num):
    try:
        float(num)
        return True
    except ValueError:
        pass
    
    try:
        unicodedata.numeric(num)
        return True
    except (TypeError, ValueError):
        pass
 
    return False

def GetMiddleStr(content,startStr,endStr):
    startIndex = content.find(startStr)
    if startIndex>=0:
        startIndex += len(startStr)
    endIndex = content.find(endStr)
    return content[startIndex:endIndex]
 
def base64toencode(content):
    return base64.b64encode(content).decode('utf-8')
  
def base64todecode(content):
    return base64.b64decode(content).decode("utf-8")

def str_to_bytes(content):
    return content.encode()

def bytes_to_str(content):
    return content.decode()
    
def get_middleStr_list(content,startStr,endStr):
    startIndexs=[]
    endIndexs=[]
    content_list=[]
    for m in re.finditer(startStr, content):
        startIndexs.append(m.start())
    for m in re.finditer(endStr, content):
        endIndexs.append(m.start())
    if len(startIndexs) == len(endIndexs):
        for start, end in itertools.product(startIndexs, endIndexs):
            content_list.append(content[start:end])
    return content_list

def chunks(l, n):
    """Yield successive n-sized chunks from l."""
    for i in range(0, len(l), n):
        yield l[i:i+n]
        
if __name__ == "__main__" :
    status = compare('2018-03-19T14:28:16','2018-03-19T14:28:16')
    print(status)