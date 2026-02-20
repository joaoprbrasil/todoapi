FROM maven:3.9.9-eclipse-temurin-21 AS builder


WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

EXPOSE 8080

COPY --from=builder /app/target/todolistapi-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]