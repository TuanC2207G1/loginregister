
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="/edit" method="post">
    <div class="container">
        <h1>EDIT</h1>
        <p>Please fill in this form to edit an account.</p>
        <hr>
        <input name="user_id" value="${toan.getId()}" hidden="hidden">
        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" value="${toan.getEmail()}" id="email" required>
        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" value="${toan.getPass()}" id="password" required>
        <label for="email"><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="first_name"  value="${toan.getFirstName()}"id="first_name" required>
        <label for="email"><b>Last Name</b></label>
        <input type="text" placeholder="Enter Last Name" name="last_name" value="${toan.getLastName()}" id="last_name" required>
        <label for="email"><b>Phone Number</b></label>
        <input type="text" placeholder="Enter Phone Number" name="phonenumber" value="${toan.getPhoneNumber()}" id="phonenumber" required>
        <label for="email"><b>Address</b></label>
        <input type="text" placeholder="Enter Address" name="address" value="${toan.getAddress()}" id="address" required>
        <hr>
        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>

</body>
</html>
