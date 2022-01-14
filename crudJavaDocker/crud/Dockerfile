FROM openjdk:11
ADD target/java-crud-docker.jar java-crud-docker.jar
ENTRYPOINT ["java", "-jar","java-crud-docker.jar"]
EXPOSE 8080

#docker build -t java-crud-docker.jar . > buil image