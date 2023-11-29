FROM openjdk:8
EXPOSE 8080
ADD target/project-service-docker.jar project-service-docker.jar
ENTRYPOINT ["java","-jar","/project-service-docker.jar"]