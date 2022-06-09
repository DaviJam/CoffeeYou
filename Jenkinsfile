
pipeline {
    agent any
    stages
    {
        stage('SCM')
        {
            step
            {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
            }
        }

        stage('Compile')
        {
            step
            {
                sh 'mvn clean compile'
            }
        }

        stage('Test')
        {
            try {
                    step
                    {
                        sh 'mvn test'
                    }
            } finally {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
            }
        }

        stage('Docs') {
            step{
                sh 'mvn javadoc:javadoc'
            }
        }
    }
}

