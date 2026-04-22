# Job Portal Backend

This is a Spring Boot backend for a simple job portal system. I built it to practice the usual pieces of a backend project: REST APIs, validation, database access, authentication, and clean error handling.

## What this project does
- Lets a user register and log in.
- Stores passwords using BCrypt instead of plain text.
- Exposes CRUD APIs for jobs.
- Returns responses in a consistent format.
- Handles common errors in one place.
- Includes Swagger UI so the APIs are easy to test.

## Project structure

The code follows a basic layered setup:

- `controller` handles incoming HTTP requests.
- `service` contains the main business logic.
- `repository` talks to the database using Spring Data JPA.
- `dto` keeps request and response objects separate from entities.
- `exception` contains custom exceptions and the global exception handler.
- `security` contains the JWT helper and Spring Security configuration.
- `model` contains the JPA entities.
- `mapper` converts between entities and DTOs.

## Tech stack

- Java 17
- Spring Boot 3.2
- Spring Web
- Spring Data JPA
- Spring Security
- Validation (`jakarta.validation`)
- MySQL
- JWT (`jjwt`)
- Swagger/OpenAPI (`springdoc`)
- Maven

## Main features

- `POST /auth/register` for new user registration.
- `POST /auth/login` for login and JWT token generation.
- `GET /jobs` to list all jobs.
- `GET /jobs/{id}` to get a single job by id.
- `POST /jobs` to create a job.
- `PUT /jobs/{id}` to update a job.
- `DELETE /jobs/{id}` to delete a job.

## Configuration

The important settings are in `src/main/resources/application.properties`.

## How to run the project

1. Create a MySQL database named `jobportal`.
2. Update `application.properties` if your local MySQL username or password is different.
3. Run the application from the project root.

```powershell
Set-Location "C:\Springboot Projects\job-portal"
mvn spring-boot:run
```

4. Open Swagger UI in the browser:
http://localhost:8080/swagger-ui/index.html


## Response format

Success responses follow a simple wrapper:

```json
{
  "success": true,
  "message": "...",
  "data": {}
}
```

Author - Sandhya Rani

