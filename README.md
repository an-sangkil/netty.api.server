


## Docker 실행  
### 1. Docker Console 접속 
	cd {PROJECT_HOME_PATH}
	mvn clean package
	mvn dockerfile:build  

	> docker repository 명은 maven plug in 파일에 정의 되어 있다. (pom.xml)
	
	
### 2. docker run 방법 
	docker run -d --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver
	docker run -e "SPRING_PROFILES_ACTIVE=prod" -d --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver
	docker run -e "SPRING_PROFILES_ACTIVE=prod" --name "nettyApiServer" -p 80:8080 -t mezzomedia/adserver

### 3. docker Start

	docker start nettyApiServer

### 4. docker upload
	docker login
	docker tag mezzomedia/adserver:latest adverserver:0.1
	
	 

	
	