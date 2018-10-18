package servlets;

import data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/cat-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = new Cat(
                req.getParameter("name"),
                req.getParameter("breed"),
                req.getParameter("color"),
                Integer.valueOf(req.getParameter("legs-count")));

        Map<String, Cat> catMap = (Map<String, Cat>) req.getServletContext().getAttribute("cats");
        if (catMap == null) {
            catMap = new HashMap<>();
            req.getServletContext().setAttribute("cats", catMap);
        }

        catMap.put(cat.getName(), cat);

        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}
