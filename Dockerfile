FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/survey-0.0.1-SNAPSHOT.jar /app/apiSurvey.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/apiSurvey.jar"]