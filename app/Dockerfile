FROM gradle:7.4.0-jdk17

WORKDIR /app

COPY /app .

RUN gradle installDist

CMD ./build/classes/java/main/hexlet/code/App