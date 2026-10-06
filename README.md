# Student Managment App


**Student Managment App** - A simple console-based Student Management System built as a learning project to practice CRUD operations. It is not designed to solve any specific real-world problem — its only purpose is hands-on practice with Java 17, Maven, and clean code principles.

---


## About the project

Student Management System is a console-based CRUD application written in Java 17 and built with Maven. It was created as a training project to reinforce understanding of CRUD logic, layered architecture, and SOLID principles. The project does not aim to solve a real-world problem; it is a hands-on exercise meant to be used as a simple example during learning sessions.

- Create — adds a new student to the system by prompting for firstName, lastName, age, gender, and password. Input is validated before saving, and each new student is assigned a unique ID.
- Read — displays student data. The "list" command shows all students, while the "show" command displays a single student by ID.
- Update — edits an existing student by ID. The user is prompted for new values for firstName, lastName, age, gender, and password.
- Delete — removes a student by ID. The "clear" command deletes all students at once, but only after a yes/no confirmation.
- Help — prints the list of all available commands with short descriptions, so the user can see what the console supports.

---


## Features

| Function | Description |
|----------|-------------|
| create | adds a new student with firstName, lastName, age, gender, and password |
| list | displays all students in the system |
| show | displays a single student by ID |
| edit | updates an existing student by ID with new values |
| delete | removes a student by ID |
| clear | deletes all students after a yes/no confirmation |
| help | prints the list of available commands |
| quit | exits the program |

---


## Project objective

The main objective of this project is to practice CRUD logic in a real, working application. It was built as a learning exercise, not to solve a specific real-world problem.

- Understand and implement full CRUD operations in a console application.
- Apply layered architecture and SOLID principles in a small but complete project.
- Practice input validation and proper error handling.

---


## Technologies

| Technology | Version | Objective |
|------------|---------|-----------|
| Java  |  17  |  main programming language |
| Maven  |  3.8.7  |  build tool and dependency management |
| JUnit  |  5.10.1  |  unit testing |

---


## Installation and Execution

### Windows
```cmd
 git clone https://github.com/masharipov2105/student-managment-app.git

 cd student-management-app

 mvn clean package

 java -jar target/student-managment-app-1.0-SNAPSHOT.jar

```
---


### Linux/Mac
```bash
 git clone https://github.com/masharipov2105/student-managment-app.git

 cd student-management-app

 mvn clean package

 java -jar target/student-managment-app-1.0-SNAPSHOT.jar

```
---


## Project view

