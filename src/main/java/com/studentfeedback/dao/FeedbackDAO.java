package com.studentfeedback.dao;

import com.studentfeedback.model.Feedback;
import com.studentfeedback.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public boolean save(Feedback f) throws SQLException {
        String sql = "INSERT INTO feedback (student_name, student_email, department, course, faculty_name, rating, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getStudentName());
            ps.setString(2, f.getStudentEmail());
            ps.setString(3, f.getDepartment());
            ps.setString(4, f.getCourse());
            ps.setString(5, f.getFacultyName());
            ps.setInt(6, f.getRating());
            ps.setString(7, f.getComments());
            return ps.executeUpdate() == 1;
        }
    }

    public List<Feedback> findAll() throws SQLException {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedback ORDER BY submitted_at DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                f.setStudentName(rs.getString("student_name"));
                f.setStudentEmail(rs.getString("student_email"));
                f.setDepartment(rs.getString("department"));
                f.setCourse(rs.getString("course"));
                f.setFacultyName(rs.getString("faculty_name"));
                f.setRating(rs.getInt("rating"));
                f.setComments(rs.getString("comments"));
                f.setSubmittedAt(rs.getTimestamp("submitted_at"));
                list.add(f);
            }
        }
        return list;
    }

    public boolean delete(int id) throws SQLException {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM feedback WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}