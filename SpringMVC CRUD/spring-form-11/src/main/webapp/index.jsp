<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Birth Certificate Application</title>
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

		input[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<form action="addApplicant" method="post">
		<h1>Birth Certificate Application Form</h1>
		<label>Enter Child Name:</label>
		<input type="text" name="childName"><br>
		<label>Enter Date of Birth:</label>
		<input type="text" name="dob"><br>
		<label>Enter Place of Birth:</label>
		<input type="text" name="placeOfBirth"><br>
		<label>Enter Father's Name:</label>
		<input type="text" name="fatherName"><br>
		<label>Enter Mother's Name:</label>
		<input type="text" name="motherName"><br>
		<label>Enter Address:</label>
		<input type="text" name="address"><br>
		<label>Enter City:</label>
		<input type="text" name="city"><br>
		<label>Enter State:</label>
		<input type="text" name="state"><br>
		<label>Enter PIN Code:</label>
		<input type="text" name="pinCode"><br>
		<input type="submit" value="Apply for Birth Certificate" name="applyBirthCertificate">

	</form>
	<a href="getAllApplicantInfo">Get All Applicant Info</a>
</body>
</html>