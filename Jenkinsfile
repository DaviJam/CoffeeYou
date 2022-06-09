
pipeline {
    agent any
    stages {
        stage('SCM') {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
        }

        stage('Compile') {
            sh 'mvn clean compile'
        }

        stage('Test') {
            try {
                sh 'mvn test'
            } finally {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
            }
        }

        stage('Docs') {
            sh 'mvn javadoc:javadoc'
        }
    }
}

