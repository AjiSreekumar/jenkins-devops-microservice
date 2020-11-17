FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8000
ADD target/*.jar app.jar, ops/*
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c"]