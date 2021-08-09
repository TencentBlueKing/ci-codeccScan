FROM docker.io/bkci/codecc:latest
RUN pip3 install pyyaml -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com
RUN mkdir -p /usr/codecc/tool_scan/bkcheck/cpp
COPY tool/occheck.jar /usr/codecc/tool_scan/bkcheck/cpp
COPY tool/bklauncher.py /usr/codecc/tool_scan/bkcheck/cpp
RUN chmod -R 755 /usr/codecc/tool_scan/bkcheck
WORKDIR /