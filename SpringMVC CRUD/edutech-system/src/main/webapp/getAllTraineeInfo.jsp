<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EdduTech System</title>
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
<h1 class="head">TRAINEE INFO</h1>
<table>
    <tr>
        <th>SL NO</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact NO</th>
        <th>Course</th>
        <th>Sem</th>
        <th>College Name</th>
        <th>Year Of Study</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfTrainee}" var="traineeInfo">
        <tr>
            <td>${traineeInfo.getId()}</td>
            <td>${traineeInfo.getName()}</td>
            <td>${traineeInfo.getEmail()}</td>
            <td>${traineeInfo.getContactNo()}</td>
            <td>${traineeInfo.getCourse()}</td>
            <td>${traineeInfo.getSem()}</td>
            <td>${traineeInfo.getCollegeName()}</td>
            <td>${traineeInfo.getYearOfStudy()}</td>
            <td><a href="delete?id=${traineeInfo.getId()}"><i class="material-icons">delete</i></a> &nbsp;
            <a href="getTrainee?id=${traineeInfo.getId()}"><i class="material-icons">edit</i></a></td>
        </tr>
    </poo:forEach>
</table>
</body>
</html>