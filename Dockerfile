
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8082 available to the world outside this container
EXPOSE 8082

# The application's jar file
ARG JAR_FILE=target/Product-Angular-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]

