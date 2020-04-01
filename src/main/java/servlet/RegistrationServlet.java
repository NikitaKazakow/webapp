package servlet;

import entity.UserEntity;
import service.UserService;
import util.PasswordEncryption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RegistrationServlet extends HttpServlet {
    private static final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        if (login != null || password != null || password2 != null) {
            if (userService.isUserExists(login)) {
                req.setAttribute("state", 2);
                req.getRequestDispatcher("/registration.jsp").forward(req, resp);
            }
            else if (!Objects.equals(password, password2)) {
                req.setAttribute("state", 3);
                req.getRequestDispatcher("/registration.jsp").forward(req, resp);
            }
            else {
                UserEntity user = new UserEntity();
                user.setLoginUser(login);

                String cryptedPassword = PasswordEncryption.crypt(password);

                user.setPasswordUser(cryptedPassword);

                int state = userService.registryNewUser(user);

                if (state != 0) {
                    //TODO ошибка регистрации
                }
                else {
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }
        else {
            //TODO сообщение об ошибке
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}
