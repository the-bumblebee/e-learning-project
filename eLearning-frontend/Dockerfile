FROM tomcat:8-jre8-alpine
LABEL maintainer = "klmktu.asif@gmail.com"
ADD ./target/eLearning-frontend.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]