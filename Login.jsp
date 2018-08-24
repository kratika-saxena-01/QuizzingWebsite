<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Quizzing.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body class="b">

<div class="topnav">
<a class="left" href="#home">Home</a>
<a class="left" href="#takequiz">Take Quiz</a>
<a class="left" href="#About">About</a>
<a class="left" href="Contact">Contact Us</a>
<a class="right" href="#Login">Login</a>
</div>

<div class="loginbox">
	<img src="loginuser.jpg" class="login"/>
	<form action="Login" method="post">
		<p>Email</p>
		<input type="email" name="email" placeholder="Enter Email" required>
		<p>Password</p>
		<input type="password" name="pass" placeholder="Enter password" required>
		<input type="submit" value="Login">
		<a href="index.html">New User?Register?</a>
	</form>
</div>

</body>
</html>