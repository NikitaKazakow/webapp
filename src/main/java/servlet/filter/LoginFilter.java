package servlet.filter;

import service.UserService;
import util.PasswordEncryption;

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

        if (request.getRequestURI().matches("\\S*/resources/\\S*") ||
                (request.getRequestURI().matches("\\S*/registration\\S*"))) {
            filterChain.doFilter(request, response);
        } else {
            if (session.getAttribute("login") != null && session.getAttribute("password") != null) {
                filterChain.doFilter(request, response);
            } else {
                String login = request.getParameter("login");
                String password = request.getParameter("password");

                if (login != null && password != null) {
                    if (userService.isUserExists(login) && userService.checkPassword(login, password)) {
                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("password", PasswordEncryption.crypt(password));
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                    else {
                        request.setAttribute("error", "1");
                        request.setAttribute("login", login);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }
                else {
                    request.setAttribute("error", "0");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }
    }
}
