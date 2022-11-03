#/bin/bash

#Clone my github repo

FILE=~/git_project

if [ -f "$FILE" ]; then
    echo "$FILE exists."
else
    mkdir -p ~/git_project
fi

cd ~/git_project

git clone https://github.com/danieletouke/cfn-nestedStackRepo.git

if [ $?==0]; then
    echo "great job!!"
fi
