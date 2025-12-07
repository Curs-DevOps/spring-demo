### Build
FROM amazoncorretto:17-alpine3.22-jdk as builder

WORKDIR /build

COPY .mvn .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

### Run
FROM amazoncorretto:17-alpine3.22-jdk as runner

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

RUN chown -R spring:spring /app

USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]