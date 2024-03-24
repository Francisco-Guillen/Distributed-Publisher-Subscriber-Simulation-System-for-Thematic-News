# Distributed Publisher Subscriber Simulation System for Thematic News

## Description

This project consists of simulating a system made up of a Publisher process, i.e. the users who add the news, with the desired topic, and a Subscriber process, i.e. users who subscribe to a topic, thus receiving a callback when news on that topic is added. Throughout the programme, the client processes interact with the server in different ways, as each one presents specific instructions depending on the objective it wants to achieve.
It stores topics, news and registered users in a database and has a web interface that accesses RESTful web services, developed with the Spring framework.

Registered news producers should be able to:
1. Add a topic;
2. Consult existing topics;
3. Insert a news item from a given topic;
4. Consult all published news items.

News consumers should be able to:
1. Subscribe to a topic;
2. Consult news on a given topic between a given date range; 3.
of dates;
3. Consult the latest news on a given topic.

## Configuration Manual

### MYSQL

Since this project uses databases to store the entities created, it is necessary for the user to install the drivers for the MySQL software, thus enabling communication between the application and the database management system.
In the templates directory of the developed project there is an application.properties file with the following settings:

```Java
spring.jpa.hibernate.ddl−auto=update
spring.datasource.url=jdbc:mysql://$ {MYSQL_HOST: localhost } :3306/db_tp2
spring.datasource.username=springuserTP2
spring.datasource.password=ThePassword
spring.datasource.driver−class−name = com.mysql.cj.jdbc.Driver
```

This file defines the database to be used throughout the project, the user who has permissions to it and the MySQL software driver.

### Package Spring Tools

As this application must have an interface that accesses RESTful web services developed with the Spring framework, it is necessary to install the Spring Tools package.

<p align="center">
<img src="https://github.com/Francisco-Guillen/Distributed-Publisher-Subscriber-Simulation-System-for-Thematic-News/assets/83434031/5c7e1e6c-87da-4e01-bbe0-f7ab9aece86d">
<br>
  Figure 1: Dependencies
</p>

In addition, the user must select the following dependencies when creating the project, as shown in the following figure:

<p align="center">
<img src="https://github.com/Francisco-Guillen/Distributed-Publisher-Subscriber-Simulation-System-for-Thematic-News/assets/83434031/e051abba-32f7-4090-b95b-6fcf16e0dba7">
<br>
  Figure 2: Other Dependencies
</p>
