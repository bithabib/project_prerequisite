# TaskJDBC - User Management Application

## Overview

This project is a simple Java application that demonstrates the use of **JDBC** with **MySQL** to perform CRUD operations on a `User` entity. The architecture follows a **basic MVC pattern**, with DAO and Service layers. The project is built using **Maven** for dependency management and includes pre-written **JUnit tests** to verify functionality.  

---

## Technologies Used

- **Java 17**  
- **Maven**  
- **JDBC**  
- **MySQL** (Server and Workbench)  
- **JUnit 4**  
- (Optional) Hibernate libraries included but not used (`UserHibernateDaoImpl` remains empty)

---

## Project Structure

src/
└─ jm.task.core.jdbc
├─ Main.java # Application entry point
├─ model/
│ └─ User.java # User entity class
├─ dao/
│ ├─ UserDao.java # DAO interface
│ ├─ UserDaoJDBCImpl.java # JDBC implementation of DAO
│ └─ UserHibernateDaoImpl.java # Hibernate DAO (not implemented)
├─ service/
│ ├─ UserService.java # Service interface
│ └─ UserServiceImpl.java # Service implementation
└─ util/
└─ Util.java # Database connection utility



---

## Features / Operations

The application supports the following operations:

1. **Create Users table** - safely creates the table if it does not exist.  
2. **Drop Users table** - safely drops the table if it exists.  
3. **Add a User** - insert a user with `name`, `lastName`, and `age`.  
4. **Remove a User by ID** - delete a user from the table by its `id`.  
5. **Get all Users** - fetch all users from the database.  
6. **Clear Users table** - delete all records without dropping the table.  

---

## Application Algorithm (Main Class)

1. Create the `Users` table.  
2. Add 4 sample users to the table, printing a confirmation after each insertion:  
User with name – John added to the database

3. Fetch all users from the database and print them using `toString()` method.  
4. Clear all records from the `Users` table.  
5. Drop the `Users` table.  

---

## Setup Instructions

1. **Install IntelliJ IDEA Ultimate** (required for this course).  
2. **Install MySQL Server and Workbench** on your machine.  
3. Create a **database/schema** using MySQL Workbench.  
4. Update the `Util.java` class with your database credentials:  

```java
private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";


Clone or download the project.

Open the project in IntelliJ IDEA.

Build the project using Maven to download dependencies.

Run JUnit tests in the test folder to verify functionality.

Run Main.java to execute the application algorithm.

Running Tests

To run pre-written tests:

Open the test folder in IntelliJ IDEA.

Right-click the test class.

Select Run "Class Name".

All tests should pass if DAO and Service layers are correctly implemented.

Notes

The UserHibernateDaoImpl class is included for future Hibernate-based implementation but remains empty for this task.

All database exceptions are handled in the DAO layer.

The project demonstrates clean separation of concerns between DAO and Service layers.

GitHub Submission

Once completed, push the project to your GitHub repository and submit the repository link for evaluation.

Author

Your Name

Email: habib@gnu.ac.kr
GitHub: https://github.com/bithabib/


---

If you want, I can also make a **shorter, visually appealing version** with badges (Java, Maven, MySQL) suitable for GitHub that looks professional for a portfolio.  

Do you want me to do that?


