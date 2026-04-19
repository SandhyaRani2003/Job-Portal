# Job Portal Backend (Spring Boot, JWT, MySQL)

Production-style REST API for a job portal system, built with layered architecture and secure authentication.

## Why this project
- Demonstrates backend engineering fundamentals expected in fresher Java roles.
- Uses clean separation of concerns: controller, service, repository, DTO, exception handler.
- Implements security, validation, standardized responses, and API documentation.

## Core features
- JWT-based authentication (`/auth/register`, `/auth/login`).
- BCrypt password hashing before persistence.
- Full Job CRUD APIs (`GET`, `POST`, `PUT`, `DELETE`).
- Request validation with `jakarta.validation`.
- Global exception handling with consistent error response format.
- Swagger/OpenAPI integration for API exploration.

## Architecture
`Controller -> Service -> Repository -> Database`

- `controller`: HTTP request/response orchestration only.
- `service`: business logic and use-case execution.
- `repository`: JPA data access.
- `dto`: request and response contracts.
- `exception`: centralized exception mapping via `@RestControllerAdvice`.
- `security`: JWT utility and Spring Security configuration.

## Tech stack
- Java 17+
- Spring Boot 3
- Spring Web, Spring Data JPA, Spring Security
- MySQL
- JWT (`jjwt`)
- Swagger/OpenAPI (`springdoc`)
- Maven

## Local setup
1. Create MySQL database: `jobportal`.
2. Update credentials in `src/main/resources/application.properties` if needed.
3. Start the application.

```powershell
Set-Location "C:\Users\sandh\Downloads\job-portal-full"
mvn spring-boot:run
```

4. Open Swagger UI:
`http://localhost:8080/swagger-ui/index.html`

## Configuration
File: `src/main/resources/application.properties`

- `spring.datasource.url=jdbc:mysql://localhost:3306/jobportal`
- `spring.datasource.username=root`
- `spring.datasource.password=root`
- `jwt.secret=...`
- `jwt.expiration-ms=3600000`

Note: for real deployments, move DB password and JWT secret to environment variables.

## API summary
- `POST /auth/register`
- `POST /auth/login`
- `GET /jobs`
- `GET /jobs/{id}`
- `POST /jobs`
- `PUT /jobs/{id}`
- `DELETE /jobs/{id}`

## Response contract
- Success: `{ "success": true, "message": "...", "data": ... }`
- Error: `{ "timestamp": "...", "status": 400, "error": "Bad Request", "message": "...", "path": "...", "validationErrors": { ... } }`

## Resume snapshot
- Built a layered Spring Boot backend with JWT auth, BCrypt password hashing, and MySQL persistence.
- Implemented DTO-based request/response contracts, validation, and centralized exception handling.
- Delivered fully documented REST APIs using Swagger and standardized API response envelopes.

For copy-paste resume bullets and project title variants, see `RESUME-ASSETS.md`.

