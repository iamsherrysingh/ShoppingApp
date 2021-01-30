# Spring ShoppingApp

I am creating a Shopping Application based on Microservices architecture.
MicroServices planned are - Accounts MicroService, Product MicroService, Cart MicroService, Order MicroService, and a Shopping/FrontEnd MicroService
I am focusing mostly on the APIs for the backend.

### Technologies incorporated so far:
1. Docker
2. Spring Boot
3. Spring MVC
4. Spring Data JPA
5. Spring Cache
6. Spring Security (Authentication and JWT based Authorization)

### To implement:
1. Photo Upload


This project contains all the microservices separated in packages with their own configuration, sql scripts, application launch class,and can deployed on different servers without much effort.
In the project's current state, these microservices can be spun up on just 1 server but at different ports.

## Create a user defined bridge network
It is created so the containers can resolve each other with container name without using --link <br>
`docker network create my-network`


## MySQL docker setup guide

Quick way to setup DB server: I have committed my Docker mysqlCon container to an image iamsherrysingh/ecommerce-db-image .
The above image contains user setup.
To use the aforementioned image to create a Docker container:

1. `docker pull iamsherrysingh/ecommerce-db-image`
2. `docker run -p 3306:3306 --name=mysqlCon --net=my-network -d iamsherrysingh/ecommerce-db-image`

At this point, mysqlCon container is up and running. You can access the DB server now. Now restore DB data using a DB app of your choice. DB dump can be found in the source code.
If you'd like to get your hands dirty and create your MySQL server from scratch, follow the following commands:

##### INITIAL SETUP:

1. `docker pull mysql:latest`
2. `docker run -p 3306:3306 --name=mysqlCon --net=my-network -e MYSQL_ROOT_PASSWORD=root -d mysql`
3. `docker exec -it mysqlCon mysql -uroot -p`
###### Once logged in to mysql container, allow all access to root
4. mysql> `GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';`
5. Create the databases, tables, joins as required. For the purpose of this set you can use this script https://github.com/iamsherrysingh/ShoppingApp/blob/master/src/main/java/com/sherry/FrontendMicroService/shopping_app_frontend_db.sql

##### TO USE DATABASE:

To start or stop mysqlCon container: <br>
`docker start mysqlCon`<br>
`docker stop mysqlCon`

###### To login to mysqlCon container
`docker exec -it mysqlCon mysql -uroot -p`

**Note:** Database connection string is `spring.datasource.url=jdbc:mysql://mysqlCon:3306/shopping_app_frontend_db?useSSL=false&allowPublicKeyRetrieval=true`
      Database password for user root is root


## Shopping App Docker setup guide:
1. Install Docker
2. Import project as Maven Project
3. `run Maven clean, Maven install`
4. `docker pull openjdk:latest`
5. 'Dockerfile' is already in project root. Switch to project root.
6. Run: `docker build -f .\Dockerfile -t frontcontroller .`
7. `docker run -p 8082:8082 --name=frontCon --net=my-network frontcontroller`

Go to http://localhost:8082/ to access the application

To start or stop frontCon container: <br>
`docker start frontCon`<br>
`docker stop frontCon`

**Note:** Make sure there is only 1 main() in the project. Comment the other main()s if needed.
Ideally there should be 1 microservice per project, not multiple like in this project.


## USEFUL DOCKER COMMANDS:

`docker --help`      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Full help  <br>
`docker COMMAND --help`    COMMAND specific help

###### operating on Images
`docker build -f DockerFileName -t imageName .`  Create image using Dockerfile<br>
`docker images`                                  <br>
`docker image rm -f imageName `  OR `docker rmi imageName1 imageName2`                <br>

###### operating on Containers
`docker run -p hostPort:dockerExposedPort --name=containerName -d imageName` Create container using image <br>
`docker start containerName`                     <br>
`docker start $(docker ps -a -q)`   Start all containers<br>
`docker restart containerName`                   <br>
`docker stop containerName`                      <br>
`docker kills containerName`                     <br>
`docker rm containerName`                        <br>
`docker rename containerName`                    <br>
`docker ps`                                      <br>
`docker ps -a `                                  <br>
`docker stats containerName`                     <br>
`docker logs containerName`                      <br>
`docker exec -it containerName bash`             <br>

## Ignore the following if you are just setting up this project

Setup MSSQL in docker container <br>
`docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Password@123" -p 1433:1433 --name=mssql -d mcr.microsoft.com/mssql/server:2019-latest`

Download MS SMMS (or Heidi SQL) and login using the following credentials:  <br>
`Server:   localhost,1433`                       <br>
`Username: sa`                                   <br>
`Password: Password@123`                         <br>
