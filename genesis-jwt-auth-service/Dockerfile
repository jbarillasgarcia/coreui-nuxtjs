FROM openjdk:8-jre-alpine
EXPOSE 9100
RUN mkdir /logs
ADD target/jwt-auth-service-1.0.jar /opt/wauservices/genesis/jwt-auth-service/jwt-auth-service.jar
WORKDIR /opt/wauservices/genesis/jwt-auth-service
ENTRYPOINT ["java", "-jar", "jwt-auth-service.jar"]