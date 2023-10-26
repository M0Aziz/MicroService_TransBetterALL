FROM maven:3.9.3-eclipse-temurin-17
EXPOSE 8090
ADD target/userContact-0.0.1-SNAPSHOT.jar userContact-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "userContact-0.0.1-SNAPSHOT.jar"]