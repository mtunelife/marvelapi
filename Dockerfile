# ---------- Stage 1: build the JAR ----------
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app

# Copy Maven wrapper + pom first so dependencies are cached between builds
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -q

# Copy source and build
COPY src src
RUN ./mvnw clean package -DskipTests -q

# ---------- Stage 2: run with a smaller JRE image ----------
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# No port is hardcoded: Spring reads server.port=${PORT:8080}
# No secrets here: SPRING_DATASOURCE_URL is set in Render's Environment settings
ENTRYPOINT ["java", "-jar", "app.jar"]
