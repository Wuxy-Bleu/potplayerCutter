#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM centos:7
MAINTAINER  "wuxy@111.com"
ENV http_proxy "http://172.10.1.196:7890"
ENV https_proxy "http://172.10.1.196:7890"
#RUN ping 172.10.1.196
RUN yum -y update \
    && yum install java-11-openjdk-devel -y \
    && curl -L https://yt-dl.org/downloads/latest/youtube-dl -o /usr/local/bin/youtube-dl \
    && chmod a+rx /usr/local/bin/youtube-dl \
    && mkdir /download
#    && rpm --import http://li.nux.ro/download/nux/RPM-GPG-KEY-nux.ro \
#    && rpm -Uvh http://li.nux.ro/download/nux/dextop/el7/x86_64/nux-dextop-release-0-5.el7.nux.noarch.rpm \
#    && yum -y install ffmpeg ffmpeg-devel
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
