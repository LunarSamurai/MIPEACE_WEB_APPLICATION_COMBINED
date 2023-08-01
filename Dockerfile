# Use an official Java runtime as the base image
FROM openjdk:8-jdk-alpine
# Set the working directory in the container
WORKDIR /app

VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
# Copy the compiled Java application (JAR file) into the container
COPY target/mipeacebackendspringboot-0.0.1-SNAPSHOT.jar mipeacebackendspringboot.jar
# Expose the port that your Java application listens on (replace 8080 with the actual port)
EXPOSE 3000
# ENTRYPOINT exec java $JAVA_OPTS -jar mipeacebackendspringboot.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar mipeacebackendspringboot.jar
