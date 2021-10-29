<%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/28/21
  Time: 8:26 PM
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
        .signup {
            position: absolute;
            top: 250px;
            left: 250px;
            padding-bottom: 100px;
            padding-right: 100px;
            height: 100%;
            width: 1000px;

        }
        .rightSignup {
            position: fixed;
            top: 250px;
            left: 550px

        }
        #loginButton {
            position: fixed;
            right: 150px;
            top: 150px;
        }
        .button{
            background: black;
            color: white;
            height: 75px;
            width: 150px;
        }
    </style>
<head>
    <title>JC Clothing - Sign Up</title>
</head>
<body>
<ul class="group1">
    <li id="item1"><a href="index.jsp"><img id="logo" src="resources_web/logo.png"/></a></li>
    <li><a href="Catalog">CATALOG</a></li>
    <li><a href="TrackOrder.jsp">TRACK ORDER</a></li>
    <li><a href="Contact.jsp">CONTACT US</a></li>
    <li><form id="searchBox" action="Catalog" method="post">
        <input type="text" name="searchBox">
        <input id="searchImage" type="image" src="resources_web/searchIcon.png" height="21px" width="21px">
        <input type="hidden" name="filter" value="search">
    </form> </li>
    <li>
        <form id="AccountLogin" action="AccountLoginServlet" method="post">
            <input type="image" src="resources_web/login.png" height="21px" width="21px">
        </form></li>
    <li><form id="ShoppingCartIcon" action="ShoppingCart.jsp" method="post">
        <input type="image" src="resources_web/shoppingCart.png" height="21px" width="21px">
    </form></li>
</ul>
<div class="signup">
    <form action="SignIn" method="post">
        Name:<br>
        <input name="fname" type="text" placeholder="First Name"><br>
        <input name="lname" type="text" placeholder="Last Name"><br>
        Street Address:<br>
        <input name="addr" type="text" placeholder="Street Address"><br>
        City:<br>
        <input name="city" type="text" placeholder="City"><br>
        State:<br>
        <input name="state" type="text" placeholder="State"><br>
        Zip:<br>
        <input name="zip" type="text" placeholder="Zip"><br>
        <div class="rightSignup">
            Username:<br>
            <input name="username" type="text" placeholder="Username"><br>
            Email:<br>
            <input name="email" type="email" placeholder="Email"><br>
            Password:<br>
            <input name="password" type="password" placeholder="Password"><br>
            Confirm:<br>
            <input name="confirm" type="password" placeholder="Password"><br>
            <input class="button" type="submit" value="Submit"><br>
        </div>
    </form>
    <form id="loginButton" action="Login.jsp">
        <input class="button" type="submit" value="Login">
    </form>
</div>

</body>
</html>
