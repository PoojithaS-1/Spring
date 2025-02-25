<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Reg Form</title>
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <style>

                body {
                    font-family: Arial, sans-serif;
                    background-color: #f2f2f2;
                }

                table {
                    border-collapse: collapse;
                    width: 90%;
                    margin: 40px auto;
                    box-shadow: 0 0 10px rgba(0,0,0,0.1);
                }

                th, td {
                    border: 1px solid #ddd;
                    padding: 15px;
                    text-align: center;
                }

                th {
                    background-color: #4CAF50;
                    color: #fff;
                }

                tr:nth-child(even) {
                    background-color: #f9f9f9;
                }

                tr:hover {
                    background-color: #ddd;
                }

                .head {
                    text-align: center;
                    margin-bottom: 20px;
                }

                a {
                    text-decoration: none;
                    color: #337ab7;
                }

                a:hover {
                    color: #23527c;
                }
            </style>
</head>
<body>
    <h1 class="head">STUDENTS INFO</h1>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Date of Birth</th>
            <th>Email ID</th>
            <th>Mobile Number</th>
            <th>Course Name</th>
            <th>Semester</th>
            <th>College Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${ListOfStudInfo}" var="studentInfo">
            <tr>
                <td>${studentInfo.studId}</td>
                <td>${studentInfo.fullName}</td>
                <td>${studentInfo.dob}</td>
                <td>${studentInfo.emailId}</td>
                <td>${studentInfo.mobileNumber}</td>
                <td>${studentInfo.courseName}</td>
                <td>${studentInfo.semester}</td>
                <td>${studentInfo.collegeName}</td>
                <td><a href="delete?id=${studentInfo.studId}"><i class="material-icons">delete</i></a> &nbsp;
                <a href="getStudInfo?studId=${studentInfo.studId}"><i class="material-icons">edit</i></a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
