# Stage 1: Build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /usr/src/myapp
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-slim
WORKDIR /usr/app
COPY --from=build /usr/src/myapp/target/myapp-1.0.0.jar app.jar
COPY src/main/resources/application.yml /usr/app/config/application.yml
ENV SPRING_CONFIG_LOCATION=file:/usr/app/config/application.yml
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/application.yml"]