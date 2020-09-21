FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/software
COPY software/go1.9.2.tar.gz /usr/codecc/software
WORKDIR /usr/codecc/software
RUN tar zxvf go1.9.2.tar.gz
RUN rm -rf go1.9.2.tar.gz
RUN chmod -R 755 /usr/codecc/software/go1.9.2
ENV GOROOT=/usr/codecc/software/go1.9.2
COPY tool/gometalinter /usr/codecc/software/gometalinter
RUN chmod -R 755 /usr/codecc/software/gometalinter
ENV GOML_PATH=/usr/codecc/software/gometalinter
ENV PATH="${GOML_PATH}/bin:${GOROOT}/bin:${PATH}"
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
COPY third_rules /usr/codecc/tool_scan/third_rules/
COPY tool /usr/codecc/tool_scan/tool
RUN chmod -R 755 /usr/codecc/tool_scan
WORKDIR /usr/codecc/tool_scan