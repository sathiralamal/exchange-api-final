FROM openjdk:11

RUN mkdir -p /home/exchange-api

COPY ./target/*.jar /home/exchange-api/app.jar

# set default directory
WORKDIR /home/exchange-api

# executing service jar file
CMD ["java", "-jar", "app.jar"]
