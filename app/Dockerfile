FROM gradle:7.4.0-jdk17

WORKDIR /app

COPY . .

RUN ./gradlew clean build shadowJar --no-daemon

COPY build/libs/app.jar app.jar

CMD ["java", "-jar", "app.jar"]