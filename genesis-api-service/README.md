# Genesis Application Program Interface Service

## Docker Container

### Dockerfile
```
FROM openjdk:8-jre-alpine
EXPOSE 9300
RUN mkdir /logs
ADD target/api-service-1.0.jar /opt/wauservices/genesis/api-service/api-service.jar
WORKDIR /opt/wauservices/genesis/api-service
ENTRYPOINT ["java", "-jar", "api-service.jar"]
```

### Build Docker Image

```
docker build -t wau/genesis-api-service:latest .
```

where:

- **-t** indicates the name and tag to be given to the image using the 'name:tag' format

### Run Docker Container

```
docker run --name genesis-api-service -d -p 9300:9300 -v /tmp/logs:/logs wau/genesis-api-service
```

where:

- **--name** indicates a user friendly name to refer this container instance in the future
- **-d** indicates the container to run in the background
- **-p** indicates the host port to map the port within the container on which service is exposed by default
- **-v** indicates a host directory to link to a folder within the container on which service uses to get/put files

### Stop Docker Container

```
docker container stop genesis-api-service
```