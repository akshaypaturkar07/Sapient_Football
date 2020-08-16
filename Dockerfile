FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER Akshay Paturkar <akshaydp07@gmail.com>
ARG DEPENDENCY=target
COPY ${DEPENDENCY}/footballdemo-0.0.1-SNAPSHOT.jar /tmp
ENTRYPOINT ["java","-jar","/tmp/footballdemo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090