![Home](https://raw.githubusercontent.com/masharipov2105/student-managment-app/refs/heads/main/screenshots/s1.png)
![Home](https://raw.githubusercontent.com/masharipov2105/student-managment-app/refs/heads/main/screenshots/s2.png)
![Home](https://raw.githubusercontent.com/masharipov2105/student-managment-app/refs/heads/main/screenshots/s3.png)

---


## Project Structure

```cmd
student-managment-app/
├── screenshots/
│   ├── s1.png
│   ├── s2.png
│   └── s3.png
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── masharipov2105/
│   │               └── systems/
│   │                   ├── controller/
│   │                   │   └── StudentController.java
│   │                   ├── exceptions/
│   │                   │   ├── InvalidAgeException.java
│   │                   │   ├── InvalidCommandException.java
│   │                   │   ├── InvalidGenderException.java
│   │                   │   ├── InvalidNameException.java
│   │                   │   └── StudentException.java
│   │                   ├── models/
│   │                   │   ├── StudentModel.java
│   │                   │   ├── StudentRequestModel.java
│   │                   │   └── StudentResponseModel.java
│   │                   ├── repository/
│   │                   │   ├── StudentRepository.java
│   │                   │   └── StudentRepositoryImpl.java
│   │                   ├── service/
│   │                   │   ├── StudentService.java
│   │                   │   └── StudentServiceImpl.java
│   │                   ├── utils/
│   │                   │   ├── IdGenerator.java
│   │                   │   ├── InputValidator.java
│   │                   │   └── PasswordUtils.java
│   │                   └── Main.java
│   └── test/
│       └── java/
│           └── com/
│               └── masharipov2105/
│                   └── systems/
│                       ├── exceptions/
│                       │   ├── InvalidAgeExceptionTest.java
│                       │   ├── InvalidCommandExceptionTest.java
│                       │   ├── InvalidGenderExceptionTest.java
│                       │   ├── InvalidNameExceptionTest.java
│                       │   └── StudentExceptionTest.java
│                       ├── models/
│                       │   ├── StudentModelTest.java
│                       │   ├── StudentRequestModelTest.java
│                       │   └── StudentResponseModelTest.java
│                       ├── repository/
│                       │   └── StudentRepositoryImplTest.java
│                       ├── service/
│                       │   └── StudentServiceImplTest.java
│                       ├── utils/
│                       │   ├── IdGeneratorTest.java
│                       │   ├── InputValidatorTest.java
│                       │   └── PasswordUtilsTest.java
│                       └── MainTest.java
├── target/
│   ├── classes/
│   │   └── com/
│   │       └── masharipov2105/
│   │           └── systems/
│   │               ├── controller/
│   │               │   └── StudentController.class
│   │               ├── exceptions/
│   │               │   ├── InvalidAgeException.class
│   │               │   ├── InvalidCommandException.class
│   │               │   ├── InvalidGenderException.class
│   │               │   ├── InvalidNameException.class
│   │               │   └── StudentException.class
│   │               ├── models/
│   │               │   ├── StudentModel.class
│   │               │   ├── StudentRequestModel.class
│   │               │   └── StudentResponseModel.class
│   │               ├── repository/
│   │               │   ├── StudentRepository.class
│   │               │   └── StudentRepositoryImpl.class
│   │               ├── service/
│   │               │   ├── StudentService.class
│   │               │   └── StudentServiceImpl.class
│   │               ├── utils/
│   │               │   ├── IdGenerator.class
│   │               │   ├── InputValidator.class
│   │               │   └── PasswordUtils.class
│   │               └── Main.class
│   ├── generated-sources/
│   │   └── annotations/
│   ├── generated-test-sources/
│   │   └── test-annotations/
│   ├── maven-archiver/
│   │   └── pom.properties
│   ├── maven-status/
│   │   └── maven-compiler-plugin/
│   │       ├── compile/
│   │       │   └── default-compile/
│   │       │       ├── createdFiles.lst
│   │       │       └── inputFiles.lst
│   │       └── testCompile/
│   │           └── default-testCompile/
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   ├── surefire-reports/
│   │   ├── com.masharipov2105.systems.exceptions.InvalidAgeExceptionTest.txt
│   │   ├── com.masharipov2105.systems.exceptions.InvalidCommandExceptionTest.txt
│   │   ├── com.masharipov2105.systems.exceptions.InvalidGenderExceptionTest.txt
│   │   ├── com.masharipov2105.systems.exceptions.InvalidNameExceptionTest.txt
│   │   ├── com.masharipov2105.systems.exceptions.StudentExceptionTest.txt
│   │   ├── com.masharipov2105.systems.MainTest.txt
│   │   ├── com.masharipov2105.systems.models.StudentModelTest.txt
│   │   ├── com.masharipov2105.systems.models.StudentRequestModelTest.txt
│   │   ├── com.masharipov2105.systems.models.StudentResponseModelTest.txt
│   │   ├── com.masharipov2105.systems.repository.StudentRepositoryImplTest.txt
│   │   ├── com.masharipov2105.systems.service.StudentServiceImplTest.txt
│   │   ├── com.masharipov2105.systems.utils.IdGeneratorTest.txt
│   │   ├── com.masharipov2105.systems.utils.InputValidatorTest.txt
│   │   ├── com.masharipov2105.systems.utils.PasswordUtilsTest.txt
│   │   ├── TEST-com.masharipov2105.systems.exceptions.InvalidAgeExceptionTest.xml
│   │   ├── TEST-com.masharipov2105.systems.exceptions.InvalidCommandExceptionTest.xml
│   │   ├── TEST-com.masharipov2105.systems.exceptions.InvalidGenderExceptionTest.xml
│   │   ├── TEST-com.masharipov2105.systems.exceptions.InvalidNameExceptionTest.xml
│   │   ├── TEST-com.masharipov2105.systems.exceptions.StudentExceptionTest.xml
│   │   ├── TEST-com.masharipov2105.systems.MainTest.xml
│   │   ├── TEST-com.masharipov2105.systems.models.StudentModelTest.xml
│   │   ├── TEST-com.masharipov2105.systems.models.StudentRequestModelTest.xml
│   │   ├── TEST-com.masharipov2105.systems.models.StudentResponseModelTest.xml
│   │   ├── TEST-com.masharipov2105.systems.repository.StudentRepositoryImplTest.xml
│   │   ├── TEST-com.masharipov2105.systems.service.StudentServiceImplTest.xml
│   │   ├── TEST-com.masharipov2105.systems.utils.IdGeneratorTest.xml
│   │   ├── TEST-com.masharipov2105.systems.utils.InputValidatorTest.xml
│   │   └── TEST-com.masharipov2105.systems.utils.PasswordUtilsTest.xml
│   ├── test-classes/
│   │   └── com/
│   │       └── masharipov2105/
│   │           └── systems/
│   │               ├── exceptions/
│   │               │   ├── InvalidAgeExceptionTest.class
│   │               │   ├── InvalidCommandExceptionTest.class
│   │               │   ├── InvalidGenderExceptionTest.class
│   │               │   ├── InvalidNameExceptionTest.class
│   │               │   └── StudentExceptionTest.class
│   │               ├── models/
│   │               │   ├── StudentModelTest.class
│   │               │   ├── StudentRequestModelTest.class
│   │               │   └── StudentResponseModelTest.class
│   │               ├── repository/
│   │               │   └── StudentRepositoryImplTest.class
│   │               ├── service/
│   │               │   └── StudentServiceImplTest.class
│   │               ├── utils/
│   │               │   ├── IdGeneratorTest.class
│   │               │   ├── InputValidatorTest.class
│   │               │   └── PasswordUtilsTest.class
│   │               └── MainTest.class
│   ├── original-student-managment-app-1.0-SNAPSHOT.jar
│   └── student-managment-app-1.0-SNAPSHOT.jar
└── pom.xml
```
---


## License

This project is open source and released under the MIT License. Anyone is free to use, modify, and distribute it for educational or personal purposes.

---


## Author

- Github : [masharipov2105](https://github.com/masharipov2105)

- Telegram : [masharipov2105](https://t.me/masharipov2105)

- Gmail : masharipov2105@gmail.com


