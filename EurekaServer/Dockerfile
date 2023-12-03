FROM openjdk:8
EXPOSE 9090
ADD target/eurekaservice.jar eurekaservice.jar
ENTRYPOINT ["java","-jar","/eurekaservice.jar"]