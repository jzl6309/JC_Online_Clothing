<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.jcclothing.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jcclothing.AuthenticateService" %>
<%@ page import="com.example.jcclothing.User" %>
<%@ page import="static com.sun.beans.introspect.PropertyInfo.Name.required" %><%--
  Created by IntelliJ IDEA.
  User: nughufer
  Date: 11/2/21
  Time: 1:04 PM
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
        .catalogItems {
            float: left;
            top: 150px;
            padding-left: 200px;
        }
        .optionsPane {
            padding-top: 150px;
            float: left;
            width: 200px;
            height: 400px;
        }
        .buttons {
            background: black;
            color: white;
            height: 75px;
            width: 150px;
        }
        td {
            padding: 50px;
        }
    </style>
<head>
    <title>Edit Catalog</title>
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
<div class="optionsPane">
    <%
        if (request.getAttribute("options") != null ) {
            if (request.getAttribute("options").equals("add")) {
    %>
                <form action="EditCatalog" method="post">
                    <input type="text" name="itemName" placeholder="Item Name" required>
                    <input type="text" name="itemSex" placeholder="M-Male F-Female" required>
                    <input type="text" name="itemColor" placeholder="Item Color" required>
                    <input type="text" name="itemCost" placeholder="Item Cost" required>
                    <input type="text" name="itemImage" placeholder="Image Filename" required>
                    <input type="hidden" name="options" value="addItem">
                    <input class="buttons" type="submit" value="Submit" >
                </form>
                <form action="AccountServlet" method="post">
                    <input type="hidden" name="options" value="catalog">
                    <input class="buttons" type="submit" value="Cancel">
                </form>
    <%
            }
            else if (request.getAttribute("options").equals("edit")) {
                Item item = (Item) request.getAttribute("item");
    %>
                <form action="EditCatalog" method="post">
                    Enter the Number of the Item You Want to Edit
                    <input type="text" name="itemName" value="<%=item.getItemName()%>" required>
                    <input type="text" name="itemSex" value="<%=item.getItemSex()%>" required>
                    <input type="text" name="itemColor" value="<%=item.getItemColor()%>" required>
                    <input type="text" name="itemCost" value="<%=item.getItemPrice()%>" required>
                    <input type="text" name="itemImage" value="<%=item.getImageFilename()%>" required>
                    <input type="hidden" name="itemID" value="<%=item.getItemID()%>">
                    <input type="hidden" name="options" value="editItem">
                    <input class="buttons" type="submit" value="Submit">
                </form>
                <form action="AccountServlet" method="post">
                    <input type="hidden" name="options" value="catalog">
                    <input class="buttons" type="submit" value="Cancel">
                </form>
    <%
            }
        } else {
    %>
            <form action="EditCatalog" method="post">
                <input type="hidden" name="options" value="add">
                <input class="buttons" type="submit" value="Add">
            </form>
        <%
            if (AuthenticateService.user.getType() == User.ADMIN) {
        %>
            <form action="EditCatalog" method="post">
                <input type="text" name="itemID" placeholder="Enter Item Number" required>
                <input type="hidden" name="options" value="edit">
                <input class="buttons" type="submit" value="Edit">
            </form>
    <%
            }
        }
    %>
</div>
<div class="catalogItems">
    <table>
        <tr>
            <th></th>
            <th></th>
        </tr>
        <%
            DecimalFormat df = new DecimalFormat("$#,###.00");
            ArrayList<Item> catalog = (ArrayList<Item>) request.getAttribute("catalog");
            for (int i = 0; i < catalog.size(); i+=3) {
                Item item = catalog.get(i);
                String source = "resources_web/" + item.getImageFilename();

                Item item2 = null;
                String source2 = null;
                Item item3 = null;
                String source3 = null;
        %>
            <tr>
                <td><%=item.getItemID() + " " + item.getItemName() + " - " + item.getItemColor()%><br>
                    <img src="<%=source%>" width="150px" height="150px"><br>
                    <%=df.format(item.getItemPrice())%></td>
                <%
                    if (i+1 < catalog.size()) {
                        item2 = catalog.get(i+1);
                        source2 = "resources_web/" + item2.getImageFilename();
                %>
                <td><%=item2.getItemID() + " " + item2.getItemName() + " - " + item2.getItemColor()%><br>
                    <img src="<%=source2%>" width="150px" height="150px"><br>
                    <%=df.format(item2.getItemPrice())%>
                </td>
                <%
                    }
                    if (i+2 < catalog.size()) {
                        item3 = catalog.get(i+2);
                        source3 = "resources_web/" + item3.getImageFilename();
                %>
                <td><%=item3.getItemID() + " " + item3.getItemName() + " - " + item3.getItemColor()%><br>
                    <img src="<%=source3%>" width="150px" height="150px"><br>
                    <%=df.format(item3.getItemPrice())%>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
