<%@ page import="com.example.jcclothing.ShoppingCart" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jcclothing.ShoppingCartItem" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/25/21
  Time: 6:09 PM
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
    <title>Shopping Cart</title>
</head>
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
<body>
<%
    ShoppingCart cart = ShoppingCart.getInstance();
    ArrayList<ShoppingCartItem> shoppingCart = cart.getShoppingCart();
    DecimalFormat df = new DecimalFormat("$#,##0.00");
%>
<h1>Shopping Cart</h1>
    <table>
        <tr>
            <th>Item</th>
            <th>Desc</th>
            <th>Size</th>
            <th>Quantity</th>
            <th>Price</th>
            <th></th>
            <th></th>
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
            <form action="ShoppingCart" method="post">
            <td>
                <input name="quantity" type="number" size="3" value="<%=item.getQuantity()%>">
                <input type="hidden" name="updateItem" value="<%=item.getItem().getItemID()%>">
            </td>
            <td><%=df.format(item.getItem().getItemPrice()*item.getQuantity())%></td>
            <td><input class="buttons" type="submit" value="Update">
            </td></form>
             <form name="remove" action="ShoppingCart" method="post">
            <td><input class="buttons" type="submit" value="Remove"></td>
            <input type="hidden" name="removeItem" value="<%=item.getItem().getItemID()%>">
            </form>
        </tr>
    <%
        }
    %>
        <tr>
            <td></td>
            <td><b>Totals:</b></td>
            <td></td>
            <td><b><%=totalQuantity%></b></td>
            <td><b><%=df.format(totalPrice)%></b></td>
            <td></td>
    <%
        if (totalQuantity > 0) {
    %>
            <td><form name="checkout" action="Checkout.jsp" method="post">
                <input class="buttons" type="submit" value="Checkout">
            </form></td>
    <%
        }
    %>
        </tr>
    </table>
<div style="text-align: center"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>
