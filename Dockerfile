FROM openjdk:11

COPY build/libs/order-management.jar /app/order-management.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar","order-management.jar"]