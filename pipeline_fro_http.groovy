pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                sh 'mkdir -p /cloudFormation'
                sh 'cd /cloudFormation'
                checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/danieletouke/cfn-nestedStackRepo.git']]])
            }
        }
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/danieletouke/cfn-nestedStackRepo.git'
                sh 'aws cloudformation create-stack --stack-name myhttp --template-body file://create_http.yml'
            }
        }
        stage('Test') {
            steps {
                sh 'aws ec2 describe-instances'
            }
        }
    }
}