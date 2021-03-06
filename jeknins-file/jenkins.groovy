pipeline
{

agent none

    tools
    {
        maven 'Maven-3.6.0'
        jdk 'java-1.8'
    }

    stages
    {   
        stage('Initializing Tools')
        { 
            agent any
              steps
                {
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                    '''
                    echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} on agent ${env.NODE_NAME}"
                }
        }
        stage('Build')
        {
            agent{
                    label 'master'
                }
            steps
            {
                echo "compiling code"
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL} on agent ${env.NODE_NAME}"
                sh 'mvn clean install';
            }
        }

    }   

}