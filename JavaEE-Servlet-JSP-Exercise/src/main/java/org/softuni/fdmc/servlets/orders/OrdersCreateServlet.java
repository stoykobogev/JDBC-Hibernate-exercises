package org.softuni.fdmc.servlets.orders;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.OrderRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/create")
public class OrdersCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getParameter("catName");

        CatRepository catRepository = (CatRepository) this.getServletContext().getAttribute("cats");
        UserRepository userRepository = (UserRepository) this.getServletContext().getAttribute("users");
        OrderRepository orderRepository = (OrderRepository) this.getServletContext().getAttribute("orders");

        Cat cat = catRepository.getByName(catName);
        User user = userRepository.getByUsername((String) req.getSession().getAttribute("username"));
        Order order = new Order(user, cat);

        orderRepository.addOrder(order);

        req.getRequestDispatcher("orderSuccessful.jsp").forward(req, resp);
    }
}
