FROM openjdk:11
EXPOSE 8081
ADD target/final-0.0.1-SNAPSHOT.jar final-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/final-0.0.1-SNAPSHOT.jar"]