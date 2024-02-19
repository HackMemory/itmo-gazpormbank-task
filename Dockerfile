FROM gradle:jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/server-manager-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "server-manager-0.0.1-SNAPSHOT.jar"]
