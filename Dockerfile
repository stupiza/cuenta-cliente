FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY "./target/cuenta-cliente-0.0.1-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java","-jar","/app.jar"]