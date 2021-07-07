FROM mirrors.tencent.com/codecc/base:latest
RUN pip3 install pyyaml -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com
RUN mkdir -p /bkcheck
COPY tool/occheck.jar /bkcheck/occheck.jar
COPY sdk/src/bklauncher.py /bkcheck/
RUN chmod -R 755 /bkcheck
WORKDIR /bkcheck