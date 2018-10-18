package org.softuni.fdmc.utils;

import org.softuni.fdmc.constants.RoleConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class Authorizator {

    private Authorizator() {}

    public static boolean validateAdmin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        return RoleConstants.ADMIN_ROLE.equals(role);
    }

    public static void validateAdminAndDispatch(
            HttpServletRequest req,
            HttpServletResponse resp,
            String path
    ) throws ServletException, IOException {
        String role = (String) req.getSession().getAttribute("role");
        if (RoleConstants.ADMIN_ROLE.equals(role)) {
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            resp.setStatus(401);
            req.getRequestDispatcher("/unauthorized.jsp").forward(req, resp);
        }
    }
}
