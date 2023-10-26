FROM maven:3.9.3-eclipse-temurin-17 
EXPOSE 8089
ADD target/transport-ms-0.0.1-SNAPSHOT.jar transport-ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "transport-ms-0.0.1-SNAPSHOT.jar"]