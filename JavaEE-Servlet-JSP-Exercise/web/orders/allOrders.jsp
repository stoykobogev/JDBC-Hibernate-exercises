<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<%  OrderRepository orderRepository = (OrderRepository) application.getAttribute("orders");
    List<Order> orderList = orderRepository.getAllOrdersSortedByDate();
    if (orderList.isEmpty()) { %>
        <h1>There are no orders!</h1>
        <br/>
        <a href="/">Back to Home</a>
<%  } else {
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); %>
        <h1>Orders:</h1>
        <br/>
        <a href="/">Back to Home</a>
        <hr/>
    <% for (Order order : orderList) { %>
        <h4>Client: <%=order.getClient().getUsername()%></h4>
        <h4>Cat: <%=order.getCat().getName()%></h4>
        <h4>Date and time: <%=order.getMadeOn().format(dtm)%></h4>
        <hr/>
    <% } %>
<% } %>
</body>
</html>
