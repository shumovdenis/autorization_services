FROM openjdk:11
EXPOSE 8080
ADD target/autorization-0.0.1-SNAPSHOT.jar a-s.jar
ENTRYPOINT ["java", "-jar", "a-s.jar"]