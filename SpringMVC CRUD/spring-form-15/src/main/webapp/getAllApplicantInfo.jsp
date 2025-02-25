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
        <th>ID</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Family Income</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfApplicants}" var="beneficiaryInfo">
        <tr>
            <td>${beneficiaryInfo.id}</td>
            <td>${beneficiaryInfo.fullName}</td>
            <td>${beneficiaryInfo.dob}</td>
            <td>${beneficiaryInfo.emailId}</td>
            <td>${beneficiaryInfo.mobileNumber}</td>
            <td>${beneficiaryInfo.address}</td>
            <td>${beneficiaryInfo.city}</td>
            <td>${beneficiaryInfo.state}</td>
            <td>${beneficiaryInfo.pinCode}</td>
            <td>${beneficiaryInfo.familyIncome}</td>
            <td><a href="delete?id=${beneficiaryInfo.id}"><i class="material-icons">delete</i></a>
            &nbsp;
            <a href="getApplicant?id=${beneficiaryInfo.id}"><i class="material-icons">edit</i></a></td>
        </tr>
    </poo:forEach>
</table></body>
</html>