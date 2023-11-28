FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM bellsoft/liberica-openjdk-alpine:latest
WORKDIR /app
COPY --from=build /app/target/labseq-app-0.0.1-SNAPSHOT.jar /app/labseq-app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/labseq-app-0.0.1-SNAPSHOT.jar"]