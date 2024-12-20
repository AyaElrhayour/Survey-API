pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {
        stage('Code Checkout') {
            steps {
                git branch: 'master', changelog: false, poll: false, url: "https://github.com/AyaElrhayour/Survey-API"
            }
        }

        stage('Tests') {
            steps {
                sh "mvn test"
            }
        }

        stage('Clean & Package') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
    }
}
