package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import com.studentfeedback.model.Feedback;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/submit-feedback")
public class FeedbackServlet extends HttpServlet {
    private final FeedbackDAO dao = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = value(request, "studentName");
        String email = value(request, "studentEmail");
        String department = value(request, "department");
        String course = value(request, "course");
        String faculty = value(request, "facultyName");
        String comments = value(request, "comments");
        int rating;

        try {
            rating = Integer.parseInt(value(request, "rating"));
        } catch (NumberFormatException e) {
            rating = 0;
        }

        if (name.isEmpty() || email.isEmpty() || department.isEmpty() ||
            course.isEmpty() || faculty.isEmpty() || comments.isEmpty() ||
            !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ||
            rating < 1 || rating > 5) {
            request.setAttribute("error", "Please complete every field with a valid email and rating.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        Feedback f = new Feedback();
        f.setStudentName(name);
        f.setStudentEmail(email);
        f.setDepartment(department);
        f.setCourse(course);
        f.setFacultyName(faculty);
        f.setRating(rating);
        f.setComments(comments);

        try {
            if (dao.save(f)) {
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                request.setAttribute("error", "Feedback could not be saved. Please try again.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error. Check DBConnection.java and run the SQL script.", e);
        }
    }

    private String value(HttpServletRequest req, String key) {
        String v = req.getParameter(key);
        return v == null ? "" : v.trim();
    }
}