<%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 11/1/21
  Time: 9:25 PM
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
        .form {
            position: fixed;
            right: 50%;
            top: 150px;
        }
        .buttons {
            background: black;
            color: white;
            height: 35px;
            width: 210px;
        }
    </style>
<head>
    <title>JCClothing - Reset User Password</title>
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
<div class="form">
    <form action="ResetPassword" method="post">
        Username:<br>
        <input name="username" type="text" placeholder="username" required><br>
        <input class="buttons" type="submit" value="Reset">
    </form>
    <form action="AccountLoginServlet" method="post">
        <input class="buttons" type="submit" value="cancel">
    </form>
    <%
        if (request.getAttribute("error") != null) {
    %>
            <%=request.getAttribute("error")%>
    <%
        } else if (request.getAttribute("username") != null) {
    %>
            <p>Password reset for <%=request.getAttribute("username")%></p>
    <%
        }
    %>
</div>

</body>
</html>
