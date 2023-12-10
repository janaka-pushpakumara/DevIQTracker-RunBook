FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD UserService/target/userservice.jar userservice.jar
ENTRYPOINT ["java","-jar","/userservice.jar"]