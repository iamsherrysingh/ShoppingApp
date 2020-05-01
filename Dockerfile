FROM openjdk:latest
ADD target/ShoppingApp-0.0.1-SNAPSHOT.jar FrontController.jar
EXPOSE 8082
#ENTRYPOINT ["java","-jar","FrontController.jar"]

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/FrontController.jar"]