   pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean package'
            }
        }
        
        stage('Run Tests') {
            steps {
                // Run Selenium tests with TestNG
                sh 'mvn test -Dsurefire.suiteXmlFiles=smoketesttestngsuite.xml'
            }
            post {
                always {
                    // Archive the test results
                    archiveArtifacts(allowEmptyArchive: true, artifacts: '/target/index.html')
                }
            }
        }
    }
    
    post {
        failure {
            // Send an email notification in case of build/test failures 
            emailext subject: 'smoke test',
                      body: 'Hi manager. Please check the build logs for details. Regards NAG',
                      to: 'manager@mycompany.com',
                      attachLog: true
        }
    }
}
