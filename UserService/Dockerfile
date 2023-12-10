FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/userservice.jar userservice.jar
ENTRYPOINT ["java","-jar","/userservice.jar"]