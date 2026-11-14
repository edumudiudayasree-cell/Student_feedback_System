CREATE DATABASE IF NOT EXISTS student_feedback_db
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE student_feedback_db;

CREATE TABLE IF NOT EXISTS feedback (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    student_email VARCHAR(150) NOT NULL,
    department VARCHAR(100) NOT NULL,
    course VARCHAR(120) NOT NULL,
    faculty_name VARCHAR(120) NOT NULL,
    rating TINYINT NOT NULL,
    comments TEXT NOT NULL,
    submitted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_rating CHECK (rating BETWEEN 1 AND 5)
);

-- Optional sample record for testing:
INSERT INTO feedback
(student_name, student_email, department, course, faculty_name, rating, comments)
VALUES
('Demo Student', 'demo@example.com', 'Computer Science', 'Java Programming',
 'Faculty Demo', 5, 'Very clear explanations and useful practical sessions.');
