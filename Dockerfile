

FROM openjdk:17

COPY target/demo.jar demo.jar

ENTRYPOINT ["java", "-jar", "/demo.jar"]