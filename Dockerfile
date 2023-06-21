FROM openjdk:11
Volume /tmp
ADD /target/*.jar e_service_question_paper-0.0.1-SNAPSHOT.jar
EXPOSE 1207
ENTRYPOINT ["java", "-Xmx1024m","-jar", "/e_service_question_paper-0.0.1-SNAPSHOT.jar"]
