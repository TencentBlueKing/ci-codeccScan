FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/tool_scan
COPY src /usr/codecc/tool_scan/src/
COPY test /usr/codecc/tool_scan/test/
RUN chmod -R 755 /usr/codecc/tool_scan
WORKDIR /usr/codecc/tool_scan