FROM openjdk:8-jdk-alpine
#VOLUME /tmp
WORKDIR /app
EXPOSE 8000
ADD target/*.jar /app/app.jar
COPY ops/* /app/
ENV JAVA_OPTS=""
ENTRYPOINT [ "/app/bash"]