FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/rmkib.giga_requirements.mcp_server-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
# COPY src/main/webapp .
ENTRYPOINT ["java", "-jar", "/app.jar"]