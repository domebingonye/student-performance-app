FROM maven:3.9.6-eclipse-temurin-21-jammy as build

WORKDIR usr/src/app

COPY . ./

RUN mvn clean install

FROM eclipse-temurin:21-jdk

WORKDIR /usr/src/app

EXPOSE 8015
ENV TZ Africa/Lagos

COPY --from=build /usr/src/app/target/student-performance-app-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java","-jar", "./app.jar"]

