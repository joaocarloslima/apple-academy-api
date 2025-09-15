# ---- Build (Maven com JDK 21) ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Cache das dependências
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copia o resto e compila
COPY . .
RUN chmod +x mvnw || true
RUN ./mvnw -q -DskipTests clean package

# ---- Runtime (JRE 21) ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# No Render a porta vem de $PORT
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
