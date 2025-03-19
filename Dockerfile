FROM maven:3.8.6-eclipse-temurin:17-jdk-alpine AS build

# Set the working directory inside the container
WORKDIR /usr/src/myapp

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the project and skip tests to speed up the process
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /usr/app

# Copy the built JAR file from the build stage
COPY --from=build /usr/src/myapp/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]