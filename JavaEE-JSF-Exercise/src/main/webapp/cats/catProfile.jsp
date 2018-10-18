<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
    <% String catName = request.getParameter("catName"); %>
    <% Cat cat = ((CatRepository) application.getAttribute("cats")).getByName(catName); %>
    <% if(cat != null) {
        cat.incrementViews(); %>
    <h1>Cat - <%=cat.getName()%></h1>
    <hr />
    <h3>Breed: <%= cat.getBreed()%></h3>
    <h3>Color: <%= cat.getColor()%></h3>
    <h3>Number Of Legs: <%= cat.getNumberOfLegs()%></h3>
    <h3>Views: <%= cat.getViews()%></h3>
    <h3>Creator: <%= cat.getCreator().getUsername()%></h3>
    <hr />
    <form method="post" action="/orders/create?catName=<%=cat.getName()%>">
        <button type="submit">Order</button>
    </form>
    <% } else { %>
    <h1>Cat, with name <%=catName%> was not found.</h1>
    <% } %>
    <br />
<a href="/cats/all">Back</a>
</body>
</html>
