<%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/20/21
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

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
        #loginForm{
            position: center;
        }
        #AccountLogin {
            padding: 20px 20px;
        }
        #ShoppingCartIcon {
            padding: 20px 5px;
        }
        #loginForm {
            position: absolute;
            top: 25%;
            left: 35%;
            padding-bottom: 100px;
        }
        .footer {
            position: fixed;
            align-self: center;
            bottom: 0;
            padding-top: 100px;
        }
        .options {
            position: fixed;
            right: 150px;
            top: 150px;
        }
        .buttons {
            background: black;
            color: white;
            height: 75px;
            width: 150px;
        }
    </style>
<head>
    <title>JC Clothing - Login</title>

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
        <input type="image" src="resources_web/shoppingCart.png" height="21px" width="21px">
    </form></li>
</ul>
<div id="loginForm">
    <form action="LoginServlet" method="post">
        Username:<br>
        <input type="text" name="username" placeholder="Enter your username"><br>
        Password:<br>
        <input type="password" name="password" placeholder="Enter your password"><br>
        <input class="buttons" type="submit" value="Login">
    </form>
    <%
        if (request.getAttribute("invalid") != null) {
    %>
    <p><%=request.getAttribute("invalid")%></p>
    <%
        }
    %>
</div>
<div class="options">
    <form action="SignUp.jsp" method="post">
        <input class="buttons" type="submit" value="Sign Up">
    </form>
</div>
<div class="footer"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>
