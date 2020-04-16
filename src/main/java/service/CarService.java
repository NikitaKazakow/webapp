package service;

import dao.impl.CarDaoImpl;
import entity.CarEntity;

import java.util.List;
import java.util.Optional;

public class CarService {

    private static final CarDaoImpl carDao = new CarDaoImpl();

    public List<CarEntity> getAll() {
        return carDao.getAll();
    }

    public List<CarEntity> getAll(String[] orderByValues, String[] orderDirectionValues) {
        return carDao.getAll(orderByValues, orderDirectionValues);
    }

    public void add(CarEntity carEntity) {
        carDao.save(carEntity);
    }

    public Optional<CarEntity> get(String vinNumber) {
        return carDao.get(vinNumber);
    }

    public boolean delete(String vinNumber) {
        Optional<CarEntity> carEntity = carDao.get(vinNumber);
        if (carEntity.isPresent()) {
            carDao.delete(carEntity.get());
            return true;
        }
        else
            return false;
    }

    public boolean update(CarEntity carEntity) {
        Optional<CarEntity> carEntityOptional = carDao.get(carEntity.getVinNumberCar());
        if (carEntityOptional.isPresent()) {
            carDao.update(carEntity);
            return true;
        }
        else
            return false;
    }

    public List<CarEntity> findByAll(String value) {
        return carDao.filterByAll("%" + value + "%");
    }

    public List<CarEntity> findByAllWithOrder(String searchValue, String[] orderByValues, String[] orderDirectionValues) {
        return carDao.filterByAll(searchValue, orderByValues, orderDirectionValues);
    }

    public boolean isCarExist(String vinNumber) {
        return carDao.get(vinNumber).isPresent();
    }
}
