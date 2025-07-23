🎓 Student Management API – Secured by JWT:-

This project provides a secure RESTful API for managing student records using JWT token-based authentication and full CRUD operations. Logging is added to trace login, token actions, and student-related activities.

🚀 Features:-

✅ User login and JWT token generation
🔐 JWT token validation for protected endpoints
📚 Full CRUD operations on Student
🧾 Logger integrated with SLF4J
Global error handling

🧱 Tech Stack:-
Java 17
Spring Boot
Spring Security
JJWT (JWT Token)
Maven
H2 / MySQL
Logback (via SLF4J)

📁 Project Structure:-

src/
├── controller/
│   └── userController.java
│   └── StudentController.java
├── service/
│   ├── JwtService.java
│   ├──MyUserDetailsService.java
│   └── StudentService.java
     └── JwtAuthFilter.java
├── model/
│   ├── Student.java
│   └── User.java
├── repository/
│   ├── StudentRepository.java
│   └── UserRepository.java
├── security/
│   └── SecurityConfig.java
│   └── DemoJwtStudentCrudApplication.java

🔐 JWT Authentication Flow:-
Authenticate with username/password.
Receive JWT token.
Use token in Authorization header for all secured APIs.
Student CRUD APIs are protected.

🔑 Login Endpoint:-
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}

✅ Response:-
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}

🧪 Secured CRUD APIs (JWT Required):-

POST /api/students
Authorization: Bearer <your_token>
Content-Type: application/json
GET /api/students
Authorization: Bearer <your_token>
GET /api/students/1
Authorization: Bearer <your_token>
PUT /api/students/1
Authorization: Bearer <your_token>
Content-Type: application/json
DELETE /api/students/1
Authorization: Bearer <your_token>

🧾 Logger Example:-
Using LoggerFactory

📓 Sample Log Output:-
pgsql
Copy
Edit
INFO  - Login request received for user: admin
INFO  - JWT generated for user: admin
DEBUG - Valid token for user: admin
INFO  - Created student: Alice
INFO  - Fetched all students

🧰 Build & Run:-















