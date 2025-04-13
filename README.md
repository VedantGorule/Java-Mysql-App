# Java MySQL App

This is a simple Java project that connects to a MySQL database, allows for adding, updating, deleting, and reading student information, and demonstrates how to interact with a database using JDBC.

## Features

- Connects to MySQL database using JDBC.
- Create and populate a `students` table with fields `roll_no`, `name`, and `age`.
- Provides CRUD operations:
  - **Create**: Add new student records.
  - **Read**: View all student records.
  - **Update**: Modify student information.
  - **Delete**: Remove student records.

## Prerequisites

Make sure you have the following installed:

- [Java 8 or above](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [MySQL JDBC Driver](https://dev.mysql.com/downloads/connector/j/)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/VedantGorule/Java-Mysql-App.git


Install MySQL and create a new database
CREATE DATABASE javapp;


Create a students table in your database using this SQL:
CREATE TABLE students (
  roll_no INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  age INT
);


Configure the database connection in the MySQLConnect.java file:
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/javapp", "username", "password");


Add the MySQL JDBC connector to the project classpath.



Compile and run the project:
javac -cp ".;mysql-connector-j-8.0.33.jar" MySQLConnect.java
java -cp ".;mysql-connector-j-8.0.33.jar" MySQLConnect




Usage
Run the program to interact with the MySQL database. You can input multiple students' details, view them, update, or delete records using the menu options.

License
This project is licensed under the MIT License - see the LICENSE file for details.
