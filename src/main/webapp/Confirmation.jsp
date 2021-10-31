<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.jcclothing.ShoppingCart" %>
<%@ page import="com.example.jcclothing.ShoppingCartItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jcclothing.Order" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/30/21
  Time: 8:03 PM
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
        .buttons{
            background: black;
            color: white;
            height: 35px;
            width: 210px;
        }
        .shippingInfo {
            float: left;
            padding-right: 100px;
        }
        .form {
            position: absolute;
            top: 150px;
            left: 550px;
        }
        td {
            padding: 30px;
        }
    </style>
<head>
    <title>JC Clothing - Confirmation</title>
</head>
<body>
    <ul class="group1">
        <li id="item1"><a href="index.jsp"><img id="logo" src="resources_web/logo.png"/></a></li>
        <li><a href="Catalog">CATALOG</a></li>
        <li><a href="TrackOrder.jsp">TRACK ORDER</a></li>
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

    <%
        ShoppingCart cart = ShoppingCart.getInstance();
        ArrayList<ShoppingCartItem> shoppingCart = cart.getShoppingCart();
        DecimalFormat df = new DecimalFormat("$#,##0.00");
    %>
    <h1>Confirmation</h1>
    <div class="shippingInfo">
        <p><b>Please Confirm Your Information</b></p>
        <p>Name:<br>
        <%=request.getParameter("fname")%><br>
        <%=request.getParameter("lname")%></p><br>
        <p>Shipping Address:<br>
        <%=request.getParameter("addr")%><br>
        <%=request.getParameter("city")%><br>
        <%=request.getParameter("state")%><br>
        <%=request.getParameter("zip")%></p><br>
        <p>Credit Card Number:<br>
        <%=request.getParameter("CC")%></p>
    </div>
    <table>
        <tr>
            <th>Item</th>
            <th>Desc</th>
            <th>Size</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <%
            double totalPrice = 0;
            int totalQuantity = 0;
            for (int i = 0; i < shoppingCart.size(); i++) {
                ShoppingCartItem item = shoppingCart.get(i);
                totalPrice += item.getItem().getItemPrice()*item.getQuantity();
                totalQuantity += item.getQuantity();
        %>
        <tr>
            <td><img src="resources_web/<%=item.getItem().getImageFilename()%>"></td>
            <td><%=item.getItem().getItemName()%></td>
            <td><%=item.getSize()%></td>
            <td><%=item.getQuantity()%></td>
            <td><%=df.format(item.getItem().getItemPrice()*item.getQuantity())%></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td><b>Totals:</b></td>
            <td></td>
            <td></td>
            <td><%=totalQuantity%></td>
            <td><%=df.format(totalPrice)%></td>
            <td></td>
            <td><form name="checkout" action="Checkout" method="post">
                <input type="hidden" name="Order" value="order">
                <input class="buttons" type="submit" value="Submit Order">
            </form></td>
        </tr>
    </table>
    <%
        Order order = new Order(request.getParameter("fname"), request.getParameter("lanem"), request.getParameter("addr"),
                request.getParameter("city"), request.getParameter("state"), Integer.parseInt(request.getParameter("zip")),
                request.getParameter("CC"), totalPrice);
    %>

</body>
</html>
