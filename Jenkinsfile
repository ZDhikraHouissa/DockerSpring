pipeline {
  agent any
  environment {
    registryBack = "dhikrahouissa/spring-docker-project"
    registryCredential = 'docker-hub'
    customDockerSpringImage = '' 
    latestDockerSpringImage = ''
    GIT_LATEST_COMMIT_EDITOR = sh(
      returnStdout: true,
      script: 'git show -s --pretty=%cn '
    ).trim()
  }
  stages {

    stage('Clone repository') {
      steps {
        checkout scm
      }
    }

    stage('Show commit author') {
      steps {
        script {

          sh "echo '${env.GIT_LATEST_COMMIT_EDITOR}'"
        }
      }
    }
    stage('Build Spring Image') {
      steps {
        script {
           latestDockerSpringImage = docker.build(env.registryBack)
         }
      }
    }

    stage('Deploy Spring Image') {
      steps {
        script {

          docker.withRegistry('https://registry.hub.docker.com', env.registryCredential) {
			latestDockerSpringImage.push("$BUILD_NUMBER")
			latestDockerSpringImage.push('latest')          }
        }
      }
    }

  }
}