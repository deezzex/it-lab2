def gv
pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Init') {
            steps {
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    gv.compileApp()
                }
                echo 'Hello World'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-private-key', url: 'https://github.com/deezzex/it-lab2']]])
                bat 'mvn clean install'
            }
        }
    }
    post {
        always {
            junit(allowEmptyResults:true, testResults: '*test-reports/.xml')
        }
    }
}
