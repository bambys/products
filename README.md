# products

Products is the REST API written in Java using Spring Boot 2 and Hibernate that provides endpoints for 3rd party

## Installation

Standard Maven project, it connects to MySQL database defined in Resources directory. 
The API is secured by Basic Auth - see src\main\java\com\petrbambas\rest\products\config\SecurityConfig.java

## Usage

Via endpoints (see src\main\java\com\petrbambas\rest\products\controller) provides information about products, warehouses 
and goods on the stock - availability of products in warehouses - GET requests (for example http://localhost:8080/api/products). 
Products can be added, modified or even deleted by POST, PUT and DELETE requests too.

## Note

Spring Data JPA is not used because the author wanted to demonstrate using Hibernate. 
Although using Spring Data Rest could make easier to expose HTML resources, the author preferred
to show his ability to write source code for controllers. 