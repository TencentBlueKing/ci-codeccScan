FROM python:3.6-alpine3.14
COPY sdk /usr/codecc/tool_scan/sdk/
COPY tool/py2 /usr/codecc/tool_scan/tool/py2
COPY third_rules/tencent.py /usr/codecc/tool_scan/tool/py2/pylint/checkers/
RUN chmod -R 755 /usr/codecc/tool_scan && \
    echo "https://mirrors.tencent.com/alpine/v3.14/main/" > /etc/apk/repositories && \
    echo "https://mirrors.tencent.com/alpine/v3.14/community/" >> /etc/apk/repositories && \
    apk add --no-cache bash && \
    apk add --no-cache python2 && \
    apk add --no-cache  build-base && \
    python3 -m pip install --upgrade pip && \
    pip3 install typed-ast==1.4.1 -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com && \
    pip3 install pylint==2.6.0 -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com && \
    pip3 install six==1.15.0 -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com && \
    pip3 install astroid==2.4.1 -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com && \
    pip3 install --upgrade setuptools -i http://mirrors.cloud.tencent.com/pypi/simple/ --trusted-host mirrors.cloud.tencent.com
COPY third_rules/* /usr/local/lib/python3.6/site-packages/pylint/checkers/
WORKDIR /usr/codecc/tool_scan
CMD ["/bin/bash"]