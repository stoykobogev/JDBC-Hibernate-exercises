<%@ page import="data.Cat" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>
    <%
    String catName = request.getParameter("catName");
    Map<String, Cat> catMap = (Map<String, Cat>) request.getServletContext().getAttribute("cats");
    if (catName == null || catMap == null || !catMap.containsKey(catName)) {
    %>
    <h1>Cat with name - <%= catName %>was not found.</h1>
    <% } else {
        Cat cat = catMap.get(catName);
    %>
    <h1>Cat - <%=cat.getName()%></h1>
    <hr/>
    <h2>Breed: <%=cat.getBreed()%></h2>
    <h2>Color: <%=cat.getColor()%></h2>
    <h2>Number of legs: <%=cat.getNumberOfLegs()%></h2>
    <hr/>
    <% } %>
    <a href="/cats/all">Back</a>
</body>
</html>
