<%@ page import="com.example.jcclothing.AuthenticateService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JC Clothing - Home Page</title>
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
        #image1 {
            width: available;
        }
        #image2 {
            width: available;
        }
        #image3 {
            width: available;
        }
        #AccountLogin {
            padding: 20px 20px;
        }
        #ShoppingCartIcon {
            padding: 20px 5px;
        }
        #discount {
            padding: 20px 10px;
            font-size: x-large;
            font-weight: bold;
        }
        #discount1 {
            padding: 20px 10px;
            font-size: larger;
            font-style: italic;
        }
        .catalogButtons {
            font-family: Verdana, sans-serif;
            font-size: 1.2rem;
            list-style-type: none;
            height: 175px;
            margin: 0;
            padding: 100px 170px;
            overflow: hidden;
        }
        .catalogButtons li {
            float: left;
        }
        #bottom{
            padding-top: 50px;
        }
    </style>
</head>
<body>
<ul class="group1">
    <li id="item1"><a href="index.jsp"><img id="logo" src="resources_web/logo.png"/></a></li>
    <li><a href="Catalog">CATALOG</a></li>
    <li><a href="TrackOrder">TRACK ORDER</a></li>
    <li><a href="Contact.jsp">CONTACT US</a></li>
    <li><form id="searchBox" action="Catalog" method="post">
        <input type="text" name="searchBox">
        <input id="searchImage" type="image" src="resources_web/searchIcon.png" height="21px" width="21px">
        <input type="hidden" name="filter" value="search">
    </form> </li>
    <li>
        <form id="AccountLogin" action="AccountLoginServlet" method="post">
        <input type="image" src="resources_web/login.png" height="21px" width="21px">
    </form></li>
    <li><form id="ShoppingCartIcon" action="ShoppingCart.jsp" method="post">
        <input type="image" src="resources_web/shoppingCart.png" height="21px" width="21px">
    </form></li>
</ul>

<div style="text-align: center;"><img id="image1" src="resources_web/HomePageImage1.png"/></div>
<div id="discount" style="text-align: center;">20% Discount</div>
<div id="discount1" style="text-align: center">Enter "Bait" at checkout!</div>
<div style="text-align: center;"><img id="image3" src="resources_web/HomePageImage3.png"/></div>

<ul class="catalogButtons">
    <li><form id="mensButton" action="Catalog" method="post">
        <input type="hidden" name="filter" value="mens">
        <input type="image" src="resources_web/mensButton.jpg">
    </form> </li>
    <li><form id="womensButton" action="Catalog" method="post">
        <input type="hidden" name="filter" value="womens">
        <input type="image" src="resources_web/womensButton.jpg">
    </form></li>
</ul>


<div style="text-align: center;"><img id="image2" src="resources_web/HomePageImage2.png"/></div>
<div style="text-align: center"><img id="bottom" src="resources_web/bottom.jpg"/></div>
</body>
</html>