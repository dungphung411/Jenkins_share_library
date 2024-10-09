def call(){
    sh "docker run -d -t  --name diutup -p 3000:3000 mdngphg411/youtube:latest"
}