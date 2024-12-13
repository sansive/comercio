# comercio
> This Spring Boot project, developed as part of a technical test, involves creating a REST service with an endpoint 
> that accepts application date, product identifier, and brand identifier as input parameters.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Contact](#contact)


## General Information
This project is a Spring Boot-based application developed as part of a technical test. The goal is to provide a RESTful 
service that allows querying product pricing data based on parameters like application date, product identifier, and 
brand identifier. By using an in-memory H2 database, the application aims to return relevant pricing details.

The problem it solves is enabling dynamic price retrieval based on various input conditions in a structured and efficient
manner. The purpose of this project is to demonstrate the ability to design and implement a simple yet effective service
that interacts with a database, processes input data, and returns a response to clients. I undertook this project to 
showcase proficiency in Spring Boot, REST APIs, database integration, and unit testing within the context of a technical
evaluation.


## Technologies Used
- Spring Boot - version 3.4.0
- Java - version 17
- Spring Data JPA - version 2.7.5
- H2 Database - version 2.1.214
- JUnit - version 5.7.2
- Lombok - version 1.18.36


## Features
- Exposes an endpoint that accepts application date, product identifier and brand identifier to return pricing details.
- Uses H2 as an in-memory database to store and query pricing data efficiently.
- Returns product identifier, brand identifier, rate, application dates, and the final price based on input parameters.
- Includes automated tests, including both unit tests and integration tests, to validate the functionality of the query 
endpoint with sample data.


## Setup
1. **Clone the Repository**: First, clone the repository to your local machine using Git:
    ```bash
    git clone https://github.com/your-repository-url.git
    ```
   
2. **Install Java 17**: Ensure you have Java 17 installed on your machine. You can download it from
[Oracle's official website](URL "https://www.oracle.com/java/technologies/downloads/#java17?er=221886") or use a package manager like Homebrew (for macOS) or apt (for Linux).

3. **Set Up Maven**: This project uses Maven to manage dependencies. If Maven is not already installed, you can download 
and install it from the [official Maven website](URL "https://maven.apache.org/download.cgi").  
Alternatively, if you use an IDE like IntelliJ IDEA or Eclipse, Maven is usually built-in, so you can proceed without 
manually installing it.

4. **Build the Project**: Navigate to the project directory and run the following command to build the project:
    ```bash
    mvn clean install
    ```
    This will download all dependencies and compile the application.

5. **Run the Application**: To start the application, use the following command:
    ```bash
    mvn spring-boot:run
    ```
    The Spring Boot application will start running on the default port (8080). You can access the API by visiting
http://localhost:8080.

## Usage
To use the application, you can make a GET request to the exposed endpoint with the required query parameters:

**Example Request**:
```cURL
curl --location 'http://localhost:8080/api/priceEntities?applicationDate=2020-06-14T10%3A00%3A00&productId=35455&brandId=1'
```
This request will return the pricing details for the specified product and brand on the given application date.

**Example Response**:
```json
{
   "productId": 123,
   "brandId": 456,
   "rate": 99.99,
   "applicationDates": ["2024-12-01", "2024-12-31"],
   "finalPrice": 120.00
}
```
### Use Case 1: Get Pricing Details
To get the pricing details, send the applicationDate, productId, and brandId as query parameters. The application will calculate the appropriate price and return it.  

**Example**:
```http
curl --location 'http://localhost:8080/api/priceEntities?applicationDate=2020-06-14T10%3A00%3A00&productId=35455&brandId=1'
```

### Use Case 2: Error Handling
If any required parameter is missing or invalid, the application will respond with a proper error message.  

**Example (missing applicationDate)**:
```http
curl --location 'http://localhost:8080/api/prices?applicationDate=2024-06-14T10%3A00%3A00&productId=35455&brandId=1'
```
**Response**:
```json
{
   "timestamp": "2024-12-13T18:58:57.943+00:00",
   "status": 400,
   "error": "Bad Request",
   "path": "/api/prices"
}
```


## Project Status
The project is **complete**. While it lacks additional features like Swagger and other enhancements, I have successfully 
implemented all the tasks requested as part of the technical test.

## Contact
Created by [@sansive](https://github.com/sansive) - feel free to contact me!