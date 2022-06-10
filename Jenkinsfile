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
            steps{
                // build image
               echo "YESSSSSS"
            }
        }


        // stage('Save to Repository') {
        //     steps {
        //         //use nexus
        //         //sh ''
        //     }
        // }

        // stage('Deploy to AWS') {
        //     steps {
        //         //use aws
        //         //sh ''
        //     }
        // }
    }
}

