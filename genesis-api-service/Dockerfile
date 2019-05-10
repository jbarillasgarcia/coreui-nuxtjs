FROM openjdk:8-jre-alpine
EXPOSE 9300
RUN mkdir /logs
ADD target/api-service-1.0.jar /opt/wauservices/genesis/api-service/api-service.jar
WORKDIR /opt/wauservices/genesis/api-service
ENTRYPOINT ["java", "-jar", "api-service.jar"]