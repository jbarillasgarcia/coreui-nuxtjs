# Genesis Eureka Server

## Docker Container

### Dockerfile
```
FROM openjdk:8-jre-alpine
EXPOSE 8761
RUN mkdir /logs
ADD target/eureka-server-1.0.jar /opt/wauservices/genesis/eureka-server/eureka-server.jar
WORKDIR /opt/wauservices/genesis/eureka-server
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
```

### Build Docker Image

```
docker build -t wau/genesis-eureka-server:latest .
```

where:

- **-t** indicates the name and tag to be given to the image using the 'name:tag' format

### Run Docker Container

```
docker run --name genesis-eureka-server -d -p 8761:8761 -v /tmp/logs:/logs wau/genesis-eureka-server
```

where:

- **--name** indicates a user friendly name to refer this container instance in the future
- **-d** indicates the container to run in the background
- **-p** indicates the host port to map the port within the container on which service is exposed by default
- **-v** indicates a host directory to link to a folder within the container on which service uses to get/put files

### Stop Docker Container

```
docker container stop genesis-eureka-server
```