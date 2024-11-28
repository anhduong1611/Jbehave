pipeline {
    agent any
    environment {
        GIT_CREDENTIALS_ID = 'GitHub-Token'
        GIT_REPO_URL = 'https://github.com/anhduong1611/Jbehave.git'
    }
    stages {
        stage('Checkout Code') {
            steps {
                // Clone Git repository
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/anhduong1611/Jbehave.git',
                        credentialsId: 'GitHub-Token'
                    ]]
                ])
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test -Dmeta.filter = -skip'
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
