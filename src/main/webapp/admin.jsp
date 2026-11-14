<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.studentfeedback.model.Feedback" %>
<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard | CampusVoice</title><link rel="stylesheet" href="assets/style.css"></head><body>
<header class="topbar"><a class="brand" href="index.jsp">Campus<span>Voice</span></a><nav><a href="index.jsp">Submit Feedback</a><a href="admin">Admin Dashboard</a></nav></header>
<main class="container wide"><section class="hero"><p class="eyebrow">OVERVIEW</p><h1>Feedback <span>dashboard.</span></h1><p class="muted">Review student responses and monitor course experience.</p></section>
<section class="panel"><div class="panel-heading"><div><p class="eyebrow">RESPONSE MANAGEMENT</p><h2>Submitted feedback</h2></div>
<% List<Feedback> list = (List<Feedback>) request.getAttribute("feedbackList"); %><span class="pill"><%= list == null ? 0 : list.size() %> responses</span></div>
<div class="table-wrap"><table><thead><tr><th>Student</th><th>Course / Faculty</th><th>Rating</th><th>Comments</th><th>Submitted</th><th>Action</th></tr></thead><tbody>
<% if (list == null || list.isEmpty()) { %><tr><td colspan="6" class="empty">No feedback submitted yet.</td></tr><% } else { for (Feedback f : list) { %>
<tr><td><strong><%= esc(f.getStudentName()) %></strong><small><%= esc(f.getStudentEmail()) %></small><small><%= esc(f.getDepartment()) %></small></td>
<td><strong><%= esc(f.getCourse()) %></strong><small><%= esc(f.getFacultyName()) %></small></td>
<td><span class="rating-badge"><%= f.getRating() %> / 5</span></td><td class="comment"><%= esc(f.getComments()) %></td>
<td><%= f.getSubmittedAt() %></td><td><form method="post" action="delete-feedback" onsubmit="return confirm('Delete this feedback?');"><input type="hidden" name="id" value="<%= f.getId() %>"><button class="delete-btn" type="submit">Delete</button></form></td></tr>
<% } } %></tbody></table></div></section><p class="footnote">Demo dashboard: add authentication and role-based access before real deployment.</p></main></body></html>
<%!
private String esc(String s) {
 if (s == null) return "";
 return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
}
%>