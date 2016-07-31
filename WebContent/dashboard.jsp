<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodstore.serg.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/dashboard-style.css">
</head>

<header class="topbar">
<ul>
	<li><a href="index.jsp">Home</a></li>
	<li><a href="./add">Add</a></li>
	<li><a class="active" href="./display">Dashboard</a></li>
</ul>
</header>
<br />

<body class="body">
	<form action="search" method="post" class="inputs">
		<table class="input">
			<tr>
				<td><input type="text" class="search_field" name="search"
					placeholder="Search field" /></td>
				<td><input type="submit" class="search_button"
					name="search_button" value="Search" /></td>
			</tr>
		</table>
	</form>

	<div class="unsuccess_message">${message}</div>

	<div class="success_message">${success_message}</div>

	<div class="success_message">${title}${success_remove}</div>

	<div class="unsuccess_message">${unsuccess_remove}</div>
	</br>

	<table class="tableOfMeals">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Type</th>
			<th>Price</th>
			<th>Description</th>
			<th>Available</th>
			<th>Owner</th>
			<th></th>
		</tr>

		<c:forEach items="${requestScope.food}" var="food">
			<tr>
				<td>${food.id}</td>
				<td>${food.title}</td>
				<td>${food.type}</td>
				<td>${food.price}</td>
				<td>${food.description}</td>
				<td>${food.available}</td>
				<td>${food.owner}</td>

				<td class="columnForDelete">
					<form action="remove" method="post">
						<input type="hidden" name="id" value="${food.id}"> <input
							type="hidden" name="title" value="${food.title}"> <input
							type="submit" class="delete" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
