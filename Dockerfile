FROM openjdk:17-jdk-slim
COPY --from=build /app/target/rmkib.giga_requirements.mcp_server-1.0.0-SNAPSHOT.jar app.jar
# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
