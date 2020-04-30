# Spring ShoppingApp

I am creating a Shopping Application based on Microservices architecture.
MicroServices planned are - Accounts MicroService, Product MicroService, Cart MicroService, Order MicroService, and a Shopping/FrontEnd MicroService
I am focusing mostly on the APIs for the backend.

#### Technologies incorporated so far:
1. Spring Boot
2. Spring MVC
3. Spring Data JPA
4. Spring Cache
5. Spring Security


#### To implement:
1. JWT Access Tokens
2. Photo Upload


This project contains all the microservices separated in packages with their own configuration, sql scripts, application launch class,and can deployed on different servers without much effort.
In the project's current state, these microservices can be spun up on just 1 server but at different ports.


#### Docker image build guide:
1. Install Docker
2. Import project as Maven Project
3. run Maven clean, Maven install
4. 'Dockerfile' is already in project root. Switch to project root.
5. Run: `docker build -f .\Dockerfile -t frontcontroller .`
6. `docker run -p 8082:8082 frontcontroller`

Docker Note: Make sure there is only 1 main() in the project. Comment the other main()s if needed.
Ideally there should be 1 microservice per project, not multiple like in this project.