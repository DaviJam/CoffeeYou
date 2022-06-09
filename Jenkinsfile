node {
    stage('SCM') {
        step {
          checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DaviJam/CoffeeYou.git']]])
        }
        agent any
    }

    stage('Compile') {
        step {
          sh 'mvn clean compile'
        }
        agent any
    }

    stage('Test') {
        step {
            try {
                sh 'mvn test'
            } finally {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/site/jacoco/*.xml'])
            }
        }
        agent any
    }

    stage('Docs') {
        step {
          sh 'mvn javadoc:javadoc'
        }

        agent any
    }
}

