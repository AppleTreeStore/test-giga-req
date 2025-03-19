FROM openjdk:17-jdk-slim
ARG WAR_FILE=target/rmkib.giga_requirements.mcp_server-1.0.0-SNAPSHOT.war
COPY ${WAR_FILE} app.war
# COPY src/main/webapp .
ENTRYPOINT ["java", "-jar", "/app.war"]