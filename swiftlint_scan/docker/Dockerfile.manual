# Explicitly specify `bionic` because `swift:latest` does not use `ubuntu:latest`.
ARG BUILDER_IMAGE=mirrors.tencent.com/codecc/swift-codecc:5.3.3
ARG RUNTIME_IMAGE=mirrors.tencent.com/codecc/ubuntu-codecc:18.04

# builder image
FROM ${BUILDER_IMAGE} AS builder
RUN apt-get update && apt-get install -y \
    libcurl4-openssl-dev \
    libxml2-dev \
 && rm -r /var/lib/apt/lists/*
WORKDIR /swiftlint/
COPY tool/SwiftLint/Source Source/
COPY tool/SwiftLint/Tests Tests/
COPY tool/SwiftLint/Package.* ./

ARG SWIFT_FLAGS="-c release -Xswiftc -static-stdlib"
RUN swift build $SWIFT_FLAGS
RUN mkdir -p /executables
RUN for executable in $(swift package completion-tool list-executables); do \
        install -v `swift build $SWIFT_FLAGS --show-bin-path`/$executable /executables; \
    done

# runtime image
FROM ${RUNTIME_IMAGE}
LABEL org.opencontainers.image.source https://github.com/realm/SwiftLint
RUN apt-get update && apt-get install -y \
    libcurl4 \
    libxml2 \
    python3 \
    python3-dev \
    python3-pip \
 && rm -r /var/lib/apt/lists/*
COPY --from=builder /usr/lib/libsourcekitdInProc.so /usr/lib
COPY --from=builder /usr/lib/swift/linux/libBlocksRuntime.so /usr/lib
COPY --from=builder /usr/lib/swift/linux/libdispatch.so /usr/lib
COPY --from=builder /executables/* /usr/bin

ENV python3 /usr/bin/python3.6
RUN python3 -m pip install ruamel.yaml
RUN mkdir -p /usr/codecc/tool_scan
COPY sdk /usr/codecc/tool_scan/sdk/
RUN chmod -R 755 /usr/codecc/tool_scan
WORKDIR /usr/codecc/tool_scan

RUN swiftlint version

# CMD ["swiftlint"]
