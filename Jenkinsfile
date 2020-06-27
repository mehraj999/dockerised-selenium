pipeline {
agent any
stages {

    stage('Test') {
        steps {
            echo 'Test Execution'
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