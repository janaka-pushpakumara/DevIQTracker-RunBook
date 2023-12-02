FROM openjdk:8
EXPOSE 8080
ADD target/eureka-service-docker.jar eureka-service-docker.jar
ENTRYPOINT ["java","-jar","/eureka-service-docker.jar"]