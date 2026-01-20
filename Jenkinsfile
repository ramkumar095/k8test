pipeline {
  agent any
  tools {
    jdk 'Java21'
    maven 'Maven'
  }
  stages {
    stage('Checkout Code') {
      steps {
        echo 'Pulling from Github'
        git branch: 'main', credentialsId: 'mygithubcred', url: 'https://github.com/chntraining/k8test.git'
      }
    }
    stage('Test Code') {
      steps {
        echo 'JUNIT Test case execution started'
        bat 'mvn clean test'
        
      }
      post {
        always {
		  junit '**/target/surefire-reports/*.xml'
          echo 'Test Run is SUCCESSFUL!'
        }

      }
    }
    stage('Build Project') {
      steps {
        echo 'Building Java project'
        bat 'mvn clean package -DskipTests'
      }
    }
    stage('Build the Docker Image') {
      steps {
        echo 'Building Docker Image'
        bat 'docker build -t myindiaproj:1.0 .'
      }
    }
    stage('Push Docker Image to DockerHub') {
      steps {
        echo 'Pushing  Docker Image'
        withCredentials([string(credentialsId: 'dockerhub', variable: 'DOCKER_PASS')]) {
  	      bat '''
          echo %DOCKER_PASS% | docker login -u ramkumar095 --password-stdin
          docker tag myjavaproj:1.0 ramkumar095/myindiaproj:1.0
          docker push ramkumar095/myindiaproj:1.0
          '''}
      }
    }
	  stage('Deploy Project to K8s') {
      steps {
        echo 'Deploy Java project to Kubernetes'
		bat '''
		  minikube delete
		  minikube start
		  minikube image load ramkumar095/myindiaproj:1.0
          kubectl apply -f deployment.yaml
		  kubectl apply -f services.yaml
		  kubectl get pods
		  kubectl describe pods
		  kubectl get services
		  minikube addons enable dashboard
		  minikube dashboard
		'''
      }
    }
    /*stage('Run Docker Container') {
      steps {
        echo 'Running Java Application'
        bat '''
        docker rm -f myjavaproj-container || exit 0
        docker run --name myjavaproj-container myjavaproj:1.0
        
        '''               
      }
    }*/
  }
  post {
    success {
      echo 'BUild and Run is SUCCESSFUL!'
    }
    failure {
      echo 'OOPS!!! Failure.'
    }
  }
}
