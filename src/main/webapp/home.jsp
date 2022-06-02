<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Manager Home</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<div class="header">
<h3>Student Manager Home Page</h3>
</div>

<input type="button"  value="Add Student" onclick="window.location.href='addstudent.jsp'">
	<table border="1">
	<thead>
		<tr>
				<th>ID</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>GENDER</th>
				<th>EMAIL</th>
				<th>AGE</th>
				<th>GPA</th>
				<th colspan="2">ACTION</th>
			</tr>
	</thead>
		<tbody>
		
			<c:forEach var="tempStudent" items="${list_student}">
				<tr>
					<!--set 2 url to dispatch update and delete action  -->
					<c:url var="update" value="StudentControlServlet">
					<c:param name="command" value="LOAD"></c:param>
					<c:param name="studentId" value="${tempStudent.id}"></c:param>
					</c:url>
					<c:url var="delete" value="StudentControlServlet">
					<c:param name="command" value="DELETE"></c:param>
					<c:param name="studentId" value="${tempStudent.id}"></c:param>
					</c:url>
					<td>${tempStudent.id}</td>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.gender}</td>
					<td>${tempStudent.email}</td>
					<td>${tempStudent.age}</td>
					<td>${tempStudent.gpa}</td>
					<td><a href="${update}">Update</a></td>
					<td><a href="#" onclick="showMessage(${tempStudent.id})">Delete</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<script type="text/javascript">
	function showMessage(id) {
		let option=confirm("Are you sure to delete student have ID="+id+"?");
		if(option=== true){
			window.location.href='StudentControlServlet?command=DELETE&studentId='+id;
		}
		
	}
	</script>
</body>
</html>