# CZ2006-Backend
To develop an online appointment making system for vet clinics which consists of end user mobile applications and an admin portal for clinics.
This is the repository for backend providing APIs 

## Code structure
- controller - provide apis
- dao - provide functions to interact with db (CRUD)
- pojo - entity classes
- service - function logic

## 
- scripts - sql scripts for table creation and data intialization
- application.properties - project config
- pom.xml - maven package config


## Tech Stack
### Language
- Java 

### Frameworks
- SpringBoot 
#### Database access
Jpa (Java Persistence API)

### Others
- Apache-tomcat-9
- Docker
- Mysql 
- Intellij IDEA 2020.3
- Maven - package management tool
- Swagger - api documentation
     http://localhost:8080/swagger-ui.html#/

## Installation
- Please go follow link to download Intellij [IDEA 2020.3](https://www.jetbrains.com/idea/download/other.html)
    - This version of IntelliJ has already contain Tomcat, Spring, Maven plugins
- Please download [Java JDK 15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) and install it

## How to start a Java SpringBoot project in IntelliJ?
Please follow this [tutorial](https://www.jetbrains.com/help/idea/your-first-spring-application.html#what-next)

## How to setup mysql?
https://docs.google.com/document/d/1I5FBhkh0cMp_Y8Kzfcjd3w0s0cVusiLwKWlvDnPdQ-Q/edit?usp=sharing

## How to use JPA?
https://www.cnblogs.com/ityouknow/p/5891443.html

## Add email lib

On intellij go to File -> Project Structure -> Modules -> Dependencies
Press the "+" button below select import JAR and select the jar file under externallib

## Use your own gmail account to send email

1. Go to foler src/main/resources/application.properties file and modify spring.mail.username and spring.mail.password
	- For username please exclude the @gmail.com

2. Unblock unsecure app to send email through gmail
	Follow this link to unblock: https://devanswers.co/allow-less-secure-apps-access-gmail-account/

## Instruction of Docker deployment

1. open the comment for docker in application.properties
2. run mvn package
3. run following command to create mysql container
'''docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:8'''
4. login db and create tables
5. run following command to build application image
'''docker build -t springbootapp .'''
6. run foolowing command to run application container and link to the db container 
'''docker run -d -p 8089:8089 --name springbootapp --link mysqldb:mysql springbootapp'''

reference:https://medium.com/thecodefountain/develop-a-spring-boot-and-mysql-application-and-run-in-docker-end-to-end-15b7cdf3a2ba

## Team Members
- Weng Yifei  (U1920094F)
- Liang Xuchao  (U1920092B)
- Ma Xin  (U1920122B)
- Lin Yan  (U1920925F)
- Zhan Yijia  (U1920682H)
- Xu Zhiyong  (U1920735K)
