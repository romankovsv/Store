<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Add Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<header class="topbar">
<ul>
	<li><a class="references" href="index.jsp">Home</a></li>
	<li><a href="./add" class="active">Add</a></li>
	<li><a href="./display">Dashboard</a></li>
	
</ul>
</header>

</br>
<div class="unsuccess_message">${message}</div>
<div class="success_message">${success_message}</div>

<p class="suggest">Please add the product:</p>

<body class="page">
	<section class="main_field">
	<form action="add" method="post">
		<table class="fields">

			<tr>
				<td><label>Title:</label></td>
				<td><input class="inputs" type="text" name="title" required></td>
			<tr>
				<td><label>Description:</label></td>
				<td><textarea class="inputs" name="description"></textarea></td>
			<tr>
				<td><label>Type</label></td>
				<td><select class="inputs" name="type">
						<option value="#">Choose type of Meal</option>
						<option value="soup">Soup</option>
						<option value="mainCourse">Main Course</option>
						<option value="desert">Desert</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Available:</label></td>
				<td><input type="checkbox" name="available" value="true"></td>
			</tr>
			<tr>
				<td><label>Price:</label></td>
				<td><input class="inputs" type="number" name="price" min=0
					required></td>
			</tr>
			<tr>
				<td><label>Owner:</label></td>
				<td><input class="inputs" type="text" name="owner"></td>
			</tr>

		</table>
		<input class="subm" type="submit" value="SAVE" name="submit">
	</form>
	</section>
</body>
</html>