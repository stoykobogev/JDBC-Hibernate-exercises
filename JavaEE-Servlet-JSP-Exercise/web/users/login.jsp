<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Login!</h1>
<br/>
    <form method="post" action="/users/login">
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        <button type="submit">Login</button>
    </form>
    <br/>
    <a href="/">Back to Home</a>
</body>
</html>
