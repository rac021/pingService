

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
