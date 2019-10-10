# Netty.API.Server
 - Netty Http 코덱을 이용한 Rest APIServer  

## Docker 실행  
### 1. Docker Console 접속
``` bash 
	cd {PROJECT_HOME_PATH}
	mvn clean package
	mvn dockerfile:build  
	
	# docker repository 명은 maven plug in 파일에 정의 되어 있다. (pom.xml)
```

### 2. docker run 방법
``` bash
	docker run -e "SPRING_PROFILES_ACTIVE=prod" --name "nettyApiServer" -p 80:8080 -t sangkil.an/adserver
```
  __docker option__
   - -e 컨테이너 내에서 사용할 환경변수 설정
   - -d 백그라운드 모드 

### 3. docker Start
``` bash
	docker start nettyApiServer
```

### 4. docker upload
``` bash
	docker login
	docker tag mezzomedia/adserver:latest adverserver:0.1
```
	
	 

