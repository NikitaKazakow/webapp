package service;

import dao.impl.CarDaoImpl;
import dao.impl.ComplectationDaoImpl;
import entity.ComplectationEntity;
import entity.pk.ComplectationEntityPK;

import java.util.List;
import java.util.Optional;

public class ComplectationService {
    private static final CarDaoImpl carDao = new CarDaoImpl();
    private static final ComplectationDaoImpl complectationDao = new ComplectationDaoImpl();

    public List<ComplectationEntity> getAll(String vinNumber) {
        return carDao.getComplectations(vinNumber);
    }

    public boolean delete(String vinNumber, String nameComplectation) {
        boolean result = false;

        ComplectationEntityPK primaryKey = new ComplectationEntityPK();
        primaryKey.setVinNumberCarFk(vinNumber);
        primaryKey.setNameComplectation(nameComplectation);

        Optional<ComplectationEntity> complectationEntityOptional = complectationDao.get(primaryKey);
        if (complectationEntityOptional.isPresent()) {
            ComplectationEntity complectationEntity = new ComplectationEntity();

            complectationEntity.setVinNumberCarFk(vinNumber);
            complectationEntity.setNameComplectation(nameComplectation);

            complectationDao.delete(complectationEntity);
            result = true;
        }
        return  result;
    }

    public boolean add(ComplectationEntity complectationEntity) {
        boolean result = false;

        ComplectationEntityPK primaryKey = new ComplectationEntityPK();
        primaryKey.setNameComplectation(complectationEntity.getNameComplectation());
        primaryKey.setVinNumberCarFk(complectationEntity.getVinNumberCarFk());

        if (!complectationDao.get(primaryKey).isPresent()) {
            complectationDao.save(complectationEntity);
            result = true;
        }
        return result;
    }

    public boolean update(ComplectationEntity complectationEntity) {
        boolean result = false;

        ComplectationEntityPK primaryKey = new ComplectationEntityPK();
        primaryKey.setNameComplectation(complectationEntity.getNameComplectation());
        primaryKey.setVinNumberCarFk(complectationEntity.getVinNumberCarFk());

        if (complectationDao.get(primaryKey).isPresent()) {
            complectationDao.update(complectationEntity);
            result = true;
        }
        return result;
    }

    public Optional<ComplectationEntity> get(String vinNumber, String nameComplectation) {
        ComplectationEntityPK primaryKey = new ComplectationEntityPK();
        primaryKey.setVinNumberCarFk(vinNumber);
        primaryKey.setNameComplectation(nameComplectation);
        return complectationDao.get(primaryKey);
    }
}
