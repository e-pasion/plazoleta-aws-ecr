FROM openjdk:17
WORKDIR /app
COPY build/libs/*.jar /app/plazoleta-0.0.1-SNAPSHOT-plain.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "plazoleta-0.0.1-SNAPSHOT-plain.jar"]