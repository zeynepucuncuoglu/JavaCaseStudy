# Flight Management System with Spring Boot and PostgreSQL

## Project Details

This Flight Management System is built using Java with the Spring Boot framework and utilizes PostgreSQL as the database. Below are the key features and tools used in this project:

## Features

### Data Modeling
- **Flights Entity:**
  - ID
  - Departure Airport
  - Arrival Airport
  - Departure Date/Time
  - Return Date/Time
  - Price

- **Airport Entity:**
  - ID
  - City

### CRUD Operations
- Endpoints for creating, reading, updating, and deleting flights and airports.

### Search API
- Endpoint for searching flights based on departure place, destination, departure date, and return date.

### External Service Integration
- RESTful endpoint for external services to interact with the application.

### Authentication
- Authentication structure for securing the application.

### Scheduled Background Jobs
- Daily scheduled job to fetch flight information from a mock third-party API and save it to the database.

### Git Version Control
- The project is version-controlled using Git.

### Documentation with Swagger
- API documentation generated using Swagger.
- Access Swagger UI at `http://localhost:8080/swagger-ui.html` after starting the application.

## Tools Used
- **Java:**
  - Developed using Java programming language.

- **Spring Boot:**
  - Utilized the Spring Boot framework for rapid application development.

- **PostgreSQL:**
  - Chose PostgreSQL as the relational database for data storage.

- **Git:**
  - Version control system for tracking changes.

- **Swagger:**
  - Used Swagger for API documentation.


