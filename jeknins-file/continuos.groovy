pipeline
{
    agent any
    tools 
    {
        jdk 'jdk-7'
        maven 'maven-3.5.3'
    }
    
    stages
    {
        
        stage('Initializing Tools')
        {
            steps
            {
                sh 'java -version'
                sh 'mvn --version'
                
            }
        }
        
       /* stage('Code Checkout')
        {
            steps
            {
                git branch : 'master',
                credentialsId: '53b4cb97-d628-475c-86ad-d84eea6e14f3',
                url: 'git@github.com:adnank05/os-sample-java-web.git'
            }
        }*/
        
        stage('Build')
        {
            steps 
            { 
                sh "ls -a" 
                sh 'mvn clean install -s /opt/tools/maven/maven-3.6.1/conf/settings.xml'
                
            }
        }
        boolean packageGeneration=true
        stage('Push war to nexus')
        {
            try
            {
                sh 'mvn clean deploy'
            } catch(Exception e){packageGeneration=false}
        }

       /* stage('Docker Build')
        {
            if(packageGeneration)
            {

            }
        }*/
        
    }
}
