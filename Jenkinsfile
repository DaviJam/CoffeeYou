
pipeline {
    agent any
    stages
    {
        stage('SCM')
        {
            steps
            {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
            }
        }

        stage('Compile')
        {
            steps
            {
                sh 'mvn clean compile'
            }
        }

        stage('Test')
        {
            try {
                    steps
                    {
                        sh 'mvn test'
                    }
            } finally {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
            }
        }

        stage('Docs') {
            steps{
                sh 'mvn javadoc:javadoc'
            }
        }
    }
}

