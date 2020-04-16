package servlet;

import entity.ClientEntity;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClientServlet extends HttpServlet {
    private static final ClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> reqParamMap = req.getParameterMap();
        Enumeration<String> params = req.getParameterNames();

        if (params.hasMoreElements()) {
            String paramName = params.nextElement();
            if (paramName.equals("action") && reqParamMap.get("action").length == 1) {
                String actionValue = reqParamMap.get("action")[0];
                switch (actionValue) {
                    case "add":
                        if (!params.hasMoreElements()) {
                            req.setAttribute("error", "0");
                            req.getRequestDispatcher("/addClient.jsp").forward(req, resp);
                        }
                        else
                            resp.sendError(400, "Неверные параметры запроса!");
                        break;
                    case "delete":
                        if (params.hasMoreElements() && params.nextElement().equals("id")
                                && reqParamMap.get("id").length == 1) {
                            String clientId = reqParamMap.get("id")[0];
                            if (clientService.isClientExists(clientId)) {
                                clientService.delete(clientId);

                                List<ClientEntity> clientEntityList = clientService.getAll();

                                req.setAttribute("clientList", clientEntityList);
                                req.getRequestDispatcher("/mainClient.jsp").forward(req, resp);
                            }
                            else
                                resp.sendError(400, "Нет такой записи в БД!");
                        }
                        break;
                    case "edit":
                        if (params.hasMoreElements() && params.nextElement().equals("id")
                                && reqParamMap.get("id").length == 1) {
                            String clientId = reqParamMap.get("id")[0];
                            Optional<ClientEntity> clientEntityOptional = clientService.get(clientId);
                            if (clientEntityOptional.isPresent()) {
                                req.setAttribute("client", clientEntityOptional.get());
                                req.getRequestDispatcher("/editClient.jsp").forward(req, resp);
                            }
                            else
                                resp.sendError(400, "Нет такой записи в БД!");
                        }
                        break;
                    default:
                        resp.sendError(400, "Неверные параметры запроса!");
                }
            }
        }
        else {
            List<ClientEntity> clientEntityList = clientService.getAll();
            req.setAttribute("clientList", clientEntityList);
            req.getRequestDispatcher("/mainClient.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String[]> reqParamMap = req.getParameterMap();
        Enumeration<String> params = req.getParameterNames();

        if (params.hasMoreElements()) {
            String paramName = params.nextElement();
            if (paramName.equals("action") && reqParamMap.get("action").length == 1) {
                String action = reqParamMap.get("action")[0];

                String passportNumber = req.getParameter("id");
                String fullName =  req.getParameter("name");
                String address =  req.getParameter("address");
                String phoneNumber =  req.getParameter("phone");

                if (passportNumber != null
                        && fullName != null
                        && address != null
                        && phoneNumber != null) {
                    ClientEntity clientEntity = new ClientEntity();

                    clientEntity.setPassportNumber(passportNumber);
                    clientEntity.setFullNameClient(fullName);
                    clientEntity.setHomeAddressClient(address);
                    clientEntity.setPhoneNumberClient(phoneNumber);

                    switch (action) {
                        case "add":
                            if (clientService.isClientExists(passportNumber)) {
                                req.setAttribute("error", "1");
                                req.setAttribute("client", clientEntity);
                                req.getRequestDispatcher("/addClient.jsp").forward(req, resp);
                            }
                            else {
                                clientService.add(clientEntity);

                                List<ClientEntity> clientEntityList = clientService.getAll();

                                req.setAttribute("clientList", clientEntityList);
                                req.getRequestDispatcher("/mainClient.jsp").forward(req, resp);
                            }
                            break;
                        case "edit":
                            if (clientService.isClientExists(passportNumber)) {
                                clientService.update(clientEntity);

                                List<ClientEntity> clientEntityList = clientService.getAll();

                                req.setAttribute("clientList", clientEntityList);
                                req.getRequestDispatcher("/mainClient.jsp").forward(req, resp);
                            }
                            else
                                resp.sendError(400, "Нет такой записи в БД!");
                            break;
                        default:
                            resp.sendError(400, "Неверные параметры запроса!");
                    }
                }
                else
                    resp.sendError(400, "Неверные параметры запроса!");
            }
            else
                resp.sendError(400, "Неверные параметры запроса!");
        }
        else
            resp.sendError(400, "Неверные параметры запроса!");
    }
}
