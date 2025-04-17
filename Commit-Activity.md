### ✅ **Commit 1: Initial project structure with required dependencies**

**What:** Set up the initial Spring Boot project with the foundational folder structure and necessary Maven dependencies.

**Why:** Establishing a clean and modular base at the beginning helps keep the project scalable, maintainable, and easy to understand for future development.

**How:**  
- Created a Maven-based Spring Boot project using Java 17.  
- Structured the code into logical packages: `controller`, `service`, `model`, `dto`, `repository`, and `config`.  
- Added essential dependencies in `pom.xml` including:  
  - `spring-boot-starter-web` for REST APIs  
  - `spring-boot-starter-data-jpa` for ORM  
  - `spring-boot-starter-security` for authentication/authorization  
  - `jjwt` for JWT handling  
  - `lombok` for reducing boilerplate  
  - `h2` for in-memory database during development/testing

---
### ✅ **Commit 2: Created User module with the necessary packaging structure**

**What:** Added the complete `User` module including entity, enum, DTOs, repository, service interface, and implementation.

**Why:** User management is a core feature of the application, and establishing its module with clean layering and separation of concerns ensures maintainability and testability.

**How:**  
- Created the `User` entity with fields like `id`, `name`, `email`, `password`, `role`, `avatarUrl`, and timestamps.  
- Defined `Role` enum to support role-based access control (`CUSTOMER`, `SERVICE_PROVIDER`, `ADMIN`).  
- Added DTOs: `UserDto` for clean data transfer.  
- Defined `UserRepository` extending `JpaRepository` for CRUD operations and custom queries.  
- Created `UserService` interface with methods like `registerUser`.  
- Implemented `UserServiceImpl` with core business logic and DTO conversions using builder pattern.

---
### ✅ **Commit 3: ObjectMapper implemented for DTO ↔ Entity, disabled Spring Security temporarily, and added base URL context**

**What:**  
- Integrated `ObjectMapper` to simplify conversions between DTOs and Entities.  
- Temporarily disabled Spring Security to focus on feature development without authentication barriers.  
- Configured application to use a common URL base path.

**Why:**  
- Mapping between DTOs and Entities manually was verbose and error-prone; using `ObjectMapper` increases code maintainability.  
- Disabling security helps speed up backend development and testing in early stages.  
- URL context makes API endpoints cleaner and organized under a consistent namespace.

**How:**  
- Injected `ObjectMapper` and replaced manual mapping with `mapper.convertValue(...)`.  
- Updated `application.properties` with `spring.mvc.servlet.path=/api/v1` to prefix all endpoints.  
- Commented out or bypassed Spring Security config for smoother workflow during initial setup.

---
### ✅ **Commit 4: `registerUser` functionality implemented**

**What:** Developed the user registration feature as part of the User module.

**Why:** User onboarding is a critical feature that allows new users to sign up and start using the platform. This forms the entry point into the system.

**How:**  
- Implemented the `registerUser()` method in `UserServiceImpl` to handle incoming user registration requests.  
- Validated uniqueness of email using `UserRepository.existsByEmail(...)`.  
- Used `PasswordEncoder` to hash the password before persisting.  
- Converted `UserDto` to `User` entity using `ObjectMapper` and saved via `UserRepository`.  
- Returned the saved user details as a `UserDto` after masking sensitive data like password.

---
### ✅ **Commit 4.1: Implemented User Repository and Service Interface**

**What:** Defined `UserRepository` and `UserService` interface.  
**Why:** To define core user-related operations and decouple business logic from persistence logic.  
**How:** Extended `JpaRepository` for basic CRUD and custom methods like `findByEmail()`. `UserService` outlines methods like register, login, update, etc.

---
### ✅ **Commit 4.2: Developed UserServiceImpl with Basic Operations**

**What:** Implemented core methods like user registration.  
**Why:** To handle actual user operations and provide a functional backend for controller endpoints.  
**How:** Handled password encryption using `PasswordEncoder`, token generation using a utility class, and basic validation logic.

---
### ✅ **Commit 4.3: Scaffolded UserController Endpoints**

**What:** Defined REST API endpoints for user operations in `UserController`.  
**Why:** To expose APIs for user registration.  
**How:** Annotated endpoints with Spring MVC annotations and mapped service layer methods to them.

---