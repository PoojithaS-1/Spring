<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Form 3</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}

		form {
			width: 50%;
			margin: 40px auto;
			padding: 20px;
			background-color: #fff;
			border: 1px solid #ddd;
			border-radius: 10px;
		}

		h1 {
			text-align: center;
		}

		label {
			display: block;
			margin-bottom: 10px;
		}

		input[type="text"], input[type="email"], input[type="tel"] {
			width: 100%;
			height: 40px;
			margin-bottom: 20px;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}

		input[type="submit"] {
			width: 100%;
			height: 40px;
			background-color: #4CAF50;
			color: #fff;
			padding: 10px;
			border: none;
			border-radius: 5px;
		}


	</style>
</head>
<body>
	<form action="addStud" method="post">
		<h1>Student Registration Form</h1>

		<label>Enter Full Name:</label>
		<input type="text" name="fullName"><br>
		<label>Enter Date of Birth:</label>
		<input type="text" name="dob"><br>
		<label>Enter Email ID:</label>
		<input type="email" name="emailId"><br>
		<label>Enter Mobile Number:</label>
		<input type="tel" name="mobileNumber"><br>
		<label>Enter Course Name:</label>
		<input type="text" name="courseName"><br>
		<label>Enter Semester:</label>
		<input type="text" name="semester"><br>
		<label>Enter College Name:</label>
		<input type="text" name="collegeName"><br>
		<input type="submit" value="Register" name="register">
	</form>
	<a href="getAllStudInfo">Get All Students Info</a>

</body>
</html>