# Description
* This is project is based on Java backend programming language and Spring boot. 

* In this project vehicle ads can be uploaded and found. After registering users can upload different car ads and they can also find variety of cars by mentioning different parametrs on the search section. 

* They are also able to delete and change the ads they shared. Users who have not registered can also search for different types of vehicles through the search section.

# Technology Stack

|Technology                |Description         |
|--------------------------|--------------------|
|Core Framework            |Spring Boot         |
|Security Framework        |Spring Security, JWT|
|Persistent Layer Framework|Spring Data JPA     |
|Database                  |PostgreSQL          |

# Packages

* 	`authentication` - application user authentication;
* 	`configuration` - app configurations;
* 	`controllers` - to listen to the client;
* 	`dao` - data access object;
* 	`dto` - in the field of programming a data transfer object (DTO) is an object that carries data between processes;
* 	`enum` - maintaining classes;
* 	`exception` - to hold custom exception handling;
* 	`models` - to hold our entities;
* 	`repository` - to communicate with the database;
* 	`service` - to hold business logic;
* 	`util` - to hold our utility classes;

* 	`resources/` - Contains all the static resources, templates and property files.
* 	`resources/static` - contains static resources such as css, js and images.
* 	`resources/templates` - contains server-side templates which are rendered by Spring.
* 	`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

* 	`test/` - contains unit and integration tests

* 	`pom.xml` - contains all the project dependencies

# Some Details
* Except **_"/token"_** (The generateToken method in the JwtController class), **_"/user/register"_** (The registerUser method in the UserController class), **_"/announce/getSearch"_** (The getSearch method in the AnnouncementController class) http requests, to use all other http requests token is required.

* When the announcement is searched, the VIP announcements are first seen by the user, and then the non-VIP announcements are seen by the user.

* There are different types of bidirectional relationship between models.
