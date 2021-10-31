<%@ page import="com.example.jcclothing.Item" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/15/21
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Item item = (Item) request.getAttribute("item");
    DecimalFormat df = new DecimalFormat("$#,###.##");
%>
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
    <title>Item Details</title>
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
<h1>Item Details</h1>
    <table>
        <tr>
            <th>Details</th>
            <th>Size</th>
            <th>Quantity</th>
        </tr>
        <tr>
            <td>
            <%String source = "resources_web/" + item.getImageFilename();%>
            <%=item.getItemName() + " - " + item.getItemColor()%><br>
            <img src="<%=source%>" width="150px" height="150px"><br>
            <%=df.format(item.getItemPrice())%><br><br></td>
            <form action="ShoppingCart" method="post">
                <td>
                    <select name="size" id="size">
                        <option value="L">L</option>
                        <option value="M">M</option>
                        <option value="S">S</option>
                    </select>
                </td>
                    <input type="hidden" name="item" value="<%=item.getItemID()%>">
                <td><input type="number" name="quantity" value="1" size="3"></td>
                <td><input class="buttons" type="submit" value="Add to Cart"></td>
            </form>
        </tr>
    </table>
<div style="text-align: center"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>
