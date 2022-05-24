
pipeline {
    agent any
    environment {
    PATH = "C:\\WINDOWS\\SYSTEM32"
    }
     post {  
         always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful'  
         }  
         failure {  
             mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "BUILD FAILURE: Project name -> ${env.JOB_NAME}", to: "kantharajj46@gmail.com";  
         }  
         unstable {  
             echo 'This will run only if the run was marked as unstable'  
         }  
         changed {  
             echo 'This will run only if the state of the Pipeline has changed'  
             echo 'For example, if the Pipeline was previously failing but is now successful'  
         }  
     }  
    tools {
        maven 'MAVEN'
    }
    stages{
    stage ('Compile ')
{
steps
 
{
bat 'mvn compile'
}

}
        stage('Test') {
            steps 
      {
                echo 'Testing..'
                bat 'mvn test'
            }
        
        }
        
        stage('packaging') {
            steps
      {
                echo 'Testing..'
                bat 'mvn package'
            }
        
        }
        }
    } 
