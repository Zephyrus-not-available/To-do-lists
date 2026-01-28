# Zephyrus Task App

A modern, RESTful task management application built with Spring Boot. Manage your to-do lists with ease using a clean API and optional Docker-based UI.

![Zephyrus Task App](src/main/resources/static/project.png)

## Features

- ✅ **Create tasks** with title, description, due date, and priority levels
- 📋 **List all tasks** sorted by creation date
- ✏️ **Update tasks** - modify any task details or mark as complete
- 🗑️ **Delete tasks** when no longer needed
- 🎯 **Priority levels** - HIGH, MEDIUM, LOW
- 📊 **Task status tracking** - OPEN and COMPLETE states
- 🔒 **Input validation** - ensures data integrity
- 🐳 **Docker-ready UI** - optional frontend via Docker Compose

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.2**
- **Spring Data JPA** - Database persistence
- **H2 Database** - In-memory database for development
- **Lombok** - Reduces boilerplate code
- **Maven** - Build and dependency management

## Prerequisites

- Java 21 or higher
- Maven 3.6+ (or use the included Maven wrapper)
- Docker & Docker Compose (optional, for UI)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Zephyrus-not-available/To-do-lists.git
cd To-do-lists
```

### 2. Run the Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or with Maven installed:

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

### 3. (Optional) Run with UI

Start the Docker-based frontend:

```bash
docker compose up -d
```

Access the UI at `http://localhost:3000`

## API Reference

Base URL: `http://localhost:8080/api/v1/tasks`

### Create a Task

```bash
POST /api/v1/tasks
Content-Type: application/json

{
  "title": "Study Spring Boot",
  "description": "Complete the tutorial",
  "dueDate": "2026-02-15",
  "priority": "HIGH"
}
```

### List All Tasks

```bash
GET /api/v1/tasks
```

### Update a Task

```bash
PUT /api/v1/tasks/{taskId}
Content-Type: application/json

{
  "title": "Study Spring Boot",
  "description": "Tutorial completed!",
  "dueDate": "2026-02-15",
  "status": "COMPLETE",
  "priority": "HIGH"
}
```

### Delete a Task

```bash
DELETE /api/v1/tasks/{taskId}
```

## Task Model

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| `title` | String | Yes | Task title (1-255 characters) |
| `description` | String | No | Task description (max 1000 characters) |
| `dueDate` | LocalDate | No | Due date (must be today or future) |
| `priority` | Enum | Yes | `HIGH`, `MEDIUM`, or `LOW` |
| `status` | Enum | - | `OPEN` (default) or `COMPLETE` |

## Development

### Build the Project

```bash
./mvnw clean install
```

### Run Tests

```bash
./mvnw test
```

### Project Structure

```
src/
├── main/
│   ├── java/com/kyaw/task/
│   │   ├── controller/     # REST controllers
│   │   ├── domain/         # DTOs and entities
│   │   ├── exception/      # Custom exceptions
│   │   ├── mapper/         # Entity-DTO mappers
│   │   ├── repository/     # JPA repositories
│   │   └── service/        # Business logic
│   └── resources/
│       └── static/         # Static resources
└── test/                   # Unit tests
```

## Getting Help

- Check the [Issues](https://github.com/Zephyrus-not-available/To-do-lists/issues) page for known problems and solutions
- Open a new issue if you encounter bugs or have feature requests

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Maintainers

This project is maintained by [Zephyrus-not-available](https://github.com/Zephyrus-not-available).
