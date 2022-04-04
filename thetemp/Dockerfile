FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/azweb-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} azweb-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/azweb-0.0.1-SNAPSHOT.jar"]