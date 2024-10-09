    def call() {
    sh 'trivy fs . > trivyfs.txt'
}  




// stage('Trivy file scan'){
//         when { expression { params.action == 'create'}}
//             steps{
//                 trivyFs()
//             }
//         }
//         stage('OWASP FS SCAN') {
//         when { expression { params.action == 'create'}}
//             steps {
//                 dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
//                 dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
//             }
//         }