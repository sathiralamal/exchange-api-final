pipeline {
    agent any
   
    stages {
        
        stage('Build Docker image') {
            steps {
                echo 'building the application'
                bat 'java --version'
//                 bat 'mvn -U clean install'
                bat 'mvn clean install -DskipTests -f pom.xml'
                bat 'docker build -t stock_app .'
                bat 'docker tag stock_app:latest 047250084788.dkr.ecr.us-east-2.amazonaws.com/stock_app:latest'
            }
        }
        stage('Push to ECR') {
            steps {
                echo 'Push application Push to ECR'

//                 withAWS(credentials: 'aws-cred', region: 'us-east-2') {
//                     bat 'aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 047250084788.dkr.ecr.us-east-2.amazonaws.com'
//                     bat 'docker push 047250084788.dkr.ecr.us-east-2.amazonaws.com/stock_app:latest'
//                 }
            }
        }
        stage('Deployment') {
            steps {
                echo 'Deploying'
                 bat 'helm uninstall exchange-api'
                 bat 'helm install exchange-api -f C:/Users/sathira/Desktop/exchange-app/Cloud Computing Applications 20227BUIS027/could-assignment-submit/exchange-api-helm-chart'
                
               
            }
        }
    }
}
