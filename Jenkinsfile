pipeline {
    agent any
    environment {
        GIT_CREDENTIALS_ID = 'GitHub-Token'
        GIT_REPO_URL = 'https://github.com/anhduong1611/Jbehave.git'
    }
    stages {
        stage('Run Tests') {
            steps {
                bat 'mvn clean test -Dmeta.filter="+skip"'
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure([
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}
