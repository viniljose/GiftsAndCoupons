# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* 
### Health Check
  http://localhost:8080/actuator/health
  http://localhost:8080/api/health

### Endpoints
curl -X POST "http://localhost:8080/api/promotions/init?date=2024-07-27"
curl -X POST "http://localhost:8080/api/promotions/allocate-gifts?date=2024-07-27"
http://localhost:8080/api/promotions/available?date=2024-07-27
http://localhost:8080/api/promotions/allocated?date=2024-07-27