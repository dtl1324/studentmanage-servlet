<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="container">
        <div class="header">
            <h3>Add More Student</h3>
        </div>
        <div class="wrap">
            <form action="StudentControlServlet" method="get">
                <input type="hidden" name="command" value="ADD">
                <div class="firstname">
                    <label for="">First Name</label><br>
                    <input type="text" name="firstname" required>
                </div>
                <div class="lastname">
                    <label for="">Last Name</label><br>
                    <input type="text" name="lastname" required>
                </div>
                <div class="email">
                    <label for="">Email</label><br>
                    <input type="email" name="email" required>
                </div>
                <div class="gender">
                    <label for="">Gender</label><br>
                   <div>
                    Male <input type="radio" name="gender" value="Male" required>
                    Female<input type="radio" name="gender" value="Female" required>
                   </div>

                </div>
                
                <div class="age">
                    Age
                    <input type="number" name="age" min="18" max="28" step="1" required>
                </div>
                <div class="gpa">
                    Gpa
                    <input type="number" name="gpa" min="0.0" max="4.0" step="0.1" required>
                </div>
                <input type="submit" value="Add">
            </form>
        </div>
    </div>
</body>
</html>