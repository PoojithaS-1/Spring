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
        <th>Applicant Name</th>
        <th>Passport Number</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Visa Type</th>
        <th>Travel Dates</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfApplicants}" var="applicantInfo">
        <tr>
            <td>${applicantInfo.getId()}</td>
            <td>${applicantInfo.getApplicantName()}</td>
            <td>${applicantInfo.getPassportNumber()}</td>
            <td>${applicantInfo.getDob()}</td>
            <td>${applicantInfo.getEmailId()}</td>
            <td>${applicantInfo.getMobileNumber()}</td>
            <td>${applicantInfo.getAddress()}</td>
            <td>${applicantInfo.getCity()}</td>
            <td>${applicantInfo.getState()}</td>
            <td>${applicantInfo.getPinCode()}</td>
            <td>${applicantInfo.getVisaType()}</td>
            <td>${applicantInfo.getTravelDates()}</td>
            <td><a href="delete?id=${applicantInfo.getId()}"><i class="material-icons">delete</i></a> &nbsp;
            <a href="getAllApplicant?id=${applicantInfo.getId()}"><i class="material-icons">edit</i></a></td>
        </tr>
    </poo:forEach>
</table>

</body>
</html>