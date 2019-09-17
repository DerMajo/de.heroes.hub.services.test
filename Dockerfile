FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/test-service-impl-gitpod-spring-boot.jar app.jar