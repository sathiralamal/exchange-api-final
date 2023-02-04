pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                echo 'building service ...'
                sh 'mvn clean install -DskipTests -f $WORKSPACE/pom.xml'
            }
        }

        stage("deploy") {

            steps {
                echo 'deploying service ...'
                sh 'docker build $WORKSPACE -t lakshithapathirage007/enigma007:exchange-api-latest'
                sh 'docker push lakshithapathirage007/enigma007:exchange-api-latest'
            }
        }
    }
}
