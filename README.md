# Student Feedback Management System

A Java JSP/Servlet + MySQL web application for collecting and reviewing student feedback.

## Requirements
- JDK 11 (or newer compatible JDK)
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 9
- MySQL Server 8.x and MySQL Workbench
- Maven (Eclipse m2e is sufficient)

## 1. Create the database
1. Open MySQL Workbench and connect to your local MySQL server.
2. Open `database/student_feedback.sql` and execute the complete script.
3. The application uses database `student_feedback_db`.

## 2. Configure the database connection
Open `src/main/java/com/studentfeedback/util/DBConnection.java` and update:
- `DB_USER` (default: `root`)
- `DB_PASSWORD` (replace `YOUR_MYSQL_PASSWORD` with your MySQL password)

Do not commit real database passwords to a public GitHub repository.

## 3. Import into Eclipse
1. Extract this ZIP.
2. In Eclipse choose **File > Import > Maven > Existing Maven Projects**.
3. Select the extracted `StudentFeedbackSystem` folder and click **Finish**.
4. Wait for Maven dependencies to download.
5. Right-click project > **Properties > Project Facets**. Ensure Java 11 and Dynamic Web Module 4.0 are selected if prompted.
6. Add Apache Tomcat 9: **Window > Show View > Servers** > create a new Tomcat v9 server and select your Tomcat installation.
7. Right-click project > **Run As > Run on Server**.

Open: `http://localhost:8080/StudentFeedbackSystem/`

## 4. Pages
- `/` — feedback submission form
- `/admin` — feedback dashboard (demo admin page; protect it with authentication before real deployment)

## 5. Build from command prompt
From the project folder run:
```bash
mvn clean package
```
The WAR will be created at `target/StudentFeedbackSystem.war`.

## Notes
- This is an academic/demo project. The admin dashboard is intentionally not password-protected; do not expose it to the public internet without adding authentication and authorization.
- Input is validated on the server and SQL uses prepared statements.
- Use a strong database password and keep credentials out of Git.
