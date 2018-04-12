# 


# Docker 실행
Docker Console 접속 
mvn clean package
mvn dockerfile:build  

docker run -d --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver
docker run -e "SPRING_PROFILES_ACTIVE=prod" -d --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver

docker run -e "SPRING_PROFILES_ACTIVE=prod" --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver

docker start nettyApiServer
