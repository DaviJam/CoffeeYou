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
                    step([$class: 'JacocoPublisher',
                        execPattern: 'target/*.exec',
                        classPattern: 'target/classes',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: 'src/test*'
                    ])
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
                // build image
                sh('docker build --tag you-coffee:latest .')
                // tag image in order to push to registry
                sh('docker tag you-coffee:latest dada971/you-coffee:v$BUILD_NUMBER')
                // push to hub
                sh('docker push dada971/you-coffee:v$BUILD_NUMBER')
            }
        }


        stage('Save to Nexus Repository') {

            steps {
             configFileProvider([configFile(fileId: 'nexus-repository', variable: 'MAVEN_SETTINGS')]) {

                    sh('echo $MAVEN_SETTINGS')
                    sh('mvn -s $MAVEN_SETTINGS clean deploy')
                }
//                 sh('mvn clean deploy -s settings.xml')
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

