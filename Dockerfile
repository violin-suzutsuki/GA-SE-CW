FROM openjdk:latest
COPY ./target/SET08103-0.1.0.1-spring-boot.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET08103-0.1.0.1-spring-boot.jar"]