# Utilise OpenJDK 17 comme image de base
FROM eclipse-temurin:17-jdk-jammy
# Hunter412_@
# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie le jar buildé dans le conteneur
COPY target/product-api-0.0.1-SNAPSHOT.jar app.jar

# Expose le port 8086
EXPOSE 8086

# Lance l'application
ENTRYPOINT ["java", "-jar", "app.jar"]