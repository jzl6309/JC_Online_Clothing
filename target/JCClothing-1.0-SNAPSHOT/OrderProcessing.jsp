<%@ page import="com.example.jcclothing.OrderHistory" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.jcclothing.Order" %>
<%@ page import="com.example.jcclothing.OrderDetailsService" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 11/3/21
  Time: 12:30 PM
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
        .footer {
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
            width: 95px;
        }
        .orderNum {
            background: white;
            color: blue;
            text-decoration: underline;
            border-width: 0;
        }
    </style>
<head>
    <title>JC Clothing - Order Processing</title>
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
<h1>Order Processing</h1>
    <table>
        <tr>
            <th>Order Date</th>
            <th>Order Number</th>
            <th>Shipping Info</th>
            <th>Total Price</th>
            <th>Order Status</th>
            <th>Shipping Date</th>
            <th></th>
        </tr>
    <%
        OrderHistory orderHistory = (OrderHistory) request.getAttribute("orderHistory");
        DecimalFormat df = new DecimalFormat("$#,###.00");
        for (int i = 0; i < orderHistory.size(); i++) {
    %>
            <tr>
                <td><%=orderHistory.get(i).getOrderDate()%></td>
                <td><form action="OrderDetails" method="post">
                    <input type="hidden" name="order" value="<%=orderHistory.get(i).getOrderNum()%>">
                    <input class="orderNum" type="submit" value="<%=orderHistory.get(i).getOrderNum()%>">
                </form></td>
                <td>
    <%
            if (request.getAttribute("shippingInfo") != null && orderHistory.get(i).getOrderNum() == (int) request.getAttribute("orderNum")) {
                Order order = Order.getInstance();
    %>
                    <p><%=order.getFname()%> <%=order.getLname()%><br>
                        <%=order.getAddr()%><br>
                        <%=order.getCity()%>, <%=order.getState()%> <%=order.getZip()%></p>
                    <form action="AccountServlet" method="post">
                        <input type="hidden" name="options" value="orders">
                        <input class="buttons" type="submit" value="Close">
                    </form>
    <%
            } else {
    %>
                    <form action="OrderDetails" method="post">
                        <input type="hidden" name="orderNum" value="<%=orderHistory.get(i).getOrderNum()%>">
                        <input class="buttons" type="submit" value="Shipping Info">
                    </form>
    <%
            }
    %>
                    </td>
                    <td><%=df.format(orderHistory.get(i).getTotalPrice())%></td>
                    <td><%=orderHistory.get(i).getStatus()%></td>
                    <td><%if (orderHistory.get(i) != null) orderHistory.get(i).getShippingDate();%></td>
            <%
                if (!orderHistory.get(i).getStatus().equals("Shipped") && !orderHistory.get(i).getStatus().equals("Cancelled")) {
            %>
                    <td><form action="OrderDetails" method="post">
                        <input type="hidden" name="update" value="<%=orderHistory.get(i).getOrderNum()%>">
                        <input type="hidden" name="status" value="<%=orderHistory.get(i).getStatus()%>">
                        <input class="buttons" type="submit" value="Update">
                    </form></td>
            <%
                }
            %>
                </tr>
    <%
        }
    %>
    </table>
<div class="footer"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>
