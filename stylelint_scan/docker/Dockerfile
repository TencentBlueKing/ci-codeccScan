FROM mirrors.tencent.com/codecc/base:latest
RUN mkdir -p /usr/codecc/software
COPY software/node-v12.16.2-linux-x64.tar /usr/codecc/software
WORKDIR /usr/codecc/software
RUN tar xvf node-v12.16.2-linux-x64.tar -C /usr/codecc/software
RUN rm -rf /usr/codecc/software/node-v12.16.2-linux-x64.tar
RUN chmod -R 755 /usr/codecc/software/node-v12.16.2-linux-x64
ENV PATH="/usr/codecc/software/node-v12.16.2-linux-x64/bin:${PATH}"
RUN npm config set registry https://mirrors.tencent.com/npm/
RUN npm install -g stylelint stylelint-config-standard stylelint-scss stylelint-order @tencent/stylelint-config-tencent@^1.0.4
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
WORKDIR /usr/codecc/tool_scan