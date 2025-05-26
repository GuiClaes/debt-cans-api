# Use OpenJDK 21 base image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built JAR from your Maven/Gradle build
COPY target/debt-cans-api.jar app.jar

# Expose port (Render uses PORT env var, so this is just documentation)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]