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

        table {
            border-collapse: collapse;
            width: 70%;
            margin-left:15%

        }
        .head{
        text-align:center;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f0f0f0;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<h1 class="head">INCOME CERTIFICATE APPLICANT INFO</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Occupation</th>
        <th>Annual Income</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfApplicants}" var="applicantInfo">
        <tr>
            <td>${applicantInfo.id}</td>
            <td>${applicantInfo.fullName}</td>
            <td>${applicantInfo.dob}</td>
            <td>${applicantInfo.emailId}</td>
            <td>${applicantInfo.mobileNumber}</td>
            <td>${applicantInfo.address}</td>
            <td>${applicantInfo.city}</td>
            <td>${applicantInfo.state}</td>
            <td>${applicantInfo.pinCode}</td>
            <td>${applicantInfo.occupation}</td>
            <td>${applicantInfo.annualIncome}</td>
            <td><a href="delete?id=${applicantInfo.id}"><i class="material-icons">delete</i></a>&nbsp;
            <a href="getApplicant?id=${applicantInfo.id}"><i class="material-icons">edit</i></a></td>
        </tr>
    </poo:forEach>
</table></body>
</html>