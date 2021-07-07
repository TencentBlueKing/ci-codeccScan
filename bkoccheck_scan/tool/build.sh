#!/bin/bash
tool_path=$(cd `dirname $0`; pwd)
cd $tool_path
mvn clean install
occheck_jar=$tool_path/target/occheck-1.0-SNAPSHOT.jar
cp -rf $occheck_jar $tool_path/occheck.jar