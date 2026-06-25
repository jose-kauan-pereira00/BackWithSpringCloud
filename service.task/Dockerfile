FROM maven:3.9-amazoncorretto-25 as build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install -DskipTests

FROM amazoncorretto:25

COPY --from=build /app/target/*.jar /app/app.jar

WORKDIR /app

EXPOSE 8081

CMD [ "java", "-jar", "app.jar"]