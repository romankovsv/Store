<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<header class="topbar">
<ul>
	<li><a class="active href="index.jsp">Home</a></li>
	<li><a href="./add">Add</a></li>
	<li><a href="./display">Dashboard</a></li>
	<li><a href="./register">Register</a></li>
	<li><a href="./login">Sign in</a></li>
</ul>
</header>

</br>
<div class="unsuccess_message">${message}</div>
<div class="success_message">${success_message}</div>
