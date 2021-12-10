<%@ page import="com.example.jcclothing.StaffList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.jcclothing.Item" %>
<%@ page import="com.example.jcclothing.OrderHistory" %>
<%@ page import="java.sql.SQLException" %>
<%--
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
    td {
        padding: 15px;
    }
    .optionsPane {
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
<h1>Staff</h1>


<div class="optionsPane">
    <%
        if (request.getAttribute("options") == null) {
    %>
            <form action="EditStaff" method="post">
                <input type="hidden" name="options" value="add">
                <input class="buttons" type="submit" value="Add">
            </form>
            <form action="EditStaff" method="post">
                <input type="hidden" name="options" value="remove">
                <input class="buttons" type="submit" value="Remove">
            </form>
    <%
      }
      if (request.getAttribute("options") != null) {
         if (request.getAttribute("options").equals("add")) {
    %>
            <form action="EditStaff" method="post">
                <input name="fname" type="text" placeholder="First Name" required><br>
                <input name="lname" type="text" placeholder="Last Name" required><br>
                <input name="addr" type="text" placeholder="Street Address" required><br>
                <input name="city" type="text" placeholder="City" required><br>
                <input name="state" type="text" placeholder="State" required pattern="[A-Z]{1}[A-Za-z]{1}"
                       oninvalid="this.setCustomValidity('Please enter a valid state.')" oninput="this.setCustomValidity('')"><br>
                <input name="zip" type="text" placeholder="Zip" required pattern="\d{5}-?(\d{4})?"
                       oninvalid="this.setCustomValidity('Please enter a valid zip code.')" oninput="this.setCustomValidity('')"><br>
                <input name="username" type="text" placeholder="Username" required><br>
                <input name="email" type="email" placeholder="Email" required><br>
                Password will be set to temp123. Staff member should update it as soon as possible.<br>
                <input class="buttons" type="submit" value="Submit"><br>
                <input type="hidden" name="options" value="addStaff">
            </form>
            <% if (request.getAttribute("error") != null) { %>
            <p><%=request.getAttribute("error")%></p>
    <%
            }
    %>
            <form action="ListStaff.jsp" method="post">
                <input class="buttons" type="submit" value="Cancel">
            </form>
    <%
            }
         if (request.getAttribute("options").equals("remove")) {
    %>
            <form action="EditStaff" method="post">
                Enter the ID of the Staff Member. Their access will be changed to user access.
                <input type="text" name="ID" placeholder="Enter ID" required>
                <input type="hidden" name="options" value="removeStaff">
                <input class="buttons" type="submit" value="Submit">
            </form>
            <form action="ListStaff.jsp" method="post">
                <input class="buttons" type="submit" value="Cancel">
            </form>
    <%
         }
     }
    %>

</div>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Street Address</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
        <th></th>
    </tr>
    <%
        StaffList stafflist = new StaffList().getStaffNames();

        for (int i = 0; i < stafflist.StaffUsernames.size(); i++) {
    %>
    <tr>
        <td><%=stafflist.StaffID.get(i)%></td>
        <td><%=stafflist.StaffUsernames.get(i)%></td>
        <td><%=stafflist.StaffFnameArray.get(i)%></td>
        <td><%=stafflist.StaffLnameArray.get(i)%></td>
        <td><%=stafflist.StaffEmail.get(i)%></td>
        <td><%=stafflist.StaffAddr.get(i)%></td>
        <td><%=stafflist.StaffCity.get(i)%></td>
        <td><%=stafflist.StaffState.get(i)%></td>
        <td><%=stafflist.StaffZip.get(i)%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
