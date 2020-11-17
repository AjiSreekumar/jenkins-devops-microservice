FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8000
ADD target/*.jar /app.jar
COPY ops/* /tmp
ENV JAVA_OPTS=""
ENTRYPOINT [ "/tmp/bash"]