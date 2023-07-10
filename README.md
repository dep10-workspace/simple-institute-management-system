# Institute Management System - Group Project

This repository contains the code and documentation for the Institute Management System, a group project developed by three members of the Institute of Software Engineering (IJSE) during the full-stack developer training program to identify how to do a group project via VCS and solve conflicts.

## Project Overview

The Institute Management System is a web-based application designed to manage students and courses within an educational institution. The system consists of three components:

1. Front-end Angular App: Responsible for the user interface and interaction. It allows administrators to perform various tasks such as adding, updating, and deleting student records and details of courses .

2. Back-end Spring Boot App (Student Management): Handles the student-related functionality, such as student registration, information retrieval, and updates. It communicates with the database to store and retrieve student data.

3. Back-end Node.js App (Course Management): Manages course-related tasks, including course creation, enrollment management. It interacts with the database to store and retrieve course information.

## Team Members

The project was developed collaboratively by the following team members:

1. Subhash Chamara Udayanga - [GitHub Profile](https://github.com/SubhashChamara)
2. Dhanushka Kasun Bandara - [GitHub Profile](https://github.com/danushkakasun05)
3. Dilan Udayantha  - [GitHub Profile](https://github.com/dilanasiri)

## Technologies Used

The following technologies were used to develop the Institute Management System:

- Front-end:
  - Angular
- Back-end (Student Management):
  - Spring Boot
  - Java
  - MySQL Database
- Back-end (Course Management):
  - Node.js
  - Express.js
  - MySQL Database
- Version Control: Git

## Project Structure

The repository is organized as follows:

```
├── frontend/
[https://github.com/dep10-workspace/simple-institute-management-system/tree/4fe5300f1aec967afa4224ef0fdba4365eb8046a/nodejs-app]
├── backend-student/
[https://github.com/dep10-workspace/simple-institute-management-system/tree/4fe5300f1aec967afa4224ef0fdba4365eb8046a/spring-boot-app]
├── backend-course/         
[https://github.com/dep10-workspace/simple-institute-management-system/tree/4fe5300f1aec967afa4224ef0fdba4365eb8046a/nodejs-app]
├── README.md                
[https://github.com/dep10-workspace/simple-institute-management-system/blob/4fe5300f1aec967afa4224ef0fdba4365eb8046a/README.md]
```

## Installation and Setup

To set up the project locally, follow the steps below:

1. Clone the repository:

```bash
git clone https://github.com/dep10-workspace/simple-institute-management-system.git
```

2. Set up the front-end:

- Navigate to the `front-end` directory.
- Install the required packages:

```bash
cd front-end
npm install
```

3. Set up the back-end (Student Management):

- Navigate to the `backend-student` directory.
- Install the required packages and dependencies:

```bash
cd ../backend-student
mvn install
```

- Set up the MySQL database:
  - Create a new MySQL database.
  - Update the database configuration in `backend-student/src/main/resources/application.properties` with your database credentials.

4. Set up the back-end (Course Management):

- Navigate to the `backend-course` directory.
- Install the required packages:

```bash
cd ../backend-course
npm install
```

- Set up the MongoDB database:
  - Create a new MySQL database.
  - Update the database configuration in `backend-course/env` with your database connection details.

5. Run the application:

- Start the front-end Angular app:

```bash
cd frontend
npm start
```

- Start the back-end (Student Management) Spring Boot app:
  - Run the following command in the `backend-student` directory:

```bash
cd ../backend-student
mvn spring-boot:run
```

- Start the back-end (Course Management) Node.js app:
  - Run the following command in the `backend-course` directory:

```bash
cd ../backend-course
npm start
```

6. Access the application:

- Open your web browser and visit `http://localhost:4200` to access the Institute Management System.

## Contributing

We welcome contributions to the project. If you find any issues or have suggestions for improvement, please feel free to open an issue or submit a pull request.

## License

Copyright &copy; 2023 | Dep Group TeamShark | All Rights Reserved.
