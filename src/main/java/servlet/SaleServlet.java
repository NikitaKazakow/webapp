package servlet;

import entity.CarEntity;
import entity.ClientEntity;
import entity.SaleEntity;
import service.ClientService;
import service.SaleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SaleServlet extends HttpServlet {
    private static final SaleService saleService = new SaleService();
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
                            List<CarEntity> carEntityList = saleService.getMotSoledCars();
                            List<ClientEntity> clientEntityList = clientService.getAll();

                            if (carEntityList.size() > 0) {
                                req.setAttribute("error", "0");
                                req.setAttribute("carList", carEntityList);
                                req.setAttribute("clientList", clientEntityList);
                            }
                            else {
                                req.setAttribute("error", "1");
                            }
                            req.getRequestDispatcher("/addSale.jsp").forward(req, resp);
                        }
                        else
                            resp.sendError(400, "Неверные параметры запроса!");
                        break;
                    case "delete":
                        if (params.hasMoreElements() && params.nextElement().equals("id")
                                && reqParamMap.get("id").length == 1
                                && params.hasMoreElements()
                                && params.nextElement().equals("vin")
                                && reqParamMap.get("vin").length == 1
                                && !params.hasMoreElements()) {
                            String saleId = reqParamMap.get("id")[0];
                            String saleVin = reqParamMap.get("vin")[0];
                            String login = (String)req.getSession().getAttribute("login");

                            if (saleService.isSaleExists(saleVin, login, saleId)) {
                                saleService.delete(saleVin, login, saleId);

                                List<SaleEntity> saleEntityList = saleService.getAll();

                                req.setAttribute("saleList", saleEntityList);
                                req.getRequestDispatcher("/mainSale.jsp").forward(req, resp);
                            }
                            else
                                resp.sendError(400, "Нет такой записи в БД!");
                        }
                        break;
                    case "edit":
                        if (params.hasMoreElements()
                                && params.nextElement().equals("vin")
                                && reqParamMap.get("vin").length == 1
                                && params.hasMoreElements() && params.nextElement().equals("id")
                                && reqParamMap.get("id").length == 1) {
                            String clientId = reqParamMap.get("id")[0];
                            String vinNumberCar = reqParamMap.get("vin")[0];
                            String login = (String)req.getSession().getAttribute("login");
                            Optional<SaleEntity> saleEntityOptional = saleService.get(vinNumberCar, clientId, login);
                            if (saleEntityOptional.isPresent()) {
                                SaleEntity saleEntity = saleEntityOptional.get();
                                List<CarEntity> carEntityList = saleService.getMotSoledCars();
                                carEntityList.add(saleEntity.getCarByVinNumberCarFk());

                                List<ClientEntity> clientEntityList = clientService.getAll();

                                req.setAttribute("carList", carEntityList);
                                req.setAttribute("clientList", clientEntityList);
                                req.setAttribute("sale", saleEntity);
                                req.getRequestDispatcher("/editSale.jsp").forward(req, resp);
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
            List<SaleEntity> saleEntityList = saleService.getAll();
            req.setAttribute("saleList", saleEntityList);
            req.getRequestDispatcher("/mainSale.jsp").forward(req, resp);
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

                Integer payment = null;
                String vinNumber = req.getParameter("vin");
                String passportNumber =  req.getParameter("id");
                String login =  (String)req.getSession().getAttribute("login");

                try {
                    payment = Integer.parseInt(req.getParameter("pay"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (vinNumber != null
                        && passportNumber != null
                        && login != null
                        && payment != null) {
                    SaleEntity saleEntity = new SaleEntity();

                    saleEntity.setVinNumberCarFk(vinNumber);
                    saleEntity.setPassportNumberClientFk(passportNumber);
                    saleEntity.setLoginUserSaleFk(login);
                    saleEntity.setPaymentAmount(payment);

                    switch (action) {
                        case "add":
                            saleEntity.setDateSale();
                            if (saleService.isSaleExists(vinNumber, login, passportNumber)) {
                                req.setAttribute("error", "1");
                                req.setAttribute("sale", saleEntity);
                                req.getRequestDispatcher("/addSale.jsp").forward(req, resp);
                            }
                            else {
                                saleService.add(saleEntity);

                                List<SaleEntity> clientEntityList = saleService.getAll();

                                req.setAttribute("saleList", clientEntityList);
                                req.getRequestDispatcher("/mainSale.jsp").forward(req, resp);
                            }
                            break;
                        case "edit":
                            String strDate = req.getParameter("date");
                            if (strDate != null) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = null;
                                try {
                                    date = sdf.parse(strDate);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(Objects.requireNonNull(date));

                                saleEntity.setDateSale(cal);
                            }
                            else
                                resp.sendError(400, "Неверные параметры запроса!");

                            if (saleService.isSaleExists(vinNumber, login, passportNumber)) {
                                saleService.update(saleEntity);

                                List<SaleEntity> clientEntityList = saleService.getAll();

                                req.setAttribute("saleList", clientEntityList);
                                req.getRequestDispatcher("/mainSale.jsp").forward(req, resp);
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
