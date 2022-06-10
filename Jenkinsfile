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
                sh("mvn clean compile")
            }
        }

        stage('Test')
        {
            steps {
                sh("mvn test")
            }
            post {
               success {
                    junit '**/target/surefire-reports/*.xml'
               }
               failure {
                   mail bcc: '', body: '''Please check this job : ${JOB_URL}
                   Your partner Jenkins''', cc: '', from: '', replyTo: '', subject: 'Build ${BUILD_TAG} Failed ', to: 'appiciel@outlook.fr'
               }
            }
        }

        stage('Docs') {
            steps{
                sh('mvn javadoc:javadoc')
            }
        }

        stage('Deploy to docker registry') {
             environment {
                DOCKER_ACCESS = credentials('jenkins-docker-access')
            }
            steps{
                // login to docker hub
                sh('docker login --username $DOCKER_ACCESS_USR --password $DOCKER_ACCESS_PSW')
                sh('echo $BUILD_NUMBER')
                // build image
                sh('docker build --tag you-coffee:v$BUILD_NUMBER .')
                // tag image in order to push to registry
                sh('docker tag you-coffee:v$BUILD_NUMBER dada971/you-coffee')
                // push to hub
                sh('docker push dada971/you-coffee')
            }
        }


        stage('Save to Nexus Repository') {
            steps {
                sh('mvn clean deploy')
            }
        }

        // stage('Deploy to AWS') {
        //     steps {
        //         //use aws
        //         //sh ''
        //     }
        // }
    }
}

