# Stage 1: Build the application using Maven and OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Run Maven to clean, compile, and package the JAR file
RUN mvn clean package

# Stage 2: Run the application using OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory for the runtime environment
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/gym_membership-1.0-SNAPSHOT.jar /app/gymapp.jar

# Expose the application port (if needed)
EXPOSE 8080

# Entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "gymapp.jar"]
