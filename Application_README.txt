There are 4 API's exposed to perform the CRUD operations

1)Get API is implemented to perform the Read operation.It takes a productID as the URL parameter and returns the Product details as Response
2)Post API is implemented to perform the Create operation. It takes the Product details in Jason format and returns the persisted Product with ProductID an
3)Put API is implemented to perform Update operations. It takes the product ID as the URL parameter and the updated product details in the request body in Jason format and returns the persisted Product with ProductID an
4)Delete API is implemented to perform Delete operation. It takes the product ID as the URL paramter and returns status SUCCESS/FAILURE


Handling of concurrency:
1)The current application is implemented with the help of Spring Boot. It runs on Tomcat server 8080 port and connects to postgreSQL database to store Product details. Multithreading is achieved by using the thread pool of Tomcat server.
2)Since the database used is the relational Database PostgreSQL, ACID properties are ensured for all transactions.

Appliation Structure:
1)Curl request is mapped to the appropriate API in the Controller
2) Controller services this request using ProductService
3) ProductService uses JPARepository functons to store in PostgreSQL Database.