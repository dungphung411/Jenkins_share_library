def call(String dockerHubUsername, String imageName) {
    // First login to docker hub to run pull and push 
    // Sensitive data type so i wont push to herer 
       // run command: docker login -u <username> then enter ypur password  
    
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=cffb97183cmshb2049eacbc0dfc9p1d5ea9jsned43366c7585 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}



// #add inside parameter
//  string(name: 'DOCKER_HUB_USERNAME', defaultValue: 'sevenajay', description: 'Docker Hub Username')
//  string(name: 'IMAGE_NAME', defaultValue: 'youtube', description: 'Docker Image Name')
// #stage
// stage('Docker Build'){
//         when { expression { params.action == 'create'}}
//             steps{
//                 script{
//                    def dockerHubUsername = params.DOCKER_HUB_USERNAME
//                    def imageName = params.IMAGE_NAME
//                    dockerBuild(dockerHubUsername, imageName)
//                 }
//             }
//         }
//         stage('Trivy iamge'){
//         when { expression { params.action == 'create'}}
//             steps{
//                 trivyImage()
//             }
//         }
