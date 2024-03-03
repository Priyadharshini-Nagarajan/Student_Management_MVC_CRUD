<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<h2>Student List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>
                    <a href="/students/edit/${student.id}">Edit</a>
                    <a href="/students/delete/${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/students/showForm">Add New Student</a>
</body>
</html>