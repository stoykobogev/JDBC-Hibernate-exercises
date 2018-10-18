package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.constants.RoleConstants;
import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.UserRepository;
import org.softuni.fdmc.utils.Authorizator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Authorizator.validateAdminAndDispatch(req, resp, "createCat.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User creator = ((UserRepository)this.getServletContext().getAttribute("users"))
                .getByUsername(req.getSession().getAttribute("username").toString());

        if (!RoleConstants.ADMIN_ROLE.equals(creator.getRole())) {
            resp.setStatus(401);
            req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer numberOfLegs = Integer.parseInt(req.getParameter("numberOfLegs"));

        Cat cat = new Cat(name, breed, color, numberOfLegs, creator);

        ((CatRepository)this.getServletContext().getAttribute("cats")).addCat(cat);

        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}
