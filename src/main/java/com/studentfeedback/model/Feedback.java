package com.studentfeedback.model;

import java.sql.Timestamp;

public class Feedback {
    private int id;
    private String studentName, studentEmail, department, course, facultyName, comments;
    private int rating;
    private Timestamp submittedAt;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String v) { studentName = v; }
    public String getStudentEmail() { return studentEmail; }
    public void setStudentEmail(String v) { studentEmail = v; }
    public String getDepartment() { return department; }
    public void setDepartment(String v) { department = v; }
    public String getCourse() { return course; }
    public void setCourse(String v) { course = v; }
    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String v) { facultyName = v; }
    public String getComments() { return comments; }
    public void setComments(String v) { comments = v; }
    public int getRating() { return rating; }
    public void setRating(int v) { rating = v; }
    public Timestamp getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Timestamp v) { submittedAt = v; }
}