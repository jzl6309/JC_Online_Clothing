<%@ page import="com.example.jcclothing.AuthenticateService" %>
<%@ page import="com.example.jcclothing.User" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/27/21
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <style>
        .group1 {
            font-family: Verdana, sans-serif;
            font-size: 1.2rem;
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: black;
        }
        .group1 li {
            float: left;
        }
        .group1 li a {
            display: block;
            color: white;
            text-align: center;
            vertical-align: center;
            padding: 20px 65px;
            text-decoration: none;
        }
        #logo {
            width: 150px;
            height: 50px;
        }
        #searchBox {
            vertical-align: center;
            padding-top: 22px;
        }
        #AccountLogin {
            padding: 20px 20px;
        }
        #ShoppingCartIcon {
            padding: 20px 5px;
        }
        .button{
            background: black;
            color: white;
            height: 35px;
            width: 210px;
        }
        .form {
            position: absolute;
            top: 150px;
            left: 550px;
        }
    </style>
<head>
    <title>JC Clothing - Checkout</title>
</head>
<body>
    <ul class="group1">
        <li id="item1"><a href="index.jsp"><img id="logo" src="resources_web/logo.png"/></a></li>
        <li><a href="Catalog">CATALOG</a></li>
        <li><a href="TrackOrder">TRACK ORDER</a></li>
        <li><a href="Contact.jsp">CONTACT US</a></li>
        <li><form id="searchBox" action="search.jsp" method="post">
            <input type="text" name="searchBox">
            <input id="searchImage" type="image" src="resources_web/searchIcon.png" height="21px" width="21px">
        </form> </li>
        <li><form id="AccountLogin" action="AccountLoginServlet" method="post">
            <input type="image" src="resources_web/login.png" height="21px" width="21px">
        </form></li>
        <li><form id="ShoppingCartIcon" action="ShoppingCart.jsp" method="post">
            <input type="image" src="resources_web/shoppingCart.png" height="21px" width="21px">ty
        </form></li>
    </ul>

    <h1>Checkout</h1>
    <div class="form">
    <% if (AuthenticateService.loggedIn) {
        User user = AuthenticateService.user;
    %>
        <p>Shipping and Payment Info</p>
        <form action="Confirmation.jsp" method="post">
            Name:<br>
            <input name="fname" type="text" value="<%=user.getFname()%>" required><br>
            <input name="lname" type="text" value="<%=user.getLname()%>" required><br>
            Street Address:<br>
            <input name="addr" type="text" value="<%=user.getAddr()%>" required><br>
            City:<br>
            <input name="city" type="text" value="<%=user.getCity()%>" required><br>
            State:<br>
            <input name="state" type="text" value="<%=user.getState()%>" required pattern="[A-Z]{1}[A-Za-z]{1}"
                   oninvalid="this.setCustomValidity('Please enter a valid state.')" oninput="this.setCustomValidity('')"><br>
            Zip:<br>
            <input name="zip" type="text" value="<%=user.getZip()%>" required pattern="\d{5}-?(\d{4})?"
                   oninvalid="this.setCustomValidity('Please enter a valid zip code.')" oninput="this.setCustomValidity('')"><br>
            Credit Card:<br>
            <input name="CC" type="text" placeholder="Enter Credit Card" required pattern="\d{9-12}"
                   oninvalid="this.setCustomValidity('Please enter a credit card number.')" oninput="this.setCustomValidity('')"><br>
            <input class="button" type="submit" value="Submit">
        </form>
    <%
        }
        else {
    %>
        <p>Enter Shipping and Payment Info</p>
        <form action="Confirmation.jsp" method="post">
            Name:<br>
            <input name="fname" type="text" placeholder="First Name" required><br>
            <input name="lname" type="text" placeholder="Last Name" required><br>
            Street Address:<br>
            <input name="addr" type="text" placeholder="Street Address" required><br>
            City:<br>
            <input name="city" type="text" placeholder="City" required><br>
            State:<br>
            <input name="state" type="text" placeholder="State" required pattern="[A-Z]{1}[A-Za-z]{1}"
                   oninvalid="this.setCustomValidity('Please enter a valid state.')" oninput="this.setCustomValidity('')"><br>
            Zip:<br>
            <input name="zip" type="text" placeholder="Zip" required pattern="\d{5}-?(\d{4})?"
                   oninvalid="this.setCustomValidity('Please enter a valid zip code.')" oninput="this.setCustomValidity('')"><br>
            Credit Card:<br>
            <input name="CC" type="text" placeholder="Enter Credit Card" required pattern="\d{9-12}"
                   oninvalid="this.setCustomValidity('Please enter a valid credit card number.')" oninput="this.setCustomValidity('')"><br>
            <input class="button" type="submit" value="Submit">
        </form>
    <%
        }
    %>
        <br><p>Or Login</p>
        <form action="Login.jsp" method="post">
            <input class="button" type="submit" value="Login">
        </form>
    </div>
</body>
</html>
