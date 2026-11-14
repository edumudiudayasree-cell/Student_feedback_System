<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en"><head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Feedback | CampusVoice</title><link rel="stylesheet" href="assets/style.css">
</head><body>
<header class="topbar"><a class="brand" href="index.jsp">Campus<span>Voice</span></a>
<nav><a href="index.jsp">Submit Feedback</a><a href="admin">Admin Dashboard</a></nav></header>
<main class="container">
<section class="hero"><p class="eyebrow">YOUR VOICE MATTERS</p><h1>Help us make learning <span>better.</span></h1>
<p class="muted">Share your experience and help us improve courses, teaching and campus learning.</p></section>
<section class="panel">
<div class="panel-heading"><div><p class="eyebrow">STUDENT SURVEY</p><h2>Course feedback form</h2></div><span class="pill">2–3 min</span></div>
<% if (request.getAttribute("error") != null) { %><div class="alert"><%= request.getAttribute("error") %></div><% } %>
<form action="submit-feedback" method="post">
<div class="form-grid">
<label>Student name<input name="studentName" maxlength="100" required placeholder="Enter your full name"></label>
<label>Email address<input type="email" name="studentEmail" maxlength="150" required placeholder="you@example.com"></label>
<label>Department<select name="department" required><option value="">Select department</option><option>Computer Science</option><option>Electronics</option><option>Electrical</option><option>Mechanical</option><option>Civil</option><option>Other</option></select></label>
<label>Course / Subject<input name="course" maxlength="120" required placeholder="e.g. Java Programming"></label>
<label class="full">Faculty name<input name="facultyName" maxlength="120" required placeholder="Enter faculty name"></label>
<fieldset class="full"><legend>How would you rate this course?</legend>
<div class="ratings"><label><input type="radio" name="rating" value="1" required><span>1</span><small>Poor</small></label>
<label><input type="radio" name="rating" value="2"><span>2</span><small>Fair</small></label>
<label><input type="radio" name="rating" value="3"><span>3</span><small>Good</small></label>
<label><input type="radio" name="rating" value="4"><span>4</span><small>Very good</small></label>
<label><input type="radio" name="rating" value="5"><span>5</span><small>Excellent</small></label></div></fieldset>
<label class="full">Your comments<textarea name="comments" rows="4" maxlength="2000" required placeholder="What worked well? What could be improved?"></textarea></label>
</div><button class="btn" type="submit">Submit feedback <span>→</span></button>
</form></section><p class="footnote">Thank you for helping us build a better learning experience.</p>
</main></body></html>