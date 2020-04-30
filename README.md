# Spring ShoppingApp

I am creating a Shopping Application based on Microservices architecture.
MicroServices planned are - Accounts MicroService, Product MicroService, Cart MicroService, Order MicroService, and a Shopping/FrontEnd MicroService
I am focusing mostly on the APIs for the backend.

### Technologies incorporated so far:
1. Spring Boot
2. Spring MVC
3. Spring Data JPA
4. Spring Cache
5. Spring Security


### To implement:
1. JWT Access Tokens
2. Photo Upload


This project contains all the microservices separated in packages with their own configuration, sql scripts, application launch class,and can deployed on different servers without much effort.
In the project's current state, these microservices can be spun up on just 1 server but at different ports.


## Shopping App Docker image build guide:
1. Install Docker
2. Import project as Maven Project
3. `run Maven clean, Maven install`
4. `docker pull openjdk:latest`
5. 'Dockerfile' is already in project root. Switch to project root.
6. Run: `docker build -f .\Dockerfile -t frontcontroller .`
7. `docker run -p 8082:8082 -frontCon frontcontroller`

######To start or stop frontCon container:
docker start frontCon
docker stop frontCon

Docker Note: Make sure there is only 1 main() in the project. Comment the other main()s if needed.
Ideally there should be 1 microservice per project, not multiple like in this project.

## MySQL docker setup guide
##### INITIAL SETUP:

1. `docker pull mysql:latest`
2. `docker run -p 3306:3306 --name=mysqlCon -e MYSQL_ROOT_PASSWORD=root -d mysql`
3. `docker exec -it mysqlCon mysql -uroot -p`
###### Once logged in to mysql container, allow all access to root
4. mysql> `GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';`
5. Create the databases, tables, joins as required

##### USING DATABASE:

######To start or stop mysqlCon container:
docker start mysqlCon
docker stop mysqlCon

###### To login to mysqlCon container
docker exec -it mysqlCon mysql -uroot -p

Note: Database connection string is `spring.datasource.url=jdbc:mysql://localhost:3306/shopping_app_frontend_db?useSSL=false`
      Database password for user root is root






## USEFUL DOCKER COMMANDS:

`docker --help`      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Full help  <br>
`docker COMMAND --help`    COMMAND specific help

###### operating on images
`docker build -f DockerFileName -t imageName .`  <br>
`docker images`                                  <br>
`docker image rm -f imageName `  OR `docker rmi imageName1 imageName2`                <br>

###### operating on containers
`docker run -p hostPort:dockerExposedPort --name=containerName -d imageName` <br>
`docker start containerName`                     <br>
`docker restart containerName`                   <br>
`docker stop containerName`                      <br>
`docker rm containerName`                        <br>
`docker rename containerName`                    <br>
`docker ps`                                      <br>
`docker ps -a `                                  <br>