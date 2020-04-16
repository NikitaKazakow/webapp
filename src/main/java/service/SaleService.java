package service;

import dao.impl.CarDaoImpl;
import dao.impl.SaleDaoImpl;
import entity.CarEntity;
import entity.SaleEntity;
import entity.pk.SaleEntityPK;

import java.util.List;
import java.util.Optional;

public class SaleService {
    private static final SaleDaoImpl saleDao = new SaleDaoImpl();
    private static final CarDaoImpl carDao = new CarDaoImpl();

    public void addSale(SaleEntity sale) {

    }

    public List<SaleEntity> getAll() {
        return saleDao.getAll();
    }

    public boolean isSaleExists(String vin, String login, String id) {
        SaleEntityPK primaryKey = new SaleEntityPK();

        primaryKey.setLoginUserSaleFk(login);
        primaryKey.setPassportNumberClientFk(id);
        primaryKey.setVinNumberCarFk(vin);

        Optional<SaleEntity> saleEntityOptional = saleDao.get(primaryKey);

        return saleEntityOptional.isPresent();
    }

    public void delete(String vin, String login, String id) {
        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setLoginUserSaleFk(login);
        saleEntity.setPassportNumberClientFk(id);
        saleEntity.setVinNumberCarFk(vin);

        saleDao.delete(saleEntity);
    }

    public void add(SaleEntity saleEntity) {
        saleDao.save(saleEntity);
    }

    public void update(SaleEntity saleEntity) {
        saleDao.update(saleEntity);
    }

    public List<CarEntity> getMotSoledCars() {
        List<CarEntity> carEntityList = carDao.getAll();
        carEntityList.removeIf(car -> car.getSale() != null);

        return carEntityList;
    }

    public Optional<SaleEntity> get(String vin, String id, String login) {
        SaleEntityPK primaryKey = new SaleEntityPK();
        primaryKey.setVinNumberCarFk(vin);
        primaryKey.setPassportNumberClientFk(id);
        primaryKey.setLoginUserSaleFk(login);

        return saleDao.get(primaryKey);
    }
}
