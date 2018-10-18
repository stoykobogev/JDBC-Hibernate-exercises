<%@ page import="data.Cat" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>
    <h1>All Cats</h1>
    <hr/>
    <%  Map<String, Cat> catMap = (Map<String, Cat>) request.getServletContext().getAttribute("cats");
        if (catMap == null || catMap.isEmpty()) { %>
            <h2>There are no cats. <a href="/cats/create">Create some!</a></h2>
    <%  } else {
            for (Cat cat : catMap.values()) { %>
                <h3><a href="/cats/profile?catName=<%=cat.getName()%>"><%=cat.getName()%></a></h3>
            <% } %>
    <% } %>
    <a href="/">Back To Home</a>
</body>
</html>
