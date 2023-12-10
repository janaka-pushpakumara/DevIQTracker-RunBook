FROM openjdk:8-jdk-alpine
EXPOSE 9092
ADD OauthService/target/authservice.jar authservice.jar
ENTRYPOINT ["java","-jar","/authservice.jar"]