<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<h2>${student.id == 0 ? 'Add New Student' : 'Edit Student'}</h2>
    <form action="${student.id == 0 ? '/students/saveStudent' : '/students/updateStudent'}" method="post">
        <input type="hidden" name="id" value="${student.id}">
        Name: <input type="text" name="name" value="${student.name}"><br>
        Email: <input type="email" name="email" value="${student.email}"><br>
        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="/students/list">Back to List</a>
</body>
</html>