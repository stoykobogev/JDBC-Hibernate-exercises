package org.softuni.fdmc.servlets.users;

import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserRepository userRepo = (UserRepository)
                this.getServletContext()
                .getAttribute("users");

        User user = userRepo.getByUsername(username);

        if (!userRepo.isValidCredentials(username, password)) {
            resp.sendRedirect("/users/login");
            return;
        }

        req.getSession().setAttribute("username", user.getUsername());
        req.getSession().setAttribute("role", user.getRole());

        resp.sendRedirect("/");
    }
}
