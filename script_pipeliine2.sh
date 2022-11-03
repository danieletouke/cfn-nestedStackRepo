#!/bin/bash

#This script runs a cloud formation template from the latest cloned repo

cd /git_project/cfn-nestedStackRepo/

aws cloudformation create-stack --stack-name git_test \
--template-body file://create_http.yml

echo 'This is the $(  )-th job'
