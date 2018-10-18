<%@ page import="org.softuni.fdmc.utils.Authorizator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
    <h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>
    <% String username = (String) session.getAttribute("username"); %>
    <%=username == null
             ? "<h3>Login if you have an account, or Register if you don't!</h3>"
             : "<h3>Navigate through the application using the links below!</h3>"
    %>
    <hr/>
    <% if (username == null) { %>
        <a href="/users/login">Login</a>
        <br/>
        <a href="/users/register">Register</a>
    <% } else { %>
    <% if (Authorizator.validateAdmin(session)) { %>
            <a href="/cats/create">Create Cat</a>
            <br/>
            <a href="/orders/all">All Orders</a>
            <br/>
    <%  } %>
        <a href="/cats/all">All Cats</a>
        <br/>
        <a href="/users/logout">Logout</a>
    <% } %>
</body>
</html>
