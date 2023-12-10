FROM openjdk:8-jdk-alpine
EXPOSE 9095
ADD ProjectService/target/projectservice.jar projectservice.jar
ENTRYPOINT ["java","-jar","/projectservice.jar"]