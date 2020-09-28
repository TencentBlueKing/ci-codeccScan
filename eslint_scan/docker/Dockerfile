FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/software
COPY software/node-v12.16.2-linux-x64.tar /usr/codecc/software
WORKDIR /usr/codecc/software
RUN tar xvf node-v12.16.2-linux-x64.tar -C /usr/codecc/software
RUN rm -rf /usr/codecc/software/node-v12.16.2-linux-x64.tar
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
COPY third_rules /usr/codecc/tool_scan/third_rules
COPY node_modules /usr/codecc/tool_scan/node_modules
RUN chmod -R 755 /usr/codecc/tool_scan
RUN chmod -R 755 /usr/codecc/software/node-v12.16.2-linux-x64
ENV NODE_PATH=/usr/codecc/tool_scan/node_modules
ENV PATH="/usr/codecc/tool_scan/node_modules/.bin:/usr/codecc/software/node-v12.16.2-linux-x64/bin:${PATH}"
WORKDIR /usr/codecc/tool_scan
