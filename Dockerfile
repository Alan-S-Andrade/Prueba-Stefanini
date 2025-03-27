FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/user-api.jar user-api.jar

# Exponer puerto de la API
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-api.jar"]
