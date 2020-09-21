FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/software
COPY software/php-7.3.1.tar.gz /usr/codecc/software
WORKDIR /usr/codecc/software
RUN tar zxvf php-7.3.1.tar.gz
RUN rm -rf php-7.3.1.tar.gz
RUN chmod -R 755 /usr/codecc/software/php-7.3.1
ENV PHP_PATH=/usr/codecc/software/php-7.3.1
ENV PATH="${PHP_PATH}/bin:${PATH}"
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
COPY third_rules /usr/codecc/tool_scan/third_rules/
COPY tool /usr/codecc/tool_scan/tool/
RUN chmod -R 755 /usr/codecc/tool_scan
WORKDIR /usr/codecc/tool_scan/