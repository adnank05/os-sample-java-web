pipeline
{

agent any

    stages
    {   
        stage('Build')
        {
            steps
            {
                echo "compiling code"
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                sh 'mvn clean compile';
            }
        }

    }   

}