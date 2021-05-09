# Build the application first using Maven
FROM maven:3.8-openjdk-8
WORKDIR /app
COPY . .
RUN mvn install

# Inject the JAR file into a new container to keep the file small
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/spring-docker.jar /app/spring-docker.jar
EXPOSE 8080

CMD ["java", "-jar", "/app/spring-docker.jar"]