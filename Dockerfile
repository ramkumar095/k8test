FROM openjdk:17.0.2-jdk
 
WORKDIR /app
 
COPY target/indiaproj-1.0.jar /app/MainClass.jar
 
ENTRYPOINT ["java","-jar","/app/MainClass.jar"]