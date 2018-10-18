<%@ page import="org.softuni.fdmc.constants.RoleConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Register!</h1>
<br/>
    <form method="post" action="/users/register">
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        Confirm Password: <input type="password" name="confirmPassword" /><br/>
        Role: <select name="role">
                <option value="<%=RoleConstants.ADMIN_ROLE%>"><%=RoleConstants.ADMIN_ROLE%></option>
                <option value="<%=RoleConstants.USER_ROLE%>"><%=RoleConstants.USER_ROLE%></option>
              </select>
        <br/>
        <button type="submit">Register</button>
    </form>
    <br/>
    <a href="/">Back to Home</a>
</body>
</html>
