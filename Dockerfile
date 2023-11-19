
FROM openjdk:17

COPY target/demo.jar demo.jar
COPY src ./src

ENTRYPOINT ["java", "-jar", "/demo.jar"]