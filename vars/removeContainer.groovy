def call(){
    sh 'docker stop diutup'
    sh 'docker rm diutup'
}