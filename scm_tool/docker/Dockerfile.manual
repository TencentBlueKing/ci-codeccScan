FROM docker.io/bkci/codecc:latest
RUN mkdir -p /usr/codecc/software
COPY software/CollabNetSubversion-client-1.7.19-1.x86_64.rpm /usr/codecc/software
RUN rpm -ivh  /usr/codecc/software/CollabNetSubversion-client-1.7.19-1.x86_64.rpm
COPY src /usr/codecc/scm_tools/src
RUN chmod -R 755 /usr/codecc/scm_tools
WORKDIR /usr/codecc/scm_tools