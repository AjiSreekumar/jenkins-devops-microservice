FROM openjdk:8-jdk-alpine

EXPOSE 8000
ARG JAR_FILE=target/*.jar

WORKDIR /opt/app

COPY ${JAR_FILE} /app.jar

COPY ops/RunApp /opt/app/RunApp

ENV JAVA_OPTS=""
ENTRYPOINT [ "/opt/app/bash"]