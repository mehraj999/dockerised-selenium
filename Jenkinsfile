pipeline {
agent any
stages {

    stage('Test') {
        steps {
            echo 'Test Execution'
            echo $M2_HOME
            echo $PATH
            sh 'mvn clean test'
        }
    }
    stage('reports') {
        steps {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
}