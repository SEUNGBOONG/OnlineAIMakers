# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy the JAR file from the local build/libs directory to the container
COPY ./build/libs/study-0.0.1-SNAPSHOT.jar /app/study.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/study.jar"]

# Expose the port the app runs on
EXPOSE 8080
