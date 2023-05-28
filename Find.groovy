pipeline {
    agent any
    
    stages {
        stage('Search Files') {
            steps {
                script {
                    // Define the directory where you want to search for files
                    def searchDirectory = '/path/to/search/directory'
                    
                    // Define the extensions you want to search for
                    def fileExtensions = ['.txt', '.csv', '.log']
                    
                    // Search for files with the specified extensions
                    def foundFiles = findFiles(glob: "${searchDirectory}/**/*.{${fileExtensions.join(',')}}")
                    
                    // Print the found file paths
                    foundFiles.each { file ->
                        println "Found file: ${file}"
                    }
                    
                    // You can perform further actions with the found files, such as processing or copying them
                }
            }
        }
    }
}



//In this example, the findFiles step is used to search for files in the specified directory (searchDirectory) with the given extensions (fileExtensions). The glob parameter allows you to specify a pattern using the {} syntax to match multiple file extensions. The foundFiles variable stores the paths of the found files.

//You can customize the searchDirectory and fileExtensions variables to match your specific requirements. Additionally, you can add more stages or steps to perform further actions with the found files, such as processing or copying them.

//Make sure to replace /path/to/search/directory with the actual directory path you want to search in.


