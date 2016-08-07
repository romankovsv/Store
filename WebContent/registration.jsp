<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<header class="topbar">
<ul>
	<li><a class="references" href="index.jsp">Home</a></li>
	<li><a href="./add">Add</a></li>
	<li><a href="./display">Dashboard</a></li>
	<li><a href="./register" class="active">Register</a></li>
	<li><a href="./login">Sign in</a></li>

</ul>
</header>

</br>
<div class="unsuccess_message">${message}</div>
<div class="success_message">${success_message}</div>


<body class="page">
	<section class="registration_fields">
	<form action="register" method="post">
		<table class="fields">

			<tr>
				<td><label>Email:</label></td>
				<td><input class="inputs" type="text" name="email" required></td>
			<tr>
				<td><label>Password:</label></td>
				<td><input class="inputs" type="password" name="password"
					required></td>
			<tr>
			<tr>
				<td><label>Repeat Password:</label></td>
				<td><input class="inputs" type="password"
					name="passwordConform" required></td>
		</table>
		<input class="subm" type="submit" value="Register" name="submit">
	</form>
	</section>
</body>
</html>