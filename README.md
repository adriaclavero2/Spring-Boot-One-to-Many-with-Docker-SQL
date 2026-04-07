# Spring Boot REST API - One-to-Many Relationship

A professional REST API developed in Java with Spring Boot, designed to manage a One-to-Many relationship between Users and Events. The project uses a relational database connected via Docker and applies a layered software architecture.

## 🚀 Technologies Used

* **Language:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Validation)
* **Database:** MySQL
* **Containers:** Docker (to run the database in an isolated environment)
* **Extra Tools:** Lombok (to reduce boilerplate code)

## 🏗️ Project Architecture

The project is structured using the **N-Tier Architecture** (Layered Architecture) to separate responsibilities and apply development best practices:

1. **Models (Entities):** Representation of database tables (`User` and `Event`).
2. **Repositories:** Spring Data JPA interfaces for direct communication with SQL without writing manual queries.
3. **Services:** Business logic layer. It is responsible for processing information before saving or returning it.
4. **Controllers:** HTTP entry points (Endpoints) that handle client requests.
5. **Exceptions:** A global error handling system (`@ControllerAdvice`) to return clean JSON responses upon failure (e.g., 404 Not Found Error).


## 🌐 Available Endpoints (API Routes)

Requests return structured responses using `ResponseEntity` for proper handling of HTTP status codes (200 OK, 201 CREATED, 404 NOT FOUND).

### Users (`/api/users`)
* `GET /api/users` - Retrieves the list of all registered users.
* `GET /api/users/{id}` - Fetches and returns a specific user by their ID.
* `POST /api/users` - Creates a new user. (Requires validation for empty fields and email format).

### Events (`/api/events`)
* `GET /api/events` - Retrieves the list of all events.
* `GET /api/events/{id}` - Fetches and returns a specific event by its ID.
* `POST /api/events` - Creates a new event associated with a user.

## 🛠️ Best Practices Applied

* **Git Flow:** Structured development using individual branches (`feature/create-entitys`, `feature/create-repositories`, etc.) merged into the `master` branch.
* **Custom Exception Handling:** Use of `ResourceNotFoundException` to avoid generic 500 server errors.
* **Prevention of Infinite Loops:** Implementation of `@JsonIgnore` in the bidirectional relationship to ensure clean JSON serialization.
