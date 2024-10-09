def call(){
    sh "docker run -d -t  --name Diu -p 3000:3000 mdngphg411/youtube:latest"
}