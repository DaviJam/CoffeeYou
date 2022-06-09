node {
    stage('SCM') {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
    }

    stage('Compile') {
        withMaven(){
            sh 'mvn clean compile'
        }
    }

    stage('Test') {
        try {
            withMaven(){
                sh 'mvn test'
            }
        } finally {
            step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
        }
    }

    stage('Docs') {
        withMaven(){
            sh 'mvn javadoc:javadoc'
        }
    }
}

