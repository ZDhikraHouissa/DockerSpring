
pipeline {
  agent any
  environment {
    registryBack = "dhikrahouissa/spring-docker-project"
    registryCredential = 'dockerhub'
    customDockerSpringImage = ''
	latestDockerSpringImage = ''
    GIT_LATEST_COMMIT_EDITOR= sh(
            returnStdout:true,
            script: 'git show -s --pretty=%cn '
        ).trim()
  }
  stages {
	  
      stage('Clone repository') {               
           steps{
			   
          checkout scm   
		   }		  
      }  
	  
        stage ('Show commit author') {
            steps {
			script{
			
                sh "echo '${env.GIT_LATEST_COMMIT_EDITOR}'"
            }}
        }
    stage('Build Spring Image') {
      steps{script{
          env.latestDockerSpringImage = docker.build( env.registryBack )
          env.customDockerSpringImage = docker.build( "${env.registryBack}:${env.BUILD_ID}" )
      }}
    }
    
    stage('Deploy Spring Image') {
      steps{ script{
         
           docker.withRegistry( '' , env.registryCredential ) {
           env.customDockerSpringImage.push()
		   env.latestDockerSpringImage.push()
            }
        }
      }
    }
    
   
  }
}
