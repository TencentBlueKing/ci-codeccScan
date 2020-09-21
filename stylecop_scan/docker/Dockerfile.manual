FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/software
COPY software/mono-5.12.0.226.tar.gz /usr/codecc/software
WORKDIR /usr/codecc/software
RUN tar zxvf mono-5.12.0.226.tar.gz
RUN rm -rf /usr/codecc/software/mono-5.12.0.226.tar.gz
RUN chmod -R 755 /usr/codecc/software/mono-5.12.0.226
ENV MONO_PATH=/usr/codecc/software/mono-5.12.0.226
ENV PATH="${MONO_PATH}/bin:${PATH}"
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
COPY third_rules /usr/codecc/tool_scan/third_rules/
COPY tool /usr/codecc/tool_scan/tool/
RUN chmod -R 755 /usr/codecc/tool_scan
WORKDIR /usr/codecc/tool_scan