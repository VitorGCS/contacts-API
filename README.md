# contacts-API
API to manage the contacts of customers for marketing campaigns

With this project I ilustrate two points:
- Simple use case for the "Null Object Pattern", practical case for "Customer" type;  
- Clean code that is generated when using TDD approach, practical case in method formatFullName

This project ilustrate one simple API to manage the customers information (Full name and e-mail) has available two endpoints:
- /api/addCustomer 
- /api/getCustomer/{customerId}

This is a demo application with the goal of explore the "Null Object Pattern" and TDD.
In order to simplify this implementation this two endPoints are open, no code has been implemented regarding security. It wasn't generated any code regarding testing the service, endpoints, and repositories.
It wasn't considered logs in this demo.

Tecnologic stack:
This project was made in Spring boot and has enabled two endpoints from actuator:
- /api/actuator/health 
- /api/actuator/info

This application has available two spring profiles: "dev" and "prod" ("dev" by default)
To run this application locally just run:
- mvn clean package
- mvn spring-boot:run

By default it will be running on port 8080 

To persistence the data was used mysql database, you can setup the database locally with the following docker command (oficial mysql image):
docker run -p 3306:3306 -e MYSQL_DATABASE=contacts -e MYSQL_USER=db_user -e MYSQL_PASSWORD=secret -e MYSQL_ROOT_PASSWORD=secret mysql

The schema is available in resources/db_schema/db_schema.sql;

Note: It wasn't addressed considerations about creating docker volumes for data persistence when container is stopped, if you want to use this approache, please read the official documentation to create the container with all the configurations; 

This project has also a Dockerfile, that you can use to create a docker image for this application, be aware of the profile used.




