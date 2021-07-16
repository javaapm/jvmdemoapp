# For Java 8, try this
#FROM openjdk:8-jdk-alpine

FROM adoptopenjdk:11-jre-hotspot as builder

# Refer to Maven build -> finalName
ARG JAR_FILE=target/egjvmdemo.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/egjvmdemo.jar /opt/app/egjvmdemo.jar
COPY ${JAR_FILE} egjvmdemo.jar

EXPOSE 8080

RUN java -Djarmode=layertools -jar egjvmdemo.jar extract

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /opt/app/dependencies/ ./
COPY --from=builder /opt/app/snapshot-dependencies/ ./
COPY --from=builder /opt/app/spring-boot-loader/ ./
COPY --from=builder /opt/app/application/ ./
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "org.springframework.boot.loader.JarLauncher"]

# java -jar /opt/app/app.jar
#ENTRYPOINT ["java","-jar","egjvmdemo.jar"]