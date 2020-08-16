node('master'){
       stage('ENV vars'){
        sh """
            whoami
            java -version
            mvn -version
        """
           }
           stage('Checkout Code'){
               git 'https://github.com/akshaypaturkar07/Sapient_Football.git'
           }
           stage('clean'){
                sh "mvn clean"
           }

           stage('compile code'){
                 sh "mvn compile"
           }
           stage('test code'){
                            sh "mvn test"
                      }
           stage('Build Docker Image'){
           sh """
                mvn package  -DskipTests
           """

           }
           stage('Run Docker Container'){
                     sh 'docker run --publish 8090:9090 --detach --name football sapient_football:latest'
              }
            stage('Push Docker Image'){
                sh "mvn deploy"
           }






}