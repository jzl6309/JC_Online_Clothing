<%@ page import="com.example.jcclothing.AuthenticateService" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 11/1/21
  Time: 6:50 PM
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
    .options {
        position: fixed;
        right: 50%;
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
    <title>JC Clothing - Account</title>
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

<h1>Account</h1>
<p>Hello <%=AuthenticateService.user.getFname()%>!</p>
<p>Edit Account Info:<br></p>
<form action="EditAccount" method="post">
    <%=AuthenticateService.user.getUser()%><br>
    <input name="email" type="email" value="<%=AuthenticateService.user.getEmail()%>" required><br>
    Address:<br>
    <input name="addr" type="text" value="<%=AuthenticateService.user.getAddr()%>" required><br>
    <input name="city" type="text" value="<%=AuthenticateService.user.getCity()%>" required><br>
    <input name="state" type="text" value="<%=AuthenticateService.user.getState()%>" required pattern="[A-Z]{1}[A-Za-z]{1}"
           oninvalid="this.setCustomValidity('Please enter a valid state.')" oninput="this.setCustomValidity('')"><br>
    <input name="zip" type="text" value="<%=AuthenticateService.user.getZip()%>" required pattern="\d{5}-?(\d{4})?"
           oninvalid="this.setCustomValidity('Please enter a valid zip code.')" oninput="this.setCustomValidity('')"><br>
    Password:<br>
    <input name="password" type="password" placeholder="Password"><br>
    Confirm:<br>
    <input name="confirm" type="password" placeholder="Password"><br>
    <input class="buttons" type="submit" value="Submit"><br>
</form>
    <%
        if(request.getAttribute("error") != null) {
    %>
            <p><%=request.getAttribute("error")%></p>
    <%
        }
    %>
<div class="options">
    <form action="AccountServlet" method="post">
        <input type="hidden" name="options" value="logout">
        <input class="buttons" type="submit" value="Logout">
    </form>
</div>
</body>
</html>
