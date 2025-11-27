# ETAPA 1: Construcción (Compilar el código)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Arrancar la app)
FROM eclipse-temurin:21-jdk
WORKDIR /app
# Aquí buscamos el archivo .jar que se creó en la etapa anterior y lo renombramos a app.jar
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]