FROM openjdk:8
EXPOSE 9095
ADD target/project-service-docker.jar project-service-docker.jar
ENTRYPOINT ["java","-jar","/project-service-docker.jar"]