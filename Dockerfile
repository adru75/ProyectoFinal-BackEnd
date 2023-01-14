FROM amazoncorretto:17 
MAINTAINER ADRU75 
COPY target/adrian-0.0.1-SNAPSHOT.jar proyecto-final-app.jar 
ENTRYPOINT ["java","-jar","/proyecto-final-app.jar"]