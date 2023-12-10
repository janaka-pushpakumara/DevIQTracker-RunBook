FROM openjdk:8-jdk-alpine
EXPOSE 9091
ADD GatewayService/target/gatewayservice.jar gatewayservice.jar
ENTRYPOINT ["java","-jar","/gatewayservice.jar"]