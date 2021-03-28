FROM adoptopenjdk/openjdk15:ubi
VOLUME /tmp
ADD target/springBootApp.jar springBootApp.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "springBootApp.jar"]
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]


