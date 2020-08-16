node('master'){
        def dockerHome = tool 'mydocker'
        def mavenHome  = tool 'maven-3'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
        stage('ENV vars'){
        sh """
            whoami
            java -version
            mvn -version
            docker -v
            export DOCKER_HOST=unix:///var/run/docker.sock
            export DOCKER_OPTS=' -G jenkins'
            export DOCKER_SOCKET=/var/run/docker.sock
            echo $PATH
            docker images
        """
           }
           stage('Checkout Code'){
               git 'https://github.com/akshaypaturkar07/OrderUpdate.git'
           }
           stage('clean'){
                sh "mvn clean"
           }

           stage('compile code'){
                 sh "mvn compile"
           }
           stage('Build Docker Image'){
           sh """
                whoami
                export DOCKER_HOST=unix:///var/run/docker.sock
                export DOCKER_OPTS=' -G jenkins'
                mvn package  -DskipTests
           """

           }
           stage('Flyway Clean'){
                sh "mvn flyway:clean"
           }

           stage('Flyway Migrate'){
                sh "mvn flyway:migrate"
           }
           stage('Run Docker Container'){
                     sh 'docker run --publish 8090:9090 --detach --name orderdetails orderdetails:latest'
              }
           stage("Unit Test"){
               sh "mvn test"
           }



           stage('Push Docker Image'){
                sh "mvn deploy"
           }

           stage('Run Application'){

           }






}