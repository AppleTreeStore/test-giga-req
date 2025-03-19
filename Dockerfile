FROM openjdk:17-jdk-slim
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac GigaRequirementsApp.java
CMD ["java", "GigaRequirementsApp"]