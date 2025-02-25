<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EduTech</title>
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
<form action="addTrainee" method="post">
    <h1>Registration Form</h1>
    <label>Enter Full Name:</label>
    <input type="text" name="name"><br>
    <label>Enter Email id:</label>
    <input type="email" name="email"><br>
    <label>Enter Contact Number:</label>
    <input type="text" name="contactNo"><br>
    <label>Enter Course:</label>
    <input type="text" name="course"><br>
    <label>Enter Semester:</label>
    <input type="text" name="sem"><br>
    <label>Enter College Name:</label>
    <input type="text" name="collegeName"><br>

    <label>Year of Study:</label>
    <input type="text" name="yearOfStudy"><br>
    <input type="submit" value="Register" name="register">
</form>
<a href="getAllTraineeInfo">Get All Trainee Info</a>

</body>
</html>