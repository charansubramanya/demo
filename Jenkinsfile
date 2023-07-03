pipeline{
    agent any
     stages{
         stage("Clean") {
            steps {
                sh "mvn clean"
            }
    }
     stage("validate") {
            steps {
                sh "mvn validate"
            }
      }
      stage("compile") {
            steps {
                sh "mvn compile"
            }
      }
     stage("test compile") {
            steps {
                sh "mvn test-compile"
            }
      }
      stage("package") {
            steps {
                sh "mvn package"
            }
      }
  stage('Build and Push Docker Image') {
      environment {
        DOCKER_IMAGE = "charan0019/assignment:${BUILD_NUMBER}"
        // DOCKERFILE_LOCATION = "java-maven-sonar-argocd-helm-k8s/spring-boot-app/Dockerfile"
        REGISTRY_CREDENTIALS = credentials('docker-cred')
      }
      steps {
        script {
            sh ' docker build -t ${DOCKER_IMAGE} .'
            def dockerImage = docker.image("${DOCKER_IMAGE}")
            docker.withRegistry('https://index.docker.io/v1/', "docker-cred") {
                dockerImage.push()
            }
        }
      }
    }
}
}