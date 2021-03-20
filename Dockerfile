FROM adoptopenjdk/openjdk15:ubi
VOLUME /tmp
ADD target/springBootApp.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


