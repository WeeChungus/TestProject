FROM eclipse-temurin:11

COPY target/MyClusterApp-0.1.jar node.jar
EXPOSE 8080

CMD ["java", "-jar", "node.jar"]