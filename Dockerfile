FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8000
ADD target/*.jar app.jar
RUN mkdir -p /app/bin
ADD app app/
ENV JAVA_OPTS=""
ENTRYPOINT [ "/bin/bash"]