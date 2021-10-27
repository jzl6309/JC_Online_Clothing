<%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 10/13/21
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.jcclothing.Item" %>
<%@ page import="java.sql.Array" %>
<%@ page import="com.example.jcclothing.CatalogService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.DecimalFormat" %>
<%
    DecimalFormat df = new DecimalFormat("$#,###.00");
    ArrayList<Item> catalog = (ArrayList<Item>) request.getAttribute("catalog");
%>
<!DOCTYPE html>
<html>
<head>
    <title>JC Clothing - Catalog</title>
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
        .catalogItems {
            position: relative;
            float: left;
            padding-left: 400px;
        }
        .optionsPane {
            position: fixed;
            left: 0;
            background-color: black;
            color: white;
            width: 200px;
        }
        #bottom {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<ul class="group1">
    <li id="item1"><a href="index.jsp"><img id="logo" src="resources_web/logo.png"/></a></li>
    <li><a href="Catalog">CATALOG</a></li>
    <li><a href="/">TRACK ORDER</a></li>
    <li><a href="/">CONTACT US</a></li>
    <li><form id="searchBox" action="Catalog" method="post">
        <input type="text" name="searchBox">
        <input id="searchImage" type="image" src="resources_web/searchIcon.png" height="21px" width="21px">
        <input type="hidden" name="filter" value="search">
    </form> </li>
    <li><form id="AccountLogin" action="AccountLoginServlet" method="post">
        <input type="image" src="resources_web/login.png" height="21px" width="21px">
    </form></li>
    <li><form id="ShoppingCartIcon" action="ShoppingCart.jsp" method="post">
        <input type="image" src="resources_web/shoppingCart.png" height="21px" width="21px">
    </form></li>
</ul>
<br>
<div class="optionsPane">
    <p><b>Department</b></p>
    <form action="Catalog" method="post">
        <label>Men's</label>
        <input type="hidden" name="filter" value="mens">
    </form>
    <p>Sorts</p><br><br>
    <p>Filters</p><br><br>
    <p>etc...</p><br><br>
</div>
<div class="catalogItems">
        <%
            for (int i = 0; i < catalog.size(); i++) {
                Item item = catalog.get(i);
                String source = "resources_web/" + item.getImageFilename();
                out.println(item.getItemName() + " - " + item.getItemColor() + "<br>");
                %><form id=<%=item.getItemID()%> action="ItemDetails" method="post">
                    <input type="image" src="<%=source%>" width="150px" height="150px">
                    <input type="hidden" name="id" value="<%=item.getItemID()%>">
                </form>
                <%
                out.println("<br>" + df.format(item.getItemPrice()) + "<br><br>");
            }
        %>
</div>
</head>
<div style="text-align: center"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>
