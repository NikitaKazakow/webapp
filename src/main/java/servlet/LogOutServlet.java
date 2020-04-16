package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session.getAttribute("login") != null && session.getAttribute("password") != null) {
            session.removeAttribute("login");
            session.removeAttribute("password");
        }

        req.setAttribute("error", "0");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
