node {
    stage('SCM') {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
    }

    stage('Compile') {
        withMaven(maven: 'maven3'){
            sh 'mvn clean compile'
        }
    }

    stage('Test') {
        try {
            withMaven(maven: 'maven3'){
                sh 'mvn test'
            }
        } finally {
            step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
        }
    }

    stage('Docs') {
        withMaven(maven: 'maven3'){
            sh 'mvn javadoc:javadoc'
        }
    }
}

