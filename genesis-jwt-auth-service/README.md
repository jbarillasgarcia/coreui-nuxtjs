# Genesis Java Web Token Authentication and Authorization Service

## Docker Container

### Dockerfile
```
FROM openjdk:8-jre-alpine
EXPOSE 9100
RUN mkdir /logs
ADD target/jwt-auth-service-1.0.jar /opt/wauservices/genesis/jwt-auth-service/jwt-auth-service.jar
WORKDIR /opt/wauservices/genesis/jwt-auth-service
ENTRYPOINT ["java", "-jar", "jwt-auth-service.jar"]
```

### Build Docker Image

```
docker build -t wau/genesis-jwt-auth-service:latest .
```

where:

- **-t** indicates the name and tag to be given to the image using the 'name:tag' format

### Run Docker Container

```
docker run --name genesis-jwt-auth-service -d -p 9100:9100 -v /tmp/logs:/logs wau/genesis-jwt-auth-service
```

where:

- **--name** indicates a user friendly name to refer this container instance in the future
- **-d** indicates the container to run in the background
- **-p** indicates the host port to map the port within the container on which service is exposed by default
- **-v** indicates a host directory to link to a folder within the container on which service uses to get/put files

### Stop Docker Container

```
docker container stop genesis-jwt-auth-service
```