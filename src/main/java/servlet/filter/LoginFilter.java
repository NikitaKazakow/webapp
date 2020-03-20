package servlet.filter;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private static final UserService userService = new UserService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();

        if (request.getRequestURI().matches("\\S*/resources/\\S*") || request.getRequestURI().equals("/logout")) {
            filterChain.doFilter(request, response);
        } else {
            if (session != null &&
                    session.getAttribute("login") != null &&
                    session.getAttribute("password") != null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if (userService.isUserExists(login, password)) {
                    request.getSession().setAttribute("login", login);
                    request.getSession().setAttribute("password", password);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }
    }
}
