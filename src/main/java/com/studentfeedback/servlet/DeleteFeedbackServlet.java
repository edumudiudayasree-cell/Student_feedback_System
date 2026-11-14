package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete-feedback")
public class DeleteFeedbackServlet extends HttpServlet {
    private final FeedbackDAO dao = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rawId = request.getParameter("id");
        try {
            int id = Integer.parseInt(rawId);
            if (id > 0) dao.delete(id);
            response.sendRedirect(request.getContextPath() + "/admin");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid feedback ID.");
        } catch (SQLException e) {
            throw new ServletException("Unable to delete feedback.", e);
        }
    }
}