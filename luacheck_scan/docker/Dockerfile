FROM alpine:3.13
RUN echo "https://mirrors.tencent.com/alpine/v3.13/main/" > /etc/apk/repositories && \
    apk add curl gcc make  && \
    mkdir -p /usr/codecc/tool_scan && \
    mkdir -p /usr/codecc/software && \
    apk add --no-cache python3 && \
    cd /usr/codecc/software && \
    curl -R -O http://www.lua.org/ftp/lua-5.3.0.tar.gz && \
    tar zxvf lua-5.3.0.tar.gz && \
    rm -r lua-5.3.0.tar.gz && \
    cd lua-5.3.0 && \
    apk add libc-dev readline readline-dev && \
    make linux && \
    make install && \
    cd /usr/codecc/software && \
    wget http://luarocks.github.io/luarocks/releases/luarocks-2.4.3.tar.gz && \
    tar zxvf luarocks-2.4.3.tar.gz && \
    rm -r luarocks-2.4.3.tar.gz && \
    cd luarocks-2.4.3 && \
    apk add unzip && \
    ./configure && \
    make build && \
    make install && \
    luarocks install luacheck
COPY . /usr/codecc/tool_scan
RUN chmod -R 777 /usr/codecc/tool_scan/sdk/src/scan.py
WORKDIR /usr/codecc/tool_scan
