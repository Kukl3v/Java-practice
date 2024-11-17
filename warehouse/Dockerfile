FROM openjdk:17-jdk-slim-buster
ADD build/libs/warehouse-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "-Dspring.profiles.active=dev", "/app/warehouse-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080