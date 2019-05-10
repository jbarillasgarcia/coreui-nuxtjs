FROM openjdk:8-jre-alpine
EXPOSE 8761
RUN mkdir /logs
ADD target/eureka-server-1.0.jar /opt/wauservices/genesis/eureka-server/eureka-server.jar
WORKDIR /opt/wauservices/genesis/eureka-server
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]