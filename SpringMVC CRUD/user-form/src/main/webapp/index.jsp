<!DOCTYPE html>
<html>
<head>
	<title>User Form</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f0f0f0;
		}
		
		form {
			width: 30%;
			margin: 50px auto;
			padding: 50px;
			background-color: #fff;
			border: 1px solid #ddd;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		
		h1 {
			text-align: center;
			margin-bottom: 20px;
		}
		
		label {
			display: block;
			margin-bottom: 10px;
		}
		
		input[type="text"], input[type="email"], input[type="tel"] {
			width: 95%;
			height: 40px;
			margin-bottom: 20px;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
		}
		
		input[type="submit"] {
			width: 100%;
			height: 40px;
			background-color: blue;
			color: #fff;
			padding: 10px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
		
		input[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<form action="addUser" method="post">
		<h1>User Form</h1><br>
		<label>Enter First Name:</label>
		<input type="text" name="firstName"><br>
		<label>Enter Last Name:</label>
		<input type="text" name="lastName"><br><br>
		<label>Enter Email ID:</label>
		<input type="email" name="emailId"><br>
		<label>Enter Phone Number:</label>
		<input type="tel" name="phoneNumber"><br>
		<input type="submit" value="Submit"><br>
	</form>
	<a href="getAllUserInfo">Get All Applicant Info</a>
</body>
</html>