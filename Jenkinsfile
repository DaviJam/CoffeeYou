node {
    stage('SCM') {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
        agent any
    }

    stage('Compile') {
        sh 'mvn clean compile'
        agent any
    }

    stage('Test') {
        try {
            sh 'mvn test'
        } finally {
            step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
        }
        agent any
    }

    stage('Docs') {
        sh 'mvn javadoc:javadoc'
        agent any
    }
}

