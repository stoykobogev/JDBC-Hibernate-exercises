package org.softuni.fdmc.servlets.orders;

import org.softuni.fdmc.utils.Authorizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/all")
public class OrdersAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Authorizator.validateAdminAndDispatch(req, resp, "allOrders.jsp");
    }
}
