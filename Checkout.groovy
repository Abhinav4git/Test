pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'BitbucketSCM',
                    credentialsId: 'your_credentials_id',
                    cloneType: 'ssh',
                    extensions: [[$class: 'CleanBeforeCheckout']],
                    repositoryUrl: 'git@bitbucket.org:your_username/your_repository.git',
                    ref: 'master'  // or specify the branch or commit you want to check out
                ])
            }
        }

        // Add more stages for your build, test, deploy, etc.
    }
}


//In the above example, replace 'your_credentials_id' with the ID of the Bitbucket credentials you've configured in Jenkins. Replace 'your_username/your_repository.git' with the actual repository URL you want to search for.

Save and commit the Jenkinsfile in your Bitbucket repository. When you run the Jenkins pipeline, it will clone the specified Bitbucket repository and checkout the desired branch or commit for further processing.
Note that you may need to configure additional parameters or options based on your specific requirements, such as branch filtering, pull requests, etc. Consult the Bitbucket Branch Source Plugin documentation for more advanced usage.//
    
    
    In a Jenkinsfile, you can use the dir step to change the current directory of the Pipeline.
    This can be useful in cases where you need to change directories to run a specific command or access files in a different location. Here's an example usage:

pipeline {
    agent any
    stages {
        stage('Change Directory') {
            steps {
                dir('my_directory') {
                    sh 'ls -la'
                }
            }
        }
    }
}
