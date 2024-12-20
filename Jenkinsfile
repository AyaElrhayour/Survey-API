pipeline {
    agent any
    stages {
        stage('Code Checkout') {
            steps {
                git branch: 'master', changelog: false, poll: false, url: "https://github.com/AyaElrhayour/Survey-API"
            }
        }

        stage('Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Clean & Package') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
    }
}