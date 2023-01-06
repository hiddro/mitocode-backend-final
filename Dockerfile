FROM openjdk:11
EXPOSE 8081
ADD target/final-docker-jenkins-integration.jar final-docker-jenkins-integration.jar
ENTRYPOINT ["java", "-jar", "/final-docker-jenkins-integration.jar"]