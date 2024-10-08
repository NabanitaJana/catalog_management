# Catalog Management System

## Objective

Design and implement a Catalog Management System using Spring Boot that allows users to store and manage product data. The system includes features for managing products with various attributes and supports CRUD operations through a RESTful API.

## Features

- **Product Management**: Stored and managed product data including brand name, description, price, quantity, category, and more.
- **CRUD Operations**: Performed Create, Read, Update, and Delete operations on products via RESTful API endpoints.
- **Search and Filtering**: Search and filter products based on criteria such as name, brand, category, price range, and quantity range.
- **Data Validation**: Ensured input data integrity using validation annotations and handle validation errors gracefully.
- **Data Persistence**: Utilized a relational database (MySQL) for data storage and retrieval.
- **Logging and Auditing**: Implemented logging and auditing to track changes made to product data.
## Project Structure

- **Controller**: Managed HTTP requests and responses.
  - `ProductController`: Handles CRUD operations.

- **Model**: Represent the data structure.
  - `Product`: Entity representing a product with attributes like id, name, brand, description, price, quantity, category, and date added.

- **Repositorie**: Interface with the database.
  - `ProductRepository`: Provides CRUD operations and custom queries.

- **Service**: Contain business logic.
  - `ProductService`: Handles the business logic for managing products.

- **Configuration**: Setup for database and application properties.
  - `application.properties`: Configures database and other settings.

- **Tests**: 
  - `ProductServiceTests`: Tests for service layer logic.
 
# Springboot version- 3.3.2
# Dependencies used- spring web,Data JPA,MYSQL connector,Actuator,validation.

# API endpoints:
## Get All Products: http://localhost:8080/api/products
## Create Product : http://localhost:8080/api/products
## Update Product : http://localhost:8080/api/products/1
##  Delete Product : http://localhost:8080/api/products/1
## search product : http://localhost:8080/api/products/search
