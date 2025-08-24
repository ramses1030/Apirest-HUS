# Usa una imagen base de Java 17
FROM docker.io/eclipse-temurin:17-jre

# Crea el directorio de trabajo
WORKDIR /app

# Copia el jar generado por Maven al contenedor
COPY target/apisrest-hus-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]