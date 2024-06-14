pipeline {
    agent any
    stages {
	stage('Checkout') {
        steps {
            git branch: 'main', credentialsId: '2b80f3f4-6843-4733-9807-47b3d11d8964', url: 'https://github.com/AnushaV14/CICDTest.git'
        }
    }
    stage('Build') {
        steps {
            bat label: '', script: 'mvn compile'
        }
    }
    stage('Archive') {
        steps {
            archiveArtifacts artifacts: 'target/'
        }
    }
    }

    post{
        success {
            echo 'Project build successfully!'
        }
        failure {
            echo 'Project build failed!'
        }
    }
}