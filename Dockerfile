FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /usr/src/myapp
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

FROM  openjdk:17-jdk-slim
WORKDIR /usr/app
COPY --from=build /usr/src/myapp/target/*.jar app.jar
COPY src/main/resources/application.yml /usr/app/config/application.yml
COPY app-secret.properties /config/app-secret.properties
ENV SPRING_CONFIG_LOCATION=file:/usr/app/config/application.yml
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/application.yml"]