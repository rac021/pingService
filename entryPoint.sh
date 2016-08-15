#/bin/bash

docker run -d -it -p 8081 -p 8082 pingservice server /opt/config.yml
