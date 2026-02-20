
FROM ubuntu:22.04 AS builder

RUN apt-get update && apt-get install -y \
    curl \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

RUN curl -L https://download.oracle.com/java/25/latest/jdk-25_linux-x64_bin.tar.gz -o jdk.tar.gz \
    && mkdir -p /opt/java \
    && tar -xzf jdk.tar.gz -C /opt/java --strip-components=1

ENV JAVA_HOME=/opt/java
ENV PATH="$JAVA_HOME/bin:$PATH"

RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/todolistapi-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]