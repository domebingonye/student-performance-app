📘 Student Performance App

A Spring Boot application for managing student details and academic performance, built as part of an assessment.
The project also includes solutions to algorithmic and SQL questions organized in a clean folder structure.
🚀 Features

🎓 Student Management
    1.Create a new student
    2.Update student details

📝 Score Management
    1. Add scores for 5 subjects
    2. Update student scores
    3. View student scores per subject

📊 Analytics
    1.  Mean score per student
    2.  Median score per student
    3.  Mode score per student

🧩 Algorithms & SQL Solutions
    1.  Algorithm tasks implemented in the service package
    2.  SQL solutions stored in /resource/db

🏛 Architecture
    1.  Service layer with repository pattern
    2.  Utility class for code generation
    3.  Domain-driven package structure

🛠 Tech Stack
    1.  Java 21
    2.  Spring Boot 3.4.11
    3.  Spring Data JPA
    4.  PostgreSQL (configurable)
    5.  Maven
    6.  OpenAPI/Swagger (via springdoc)

📂 Project Structure

    src/main/java/com/student-performance-app
┣ 📂 config                # Application configuration
┣ 📂 controller            # REST controllers
┣ 📂 dto                   # Data transfer objects
┣ 📂 enums                 # Enumerations
┣ 📂 exception             # Custom exceptions
┣ 📂 interfaces            # Interfaces
┣ 📂 model                 # Domain models & Entities
┣ 📂 repository            # Spring Data JPA Repositories
┣ 📂 service               # Business logic & Algorithm solutions
┣ 📂 util                  # Utility classes (e.g., CodeGeneratorUtils)
┗ StudentPerformanceAppApplication.java

src/main/resources/db        # SQL Scripts for database questions
┣ app_usage.sql
┣ get_country_game_played.sql
┣ get_left_right_join.sql
┗ get_second_largest_salary.sql

src/test/java/studentperformanceapp
┣ RemoveDuplicateTests
┣ StudentDetailDaoServiceTests
┣ StudentPerformanceAppApplicationTests
┣ StudentScoreDaoServiceTests
┣ StudentScoreServiceTests
┗ TimeConversionInWordsTests

🌐 API Endpoints (Sample)
Student Endpoints
Method	Endpoint	Description
POST	/api/v1/student	Create student details
PUT	/api/v1/student/details/{id}	Update student details

Score Endpoints
Method	Endpoint	Description
POST	/api/v1/student/score/{id}	Create student score
GET	/api/v1/student/score/search	View each student’s subject scores
GET	/api/v1/student/score/mean	Calculate mean score
GET	/api/v1/student/score/mode	Calculate mode score
GET	/api/v1/student/score/median	Calculate median score

Access the Swagger API Docs
http://localhost:2020/student-performance-app/swagger-ui/index.html#

📦 Core Dependencies
    1.  spring-boot-starter-web
    2.  spring-boot-starter-data-jpa
    3.  springdoc-openapi-starter-webmvc-ui
    4.  postgresql
    5.  lombok
    6.  modelmapper

🧪 Testing
    1.  Unit tests for business logic
    2.  DAO service tests
    3.  Algorithm tests
    4.  Application context tests

📁 Assessment Notes
    1.  All programming & algorithm answers are implemented inside the service package.
    2.  Database & SQL answers are provided in separate .sql files under resource/db.
    3.  All project requirements from the test have been completed.

✅ Conclusion
This project provides a full implementation of student management, score analytics, algorithms, SQL challenges, and follows clean coding practices with proper packaging and REST standards.