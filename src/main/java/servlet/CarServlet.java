package servlet;

import entity.CarEntity;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

public class CarServlet extends HttpServlet {

    private final static CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> reqParamMap = req.getParameterMap();
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String [] paramValues;
            switch (paramName) {
                case "vin":
                    if (params.hasMoreElements()) {
                        String orderByName = params.nextElement();
                        String [] orderByValues = reqParamMap.get(orderByName);
                        if (params.hasMoreElements()) {
                            String orderDirectionName = params.nextElement();
                            String [] orderDirectionValues = reqParamMap.get(orderDirectionName);
                            if (orderByName.equals("orderBy") && orderDirectionName.equals("direction") &&
                                    orderDirectionValues.length > 0 && orderByValues.length == orderDirectionValues.length) {
                                req.setAttribute("carList",
                                        carService.getAll(orderByValues, orderDirectionValues));
                                req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                            }
                            else {
                                //TODO BadRequest
                            }
                        }
                    }
                    else {
                        paramValues = reqParamMap.get(paramName);
                        if (paramValues.length > 1) {
                            //TODO BadRequest
                        }
                        else {
                            if (paramValues[0].equals("all")) {
                                req.setAttribute("carList", carService.getAll());
                                req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                            }
                            else {
                                Optional<CarEntity> car = carService.get(paramValues[0]);
                                car.ifPresent(carEntity -> req.setAttribute("updateCar", carEntity));
                                req.getRequestDispatcher("/editCar.jsp").forward(req, resp);
                            }
                        }
                    }
                    break;
                case "find":
                    String [] findValues = reqParamMap.get("find");
                    if (params.hasMoreElements() && findValues.length == 1) {
                        String orderByName = params.nextElement();
                        String [] orderByValues = reqParamMap.get(orderByName);
                        if (params.hasMoreElements()) {
                            String orderDirectionName = params.nextElement();
                            String [] orderDirectionValues = reqParamMap.get(orderDirectionName);
                            if (orderByName.equals("orderBy") && orderDirectionName.equals("direction") &&
                                    orderDirectionValues.length > 0 && orderByValues.length == orderDirectionValues.length) {
                                req.setAttribute("findValue", findValues[0]);
                                req.setAttribute("carList",
                                        carService.findByAllWithOrder(findValues[0], orderByValues, orderDirectionValues));
                                req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                            }
                            else {
                                //TODO BadRequest
                            }
                        }
                    }
                    else if (findValues.length == 1){
                        req.setAttribute("carList", carService.findByAll(findValues[0]));
                        req.setAttribute("findValue", findValues[0]);
                        req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                    }
                    else {
                        //TODO BadRequest
                    }
                    break;
                case "action":
                    String [] actionValues = reqParamMap.get("action");
                    if (actionValues.length == 1 && actionValues[0].equals("add")) {
                        req.setAttribute("error", "0");
                        req.getRequestDispatcher("/addCar.jsp").forward(req, resp);
                    }
                    else {
                        //TODO Bad request
                    }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action == null ? "info" : action) {
            case "add":
                String vinNumber = req.getParameter("vin");
                String colour = req.getParameter("colour");
                String country = req.getParameter("country");
                String model = req.getParameter("model");
                String mark = req.getParameter("mark");
                Integer year = null;
                try {
                    year = Integer.parseInt(req.getParameter("year"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (vinNumber != null && colour != null && country != null && mark != null && model != null && year != null) {
                    CarEntity car = new CarEntity();

                    car.setVinNumberCar(vinNumber);
                    car.setColourCar(colour);
                    car.setManufactureCountry(country);
                    car.setModelCar(model);
                    car.setMarkCar(mark);
                    car.setYearOfIssueCar(year);

                    if (carService.isCarExist(vinNumber)) {
                        req.setAttribute("error", "1");
                        req.setAttribute("car", car);
                        req.getRequestDispatcher("/addCar.jsp").forward(req, resp);
                    }
                    else {
                        carService.add(car);

                        req.setAttribute("carList", carService.getAll());
                        req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                    }
                } else {
                    //TODO Bad request
                }
                break;
            case "update":
                vinNumber = req.getParameter("vin");
                colour = req.getParameter("colour");
                country = req.getParameter("country");
                model = req.getParameter("model");
                mark = req.getParameter("mark");
                year = null;

                try {
                    year = Integer.parseInt(req.getParameter("year"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (vinNumber != null && colour != null && country != null && mark != null && model != null && year != null) {

                    CarEntity car = new CarEntity();

                    car.setVinNumberCar(vinNumber);
                    car.setColourCar(colour);
                    car.setManufactureCountry(country);
                    car.setModelCar(model);
                    car.setMarkCar(mark);
                    car.setYearOfIssueCar(year);

                    carService.update(car);

                    req.setAttribute("carList", carService.getAll());
                    req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);

                }
                break;
            case "delete":
                vinNumber = req.getParameter("vin");
                if (vinNumber != null) {
                    carService.delete(vinNumber);
                }
                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                break;
            case "info":
            default:
                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("/mainCar.jsp").forward(req, resp);
                break;
        }
    }
}
