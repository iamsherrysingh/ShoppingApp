FROM openjdk:15
ADD target/ShoppingApp-0.0.1-SNAPSHOT.jar FrontController.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","FrontController.jar"]