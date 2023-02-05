pipeline {
    agent any
    tools{
        maven '3.8.6'
    }
    stages {
        
        stage('Build Docker image') {
            steps {
                echo 'building the application'
                bat 'java --version'
//              bat 'mvn clean install -DskipTests -f pom.xml'
                bat 'mvn clean'
                bat 'mvn install'
                bat 'docker build -t stock_app .'
                bat 'docker tag stock_app:latest 047250084788.dkr.ecr.us-east-2.amazonaws.com/stock_app:latest'
            }
        }
        stage('Push to ECR') {
            steps {
                echo 'Push application Push to ECR'

                withAWS(credentials: 'aws-cred', region: 'us-east-2') {
                    bat 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 047250084788.dkr.ecr.us-east-2.amazonaws.com'
                    bat 'docker push 047250084788.dkr.ecr.us-east-2.amazonaws.com/stock_app:latest'
                }
            }
        }
    }
}
