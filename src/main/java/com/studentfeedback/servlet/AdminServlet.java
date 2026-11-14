package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private final FeedbackDAO dao = new FeedbackDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("feedbackList", dao.findAll());
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to load feedback records.", e);
        }
    }
}