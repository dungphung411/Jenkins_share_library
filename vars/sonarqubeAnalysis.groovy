def call() {
    withSonarQubeEnv('sonar-scanner') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Youtube -Dsonar.projectKey=Youtube '''
    }
}