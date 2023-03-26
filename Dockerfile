FROM amazoncorretto:17
COPY build/libs/hotdeal-verse-0.0.1-SNAPSHOT.jar spring-base.jar
ENTRYPOINT ["java", "-jar", "/spring-base.jar"]