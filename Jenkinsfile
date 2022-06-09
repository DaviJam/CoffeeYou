node {
    stages {
        stage('SCM') {
            steps {
              checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
            }
            agent any
        }

        stage('Compile') {
            steps {
              sh 'mvn clean compile'
            }
            agent any
        }

        stage('Test') {
            steps {
                try {
                    sh 'mvn test'
                } finally {
                    step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
                }
            }
            agent any
        }

        stage('Docs') {
            steps {
              sh 'mvn javadoc:javadoc'
            }

            agent any
        }
    }
}

