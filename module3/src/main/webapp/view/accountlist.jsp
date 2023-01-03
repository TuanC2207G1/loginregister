<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12/29/2022
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h1>Account List</h1>
    <from action="/findAccount" method="post">
        <input value="Find Account" name="find">
        <button type="submit" class="btn btn-success">Summit</button>
    </from>
        <c:if test="${sessionScope.account != null}">
            <a href="/logout" class="btn btn-danger col-6">Logout</a>
        </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>ID</td>
            <td>Email</td>
            <td>password</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Phone Number</td>
            <td>Address</td>
            <td>Role</td>
            <td>User Status</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="p" items="${accounts}">
            <tr>
                <td>${p.id}</td>
                <td>${p.email}</td>
                <td>${p.pass}</td>
                <td>${p.firstName}</td>
                <td>${p.lastName}</td>
                <td>${p.phoneNumber}</td>
                <td>${p.address}</td>
                <c:if test="${p.role==1}"><td style="color: green">Admin</td></c:if>
                <c:if test="${p.role==2}"><td style="color: red">User</td> </c:if>
                <c:if test="${p.user_status==1}"><td style="color: red"><a href="/changestatus?id=${p.id}" class="btn btn-danger" >Block</a></td></c:if>
                <c:if test="${p.user_status==0}"><td style="color: green"><a href="/changestatus?id=${p.id}" class="btn btn-success" >Unblock</a></td> </c:if>
                <td><a href="/edit?id=${p.id}" class="btn btn-info" >Edit</a></td>
                <td><a href="/delete?id=${p.id}" class="btn btn-danger" >Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
