#!bin/bash

export GOPATH=${WORKSPACE}/tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/_linters:${WORKSPACE}/tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2:$GOPATH

GOML_BIN=${WORKSPACE}/tool/gometalinter/bin

rm -rf $GOML_BIN

mkdir -p $GOML_BIN

declare -A checkerMap=(
    ["deadcode"]="_linters/src/github.com/tsenart/deadcode"
    ["dupl"]="_linters/src/github.com/mibk/dupl"
    ["errcheck"]="_linters/src/github.com/kisielk/errcheck"
    ["gas"]="_linters/src/github.com/GoASTScanner/gas"
    ["goconst"]="_linters/src/github.com/jgautheron/goconst/cmd/goconst"
    ["gocyclo"]="_linters/src/github.com/alecthomas/gocyclo"
    ["goimports"]="_linters/src/golang.org/x/tools/cmd/goimports"
    ["golint"]="_linters/src/github.com/golang/lint/golint"
    ["gosimple"]="_linters/src/honnef.co/go/tools/cmd/gosimple"
    ["gotype"]="_linters/src/golang.org/x/tools/cmd/gotype"
    ["govet"]="_linters/src/github.com/dnephin/govet"
    ["ineffassign"]="_linters/src/github.com/gordonklaus/ineffassign"
    ["interfacer"]="_linters/src/mvdan.cc/interfacer"
    ["lll"]="_linters/src/github.com/walle/lll/cmd/lll"
    ["maligned"]="_linters/src/github.com/mdempsky/maligned"
    ["megacheck"]="_linters/src/honnef.co/go/tools/cmd/megacheck"
    ["misspell"]="_linters/src/github.com/client9/misspell/cmd/misspell"
    ["nakedret"]="_linters/src/github.com/alexkohler/nakedret"
    ["safesql"]="_linters/src/github.com/stripe/safesql"
    ["staticcheck"]="_linters/src/honnef.co/go/tools/cmd/staticcheck"
    ["structcheck"]="_linters/src/github.com/opennota/check/cmd/structcheck"
    ["unconvert"]="_linters/src/github.com/mdempsky/unconvert"
    ["unparam"]="_linters/src/mvdan.cc/unparam"
    ["unused"]="_linters/src/honnef.co/go/tools/cmd/unused"
    ["varcheck"]="_linters/src/github.com/opennota/check/cmd/varcheck"
    )

go get -u -v github.com/kisielk/gotool

for key in ${!checkerMap[@]};do
    echo $key
    pushd tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/${checkerMap[$key]}
    go build -o $key
    mv $key ${GOML_BIN}/
    popd
done

pushd tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2
mkdir src
pushd vendor
mv -f * ../src/
popd
go build -o gometalinter
mv gometalinter ${GOML_BIN}/
popd

ls -l ${GOML_BIN}

