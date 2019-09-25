FROM openjdk:11.0.4-jdk-slim-buster
MAINTAINER kevin.brunner@zhdk.ch
VOLUME /tmp
RUN mkdir -p /opt/app
ARG JAR_NAME=../target/game-service-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} /opt/app/app.jar
COPY game-service/target/game-service-0.0.1-SNAPSHOT.jar /opt/app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app/app.jar"]
