FROM openjdk:11.0.4-jdk-slim-buster as build
MAINTAINER kevin.brunner@zhdk.ch
RUN mkdir -p /opt/app && apt-get update && apt-get upgrade -y
VOLUME /tmp
RUN mkdir -p /target/dependency

COPY target/*.jar target
RUN (cd target/dependency; jar -xf ../*.jar)



FROM openjdk:11.0.4-jdk-slim-buster
ENV DEBUG_PORT=-1
ENV MAIN_CLASS_NAME=DUMMY

COPY entrypoint.sh ./entrypoint.sh

RUN apt-get update && apt-get install  dos2unix -y
RUN chmod +x entrypoint.sh && dos2unix entrypoint.sh

VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

CMD /bin/bash entrypoint.sh
