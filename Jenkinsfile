pipeline {
    agent any
    stages {
	stage('checkout') {
        steps {
            git branch: 'main', credentialsId: '2b80f3f4-6843-4733-9807-47b3d11d8964', url: 'https://github.com/AnushaV14/CICDTest.git'
        }
    }
    stage('build') {
        steps { 
	script {
		env.PATH = "C:/Users/anusha_vujjini/eclipse/apache-maven-3.9.6/bin;c:\\Windows\\System32"
	}           
            bat label: '', script: 'mvn compile'
        }
    }
    stage('archive') {
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