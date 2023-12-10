FROM openjdk:8
EXPOSE 9092
ADD OauthService/target/authservice.jar authservice.jar
ENTRYPOINT ["java","-jar","/authservice.jar"]