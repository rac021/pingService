

**Steps**

```
❯  $  mvn clean install
   
```

*ApplicationConnectors on port 8081 :*

```
❯  $  java -jar target/pingService-1.0-SNAPSHOT.jar server config.yml

   $  curl http://localhost:8081/ping
   
   $  curl http://localhost:8081/sleep/2000 # Sleep 2 second
   
```

*adminConnectors on port 8082 :*

```
❯  $  curl http://localhost:8082/ping
  
```


**Create Docker image**

*1 - From Dockerfile :*

```
❯  $  docker build -t pingservice .

   $  docker run -d -it \
      -l traefik.backend=ping \
      -l traefik.frontend.rule=Host:ping.localhost \
      -p 8081 -p 8082 pingservice server /opt/config.yml
   
```

*2 - From Docker Hub :* [https://hub.docker.com/r/rac021/pingservice](https://hub.docker.com/r/rac021/pingservice)

```
❯  $  docker run -d -it \
      -l traefik.backend=ping \
      -l traefik.frontend.rule=Host:ping.localhost \
      --name myPingService -p 8081 -p 8082 rac021/pingservice
   
```

*3 - Test :*

```
❯  $ docker inspect --format '{{ .NetworkSettings.Ports }}'  myPingService

   $ curl $(hostname --all-ip-addresses | awk '{print $1}'):LOCAL_PORT/ping
   
   $ curl $(hostname --all-ip-addresses | awk '{print $1}'):LOCAL_PORT/sleep/2000
   
```

