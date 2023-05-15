# Use the official Gradle image as the base image
FROM gradle:7.0.2-jdk11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src/ src/

# Build the application
RUN gradle build --no-daemon

# Create a new image with a smaller base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Copy application.properties file
COPY --from=builder /app/src/main/resources/application.properties app.props

# Expose the port on which the Spring Boot application runs
EXPOSE 8080

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar","--spring.config.location","app.props"]
