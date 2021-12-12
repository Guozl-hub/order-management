FROM openjdk:11

COPY build/libs/order-management-0.0.1-SNAPSHOT.jar /app/order-management.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar","order-management.jar"]