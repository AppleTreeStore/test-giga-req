# Этап сборки
FROM maven:3.8.6-openjdk-17-slim AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл pom.xml и загружаем зависимости
COPY pom.xml .
COPY src ./src

# Собираем проект
RUN mvn clean package -DskipTests

# Финальный образ
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный jar файл из предыдущего этапа
COPY --from=build /app/target/rmkib.giga_requirements.mcp_server-1.0.0-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
