
# Customer Management API with JSON
## Overview
This project implements a Customer Management API capable of performing CRUD operations through HTTP requests. The API communicates with a database using JDBC and handles JSON data using GSON for serialization and deserialization.

## Prerequisites
Before running the application, ensure you have the following:

1) Java Development Kit (JDK) installed
2) PostgreSQL database installed and running
3) JDBC driver for PostgreSQL (included in the lib folder)
4) Make sure your project includes the necessary dependencies for Hibernate

## Dependecies
The project relies on the following dependencies: Jakarta EE Servlet API: Provides classes and interfaces for creating servlets to handle HTTP requests. Hibernate: Object-relational mapping framework for database interaction. Gson: Library for JSON serialization and deserialization.

## Classes
1) Customers: Entity class representing customer data with Hibernate annotations for database mapping.
2) CustomersService: Service class containing methods for creating, retrieving, and deleting customer data from the database.
3) HibernateConfig: Configuration class for Hibernate setup and session management.
4) ServletService: Servlet class handling HTTP requests for managing customer data.
5) InitializeDatabase - This class in order to add a value to the data base by default, run it first.

## Functionality
### 1. Creating Customers
The doPost() method in ServletService.java handles HTTP POST requests to create new customers. JSON data containing customer details (name, email, address) is parsed, and a new customer is added to the database using Hibernate. To add a new customer using Postman, you can follow these steps:
1) Open Postman and set the HTTP method to POST.
2) Enter the URL endpoint where your servlet is hosted, for example: http://localhost:8080/CustomerManagementApiWithJson-1.0-SNAPSHOT/time
3) Select the "Body" tab.
4) Choose the "raw" option.
5) From the dropdown next to "raw", select "JSON (application/json)".
6)  Paste the following JSON format into the text area:
```
 {
      "name": "Jane Smith",
      "email": "jane.smith@example.com",
      "address": "456 Oak Avenue"
 }
```
8) Click the "Send" button to execute the request․

This will send a POST request to your servlet endpoint with the provided JSON data, creating a new customer with the specified details in the database. Make sure your servlet is properly configured to handle POST requests and parse JSON data from the request body.

### 2. Retrieving Customers
The doGet() method in ServletService.java handles HTTP GET requests to retrieve all customers from the database. Customer data is fetched using Hibernate and converted to JSON format before being sent as a response.To view the total number of customers using Postman:
1) Open Postman and set the HTTP method to GET.
2) Enter the URL endpoint where your servlet is hosted, for example: http://localhost:8080/CustomerManagementApiWithJson-1.0-SNAPSHOT/time
3) Click the "Send" button to execute the request.
4) Postman will send a GET request to your servlet endpoint.
5) The servlet will retrieve all customers from the database and return their count.
6) Postman will display the response, showing the total number of customers stored in the database.

Ensure that your servlet is properly configured to handle GET requests and retrieve customer data from the database. Also, make sure your servlet returns the response in an appropriate format, such as JSON or plain text, indicating the count of customers.

### 3. Deleting Customers
The doDelete() method in ServletService.java handles HTTP DELETE requests to delete customers from the database. The customer ID is extracted from the request parameters, and the corresponding customer is deleted using Hibernate. To gracefully delete a customer with ID 1 through an HTTP DELETE request, follow these steps:
Send an HTTP DELETE request to the following URL:
http://localhost:8080/CustomerManagementApiWithJson-1.0-SNAPSHOT/time
This can be accomplished using various tools or libraries, such as curl in the command line or HTTP request libraries in your programming language (e.g., HttpClient for Java).

### 4. Below are the methods of the CustomersService class along with their explanations:
4.1 createCustomer(String name, String email, String address) `
```
This method is responsible for creating a new customer in the database. It takes three parameters: name, email, and address representing the details of the customer to be created.
Inside the method, a new Customers object is instantiated with the provided details, and the current date is set as the creation timestamp.
The method then persists the customer object into the database using Hibernate.
```
4.2 deleteCustomer(Long customerId) `
```
This method deletes a customer from the database based on the provided customerId. It takes a single parameter customerId, which specifies the ID of the customer to be deleted.
Within the method, it retrieves the customer object from the database using Hibernate, and if the customer exists, it removes it from the database.
This method ensures the transactional integrity of the operation by utilizing Hibernate transactions.
```
4.3 getAllCustomers() `
```
This method retrieves all customers stored in the database and returns them as a list of Customers objects.
It utilizes Hibernate to execute an HQL (Hibernate Query Language) query to fetch all customer records from the database.
The method then returns the list of customers fetched from the database.
```
These methods encapsulate the business logic for managing customer data within the application. They interact with the Hibernate framework to perform CRUD (Create, Read, Update, Delete) operations on the underlying database, providing a layer of abstraction for handling customer-related functionality.
