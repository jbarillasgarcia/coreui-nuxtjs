# Genesis Zuul Gateway

## Docker Container

### Dockerfile
```
FROM openjdk:8-jre-alpine
EXPOSE 8762
RUN mkdir /logs
ADD target/zuul-gateway-1.0.jar /opt/wauservices/genesis/zuul-gateway/zuul-gateway.jar
WORKDIR /opt/wauservices/genesis/zuul-gateway
ENTRYPOINT ["java", "-jar", "zuul-gateway.jar"]
```

### Build Docker Image

```
docker build -t wau/genesis-zuul-gateway:latest .
```

where:

- **-t** indicates the name and tag to be given to the image using the 'name:tag' format

### Run Docker Container

```
docker run --name genesis-zuul-gateway -d -p 8762:8762 -v /tmp/logs:/logs wau/genesis-zuul-gateway
```

where:

- **--name** indicates a user friendly name to refer this container instance in the future
- **-d** indicates the container to run in the background
- **-p** indicates the host port to map the port within the container on which service is exposed by default
- **-v** indicates a host directory to link to a folder within the container on which service uses to get/put files

### Stop Docker Container

```
docker container stop genesis-zuul-gateway
```