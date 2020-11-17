FROM openjdk:8-jdk-alpine
WORKDIR /opt/app
EXPOSE 8000
ARG JAR_FILE= target/*.jar
COPY ${JAR_FILE} /app.jar
COPY ops/* 
ENV JAVA_OPTS=""
ENTRYPOINT [ "/opt/app/bash"]