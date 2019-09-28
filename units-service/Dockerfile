FROM openjdk:11.0.4-jdk-slim-buster as build
MAINTAINER kevin.brunner@zhdk.ch
RUN mkdir -p /opt/app && apt-get update && apt-get upgrade -y
VOLUME /tmp


RUN mkdir -p /target/dependency

COPY target/*.jar target
RUN ls -l
RUN (cd target/dependency; jar -xf ../*.jar)


FROM openjdk:11.0.4-jdk-slim-buster


VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app


ENTRYPOINT ["java","-cp","app:app/lib/*","ch.nation.unitsservice.UnitsServiceApplication"]
