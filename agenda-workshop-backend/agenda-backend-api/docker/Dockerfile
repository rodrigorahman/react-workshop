FROM openjdk:8u141-jdk-slim

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install curl -y && \
    apt-get clean
    
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /opt/agenda-backend-api

COPY ./target/agenda-backend-api*.jar agenda-backend-api.jar

SHELL ["/bin/bash","-c"]

EXPOSE 8080

EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar agenda-backend-api.jar
