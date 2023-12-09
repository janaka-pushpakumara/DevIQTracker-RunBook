FROM openjdk:8
EXPOSE 9092
ADD target/authservice.jar authservice.jar
ENTRYPOINT ["java","-jar","/authservice.jar"]