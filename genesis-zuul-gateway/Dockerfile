FROM openjdk:8-jre-alpine
EXPOSE 8762
RUN mkdir /logs
ADD target/zuul-gateway-1.0.jar /opt/wauservices/genesis/zuul-gateway/zuul-gateway.jar
WORKDIR /opt/wauservices/genesis/zuul-gateway
ENTRYPOINT ["java", "-jar", "zuul-gateway.jar"]