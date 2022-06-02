<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Student</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="container">
		<div class="header">
			<h3>Modify Student</h3>
		</div>
		<div class="wrap">
			<form action="StudentControlServlet" method="get">
				<input type="hidden" name="command" value="UPDATE">
				<input type="hidden" name="studentId" value="${Student.id}">
				<div class="firstname">
					<label for="">First Name</label><br> <input type="text"
						name="firstname" value="${Student.firstName}" required>
				</div>
				<div class="lastname">
					<label for="">Last Name</label><br> <input type="text"
						name="lastname" value="${Student.lastName}" required>
				</div>
				<div class="email">
					<label for="">Email</label><br> <input type="email"
						name="email" value="${Student.email}" required>
				</div>
				<div class="gender">
					<label for="">Gender</label><br>
					<div>
						Male <input type="radio" name="gender" value="Male" required ${Student.gender=="Male"?"checked":""}>
						Female<input type="radio" name="gender" value="Female" required ${Student.gender=="Female"?"checked":""}>
					</div>

				</div>

				<div class="age">
					Age <input type="number" name="age" min="18" max="28" step="1" value="${Student.age}"
						required>
				</div>
				<div class="gpa">
					Gpa <input type="number" name="gpa" min="0.0" max="4.0" step="0.1" value="${Student.gpa}"
						required>
				</div>
				<input type="submit" value="Save change">
			</form>
		</div>
	</div>
</body>
</html>