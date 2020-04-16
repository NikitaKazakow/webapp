package servlet;

import entity.ComplectationEntity;
import entity.SpecificationEntity;
import service.ComplectationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ComplectationServlet extends HttpServlet {
    private static  final ComplectationService complectationService = new ComplectationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> reqParamMap = req.getParameterMap();
        Enumeration<String> params = req.getParameterNames();

        String paramName = params.nextElement();
        if (paramName.equals("vin") && !params.hasMoreElements() && reqParamMap.get("vin").length == 1) {
            String vinValue = reqParamMap.get("vin")[0];
            List<ComplectationEntity> complectations = complectationService.getAll(vinValue);

            req.setAttribute("vin", vinValue);
            req.setAttribute("complectaionList", complectations);
            req.getRequestDispatcher("/mainComplectation.jsp").forward(req, resp);
        }
        else if (paramName.equals("action") && reqParamMap.get("action").length == 1 &&
                params.hasMoreElements() && params.nextElement().equals("vin") &&
                reqParamMap.get("vin").length == 1) {
            String action = reqParamMap.get("action")[0];
            switch (action) {
                case "edit":
                    if (params.hasMoreElements() && params.nextElement().equals("name") && reqParamMap.get("name").length == 1) {
                        String vin = reqParamMap.get("vin")[0];
                        String nameSpecification = reqParamMap.get("name")[0];
                        if (nameSpecification != null && vin != null) {
                            Optional<ComplectationEntity> complectationEntity = complectationService.get(vin, nameSpecification);
                            if (complectationEntity.isPresent()) {
                                req.setAttribute("complectation", complectationEntity.get());
                                req.getRequestDispatcher("/editComplectation.jsp").forward(req, resp);
                            }
                            else
                                resp.sendError(400, "Неверные парамаетры запроса");
                        }
                        else
                            resp.sendError(400, "Неверные парамаетры запроса");
                    }
                    break;
                case "delete":
                    if (params.hasMoreElements() && params.nextElement().equals("name") && reqParamMap.get("name").length == 1) {
                        String vin = reqParamMap.get("vin")[0];
                        String nameSpecification = reqParamMap.get("name")[0];
                        if (nameSpecification != null && vin != null) {

                            complectationService.delete(vin, nameSpecification);

                            List<ComplectationEntity> complectations = complectationService.getAll(vin);

                            req.setAttribute("vin", vin);
                            req.setAttribute("complectaionList", complectations);
                            req.getRequestDispatcher("/mainComplectation.jsp").forward(req, resp);
                        }
                        else
                            resp.sendError(400, "Неверные парамаетры запроса");
                    }
                    break;
                case "add":
                    String vin = reqParamMap.get("vin")[0];
                    if (vin != null) {
                        req.setAttribute("vin", vin);
                        req.setAttribute("error", "0");
                        req.getRequestDispatcher("/addComplectation.jsp").forward(req, resp);
                    }
                    else
                        resp.sendError(400, "Неверные парамаетры запроса");
                    break;
                default:
                    resp.sendError(400, "Неверные парамаетры запроса");
            }
        }
        else
            resp.sendError(400, "Неверные парамаетры запроса");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String[]> reqParamMap = req.getParameterMap();
        Enumeration<String> params = req.getParameterNames();

        String paramName = params.nextElement();

        if (paramName.equals("action") && reqParamMap.get("action").length == 1 &&
                params.hasMoreElements()) {
            String action = reqParamMap.get("action")[0];

            String vinNumber = req.getParameter("vin");
            String nameComplectation = req.getParameter("name");
            Integer priceComplectation = null;
            try {
                priceComplectation = Integer.parseInt(req.getParameter("price"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            String bodyType = req.getParameter("body");
            String driveType = req.getParameter("drive");
            Integer doorsCount = null;
            Integer cylinderCount = null;
            Integer power = null;
            try {
                doorsCount = Integer.parseInt(req.getParameter("price"));
                cylinderCount = Integer.parseInt(req.getParameter("cylinder"));
                power = Integer.parseInt(req.getParameter("power"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            String engineType = req.getParameter("engine");
            String gearBox = req.getParameter("gearbox");

            if (vinNumber != null
                    && nameComplectation != null
                    && priceComplectation != null
                    && bodyType != null
                    && driveType != null
                    && doorsCount != null
                    && cylinderCount != null
                    && power != null
                    && engineType != null
                    && gearBox != null) {
                SpecificationEntity specificationEntity = new SpecificationEntity();

                specificationEntity.setGearBoxTypeSpecification(gearBox);
                specificationEntity.setEngineTypeSpecification(engineType);
                specificationEntity.setEnginePowerSpecification(power);
                specificationEntity.setEngineCylinderCountSpecification(cylinderCount);
                specificationEntity.setDriveTypeSpecification(driveType);
                specificationEntity.setBodyTypeSpecification(bodyType);
                specificationEntity.setDoorsCountSpecification(doorsCount);

                ComplectationEntity complectationEntity = new ComplectationEntity();

                complectationEntity.setNameComplectation(nameComplectation);
                complectationEntity.setPriceComplectation(priceComplectation);
                complectationEntity.setVinNumberCarFk(vinNumber);
                complectationEntity.setSpecification(specificationEntity);

                switch (action) {
                    case "add":
                        if (complectationService.add(complectationEntity)) {
                            List<ComplectationEntity> complectations = complectationService.getAll(vinNumber);

                            req.setAttribute("vin", vinNumber);
                            req.setAttribute("complectaionList", complectations);
                            req.getRequestDispatcher("/mainComplectation.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("vin", vinNumber);
                            req.setAttribute("error", "1");
                            req.getRequestDispatcher("/addComplectation.jsp").forward(req, resp);
                        }
                        break;
                    case "update":
                        if (complectationService.update(complectationEntity)) {
                            List<ComplectationEntity> complectations = complectationService.getAll(vinNumber);

                            req.setAttribute("vin", vinNumber);
                            req.setAttribute("complectaionList", complectations);
                            req.getRequestDispatcher("/mainComplectation.jsp").forward(req, resp);
                        }
                        break;
                }
            }
            else
                resp.sendError(400, "Неверные парамаетры запроса");
        }
        else
            resp.sendError(400, "Неверные парамаетры запроса");
    }
}
