FROM openjdk:11
VOLUME /tmp
RUN mkdir -p /app/
ADD target/*.jar /app/shift-schedule.jar
ENTRYPOINT ["java","-jar", "/app/shift-schedule.jar"]
EXPOSE 8080
