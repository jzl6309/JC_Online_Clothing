<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.sql.SQLException" %>

<%@ page import="com.example.jcclothing.*" %><%--
  Created by IntelliJ IDEA.
  User: DjChris0024
  Date: 12/8/2021
  Time: 12:01 AM
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
    #bottom {
        padding-top: 50px;
    }
    td {
        padding: 15px;
    }
    .buttons {
        background: black;
        color: white;
        height: 25px;
        width: 85px;
    }
</style>
<head>
    <title>List of Staff</title>
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
<h1>Users</h1>

<table>
    <tr>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th></th>
    </tr>
    <%
        UserList userList = new UserList().getUserNames();

        String[] Usernames = userList.UserUsernames;
        String[] fNames = userList.UserFNames;
        String[] lNames = userList.UserLNames;

        int i = 0;

        while(Usernames[i] != null){
    %>
    <tr>
        <td><%=Usernames[i]%></td>
        <td><%=fNames[i]%></td>
        <td><%=lNames[i]%></td>
    </tr>
    <%
            i++;
        }
    %>
</table>
</body>
</html>