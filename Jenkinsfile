pipeline {
    // master executor should be set to 0

    environment {
        registry = "juanzuniga/selenium-docker"
        registryCredential = 'dockerhub'
        //dockerImage = ''
      }
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='juanzuniga/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'juanzuniga', passwordVariable: 'Juanin12', usernameVariable: 'user')]) {
                    //sh
			        //sh "docker login --username=juanzuniga --password=Juanin12"
			        sh "docker push juanzuniga/selenium-docker:latest"
			    }                           
            }
        }
    }
}