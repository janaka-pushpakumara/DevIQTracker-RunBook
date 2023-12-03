FROM openjdk:8
EXPOSE 9095
ADD target/authservice.jar authservice.jar
ENTRYPOINT ["java","-jar","/authservice.jar"]