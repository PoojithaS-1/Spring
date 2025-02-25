<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
<h1 class="head">APPLICANT INFO</h1>
<table>
    <tr>
        <th>SL NO</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Vehicle Type</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfDrivers}" var="driverInfo">
        <tr>
            <td>${driverInfo.getId()}</td>
            <td>${driverInfo.getFullName()}</td>
            <td>${driverInfo.getDob()}</td>
            <td>${driverInfo.getEmailId()}</td>
            <td>${driverInfo.getMobileNumber()}</td>
            <td>${driverInfo.getAddress()}</td>
            <td>${driverInfo.getCity()}</td>
            <td>${driverInfo.getState()}</td>
            <td>${driverInfo.getPinCode()}</td>
            <td>${driverInfo.getVehicleType()}</td>
            <td><a href="delete?id=${driverInfo.getId()}"><i class="material-icons">delete</i></a> &nbsp;
            <a href="getApplicant?id=${driverInfo.getId()}"><i class="material-icons">edit</i></a></td>
        </tr>
    </poo:forEach>
</table>
</body>
</html>