
<%@page import="com.entities.User"%>
<%@page import="com.servlet.LoginServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User user1 = (User) session.getAttribute("user-obj");
if (user1 == null) {
	session.setAttribute("log-msg", "You have not login.Please Login First...");
	response.sendRedirect("LoginPage.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/RegiStyle.css">
<title>HomePage</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg custome-coler">
		<div class="container-fluid">
			<a class="navbar-brand name-style" href="#">CodeOfLalit</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="RegistrationPage.jsp">Registration</a></li>
					<li class="nav-item"><a class="nav-link" href="LoginPage.jsp">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="HomePage.jsp">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
	User user = (User) session.getAttribute("user-obj");
	%>
	<%
	if(user1!=null)
	{%>
	<div
		class="container d-flex justify-content-center align-items-center vh-75">
		<div class="mt-2 card" style="width: 18rem;">
			<div class="card-body text-center">
				<h5 class="card-title"><%=user.getName()%></h5>
				<h6 class="card-subtitle mb-2 text-muted"><%=user.getEmail()%></h6>
				<a href="LogOut" class="btn btn-danger">Logout</a>
			</div>
		</div>
	</div>
	<% }
	else{
		%><div class="alert alert-primary" role="alert"><%=session.getAttribute("log-msg") %></div><%

	} %>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>