<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jcclothing.OrderDetails" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 11/2/21
  Time: 11:51 AM
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
        .bottom {
            padding-top: 50px;
            width: 100%;
            bottom: 0;
        }
        td {
            padding-right: 50px;
            padding-left: 50px;
        }
        .buttons {
            background: black;
            color: white;
            height: 25px;
            width: 85px;
        }
    </style>
<head>
    <title>JC Clothing - Order Details</title>
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
<%
    DecimalFormat df = new DecimalFormat("#,###.00");
    ArrayList<OrderDetails> orderDetails = (ArrayList<OrderDetails>) request.getAttribute("orderDetails");
%>
<h1>Order #<%=orderDetails.get(0).getOrderNum()%> Details</h1>

    <table>
        <tr>
            <th>Item</th>
            <th>Desc</th>
            <th>Color</th>
            <th>Size</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    <%
        for (int i = 0; i < orderDetails.size(); i++) {
    %>
            <tr>
                <td><img src="resources_web/<%=orderDetails.get(i).getItemImage()%>" height="75px" width="75"></td>
                <td><%=orderDetails.get(i).getItemName()%></td>
                <td><%=orderDetails.get(i).getItemColor()%></td>
                <td><%=orderDetails.get(i).getSize()%></td>
                <td><%=orderDetails.get(i).getQuantity()%></td>
                <td><%=df.format(orderDetails.get(i).getPrice()*orderDetails.get(i).getQuantity())%></td>
            </tr>
    <%
        }
    %>
    </table>
<div style="text-align: center"><img class="bottom" src="resources_web/bottom.jpg"/></div>

</body>
</html>
