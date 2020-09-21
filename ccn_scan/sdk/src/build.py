import os
import subprocess
import sys
import shutil

#pyinstaller scan.py to binary
if __name__ == "__main__" :
    current = os.path.abspath(os.path.dirname(__file__))
    os.chdir(current)
    pyin_dir = current+'/../pyin'
    bin_dir = current+'/../bin'
    check_pyinstaller_version = 'pyinstaller --version'
    p = subprocess.run(check_pyinstaller_version, shell=True)
    if p.returncode != 0:
        print("ERROR: Can not found the pyinstaller, please install it")
        sys.exit(1)
    build_cmd = 'pyinstaller3.5 --specpath '+pyin_dir+'/spec'+' --distpath '+pyin_dir+'/dist'+' --workpath '+pyin_dir+'/build'+' -F scan.py'
    p = subprocess.Popen(build_cmd, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,shell=True,start_new_session=True)
    try:
        for line in p.stdout:
            print(line)
    finally:
        p.terminate()
        p.wait()
    dist_dir = pyin_dir + '/dist'
    if not os.listdir(dist_dir) :
        print('ERROR: There are nothing to pyinstaller!')
        sys.exit(1)
    for file in os.listdir(dist_dir):
        if os.path.isfile(dist_dir+'/'+file):
            print('copy '+dist_dir+'/'+file+' to '+bin_dir+'/'+file)
            if os.path.isfile(bin_dir+'/'+file):
                os.remove(bin_dir+'/'+file)
            shutil.copy(dist_dir+'/'+file, bin_dir+'/'+file)
        