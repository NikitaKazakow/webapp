package servlet;

import entity.CarEntity;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CarServlet extends HttpServlet {

    private final static CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("vin");
        if (action != null) {
            if (!action.equals("all")) {
                Optional<CarEntity> car = carService.get(action);
                car.ifPresent(carEntity -> req.setAttribute("updateCar", carEntity));
                req.getRequestDispatcher("/car/editCar.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("/car/mainCar.jsp").forward(req, resp);
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

                    carService.add(car);
                }

                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("/car/mainCar.jsp").forward(req, resp);

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
                    req.getRequestDispatcher("/car/mainCar.jsp").forward(req, resp);

                }
                break;
            case "delete":
                vinNumber = req.getParameter("vin");
                if (vinNumber != null) {
                    carService.delete(vinNumber);
                }
                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("/car/mainCar.jsp").forward(req, resp);
                break;
            case "info":
            default:
                req.setAttribute("carList", carService.getAll());
                req.getRequestDispatcher("car/mainCar.jsp").forward(req, resp);
                break;
        }
    }
}
