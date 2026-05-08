FROM maven:3.8.4-openjdk-11-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "target/student-app.jar"]