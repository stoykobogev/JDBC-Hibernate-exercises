<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.utils.Authorizator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
    <h1>All Cats</h1>
    <hr />
    <%  CatRepository catRepository = (CatRepository) application.getAttribute("cats");
        List<Cat> catList = catRepository.getAllCatsSortedByViews();
        if (catList.isEmpty()) { %>
            <h2>There are no cats.
                <% if (Authorizator.validateAdmin(session)) { %>
                    <a href="/cats/create">Create some!</a>
                <%}%>
            </h2>
    <%  } else {
            for(Cat cat : catList) { %>
                <h3>
                    <a href="/cats/profile?catName=<%= cat.getName()%>"><%= cat.getName()%></a>
                </h3>
        <%  } %>
    <%  } %>
    <br />
    <a href="/">Back to Home</a>
</body>
</html>
