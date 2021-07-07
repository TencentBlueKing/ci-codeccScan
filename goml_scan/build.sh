GOPATH=$(pwd)/tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/_linters
CURRENT_DIR=$(pwd)
TARGET_DIR=$(pwd)/tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/_linters/src/github.com/golang/lint/golint/

pushd ${TARGET_DIR}
GO111MODULE=off go get ./...
GO111MODULE=off go build -o golint
mv golint ${CURRENT_DIR}/
popd
