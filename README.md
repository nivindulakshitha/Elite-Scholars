# Elite Scholars Academy

## Overview
Elite Scholars Academy is a student management system (SMS) designed to manage students, teachers, courses, and grades. It provides functionalities to register students and teachers, record attendance, create courses, and view summaries.

## Features
- **Main Menu**: Navigate through options for managing students, teachers, courses, and grades.
- **Student Management**:
  - Register new students.
  - Record attendance.
  - Remove students.
  - View student summaries.
- **Teacher Management**:
  - Register new teachers.
  - Record attendance.
  - Remove teachers.
  - View teacher summaries.
- **Course Management**:
  - Create new courses.
  - Remove courses.
  - View course summaries.
- **Grade Management**:
  - View grade summaries.

## Classes

### Program.java
- Main class controlling the program flow.
- Manages menu navigation and option selection.

### Student.java
- Represents a student.
- Inherits from the `Human` class.
- Includes methods for setting and getting grades.

### Teacher.java
- Represents a teacher.
- Inherits from the `Human` class.
- Includes methods for setting and getting grades.

### Course.java
- Represents a course.
- Includes methods for setting and getting the teacher and grades associated with the course.

### Grade.java
- Represents a grade (e.g., 1st grade, 2nd grade).
- Includes methods for adding and removing students and getting the count of students.

### Human.java
- Represents a human entity with common attributes like name, gender, address, and attendance.
- Used as a superclass for `Student` and `Teacher` classes.

## Usage
1. Run the `Program.java` file to start the application.
2. Navigate through the menus to perform various management tasks.
3. Follow the prompts to enter information and make selections.

## Author
- **Nivindu Lakshitha**

## License
This project is licensed under the Creative Common license.

