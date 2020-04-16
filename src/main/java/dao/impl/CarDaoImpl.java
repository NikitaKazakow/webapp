package dao.impl;

import dao.IDao;
import entity.CarEntity;
import entity.ComplectationEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDaoImpl implements IDao<CarEntity, String> {
    @Override
    public Optional<CarEntity> get(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Optional<CarEntity> carEntityOptional = Optional.ofNullable(session.get(CarEntity.class, id));
        session.getTransaction().commit();
        session.close();
        return carEntityOptional;
    }

    @Override
    public List<CarEntity> getAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<CarEntity> carEntityList = session.createQuery("FROM CarEntity", CarEntity.class).list();
        session.getTransaction().commit();
        session.close();
        return carEntityList;
    }

    public List<CarEntity> getAll(String[] orderByValues, String[] orderDirectionValues) {
        List<Order> orderList = new ArrayList<>();
        List<CarEntity> result = new ArrayList<>();

        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> criteriaQuery = criteriaBuilder.createQuery(CarEntity.class);
        Root<CarEntity> root = criteriaQuery.from(CarEntity.class);

        for (int i = 0; i < orderByValues.length; i++) {
            orderList.add(orderDirectionValues[i].equals("asc") ?
                    criteriaBuilder.asc(root.get(orderByValues[i])) :
                    criteriaBuilder.desc(root.get(orderByValues[i])));
        }

        criteriaQuery.select(root)
                .orderBy(orderList);
        try {
            result = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(CarEntity carEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(carEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(CarEntity carEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(carEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(CarEntity carEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(carEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<CarEntity> filterByAll(String filterValue) {
        List<CarEntity> result = null;
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> criteriaQuery = criteriaBuilder.createQuery(CarEntity.class);
        Root<CarEntity> root = criteriaQuery.from(CarEntity.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("vinNumberCar"), filterValue),
                        criteriaBuilder.like(root.get("yearOfIssueCar").as(String.class), filterValue),
                        criteriaBuilder.like(root.get("colourCar"), filterValue),
                        criteriaBuilder.like(root.get("markCar"), filterValue),
                        criteriaBuilder.like(root.get("modelCar"), filterValue),
                        criteriaBuilder.like(root.get("modelCar"), filterValue),
                        criteriaBuilder.like(root.get("manufactureCountry"), filterValue)
                ));
        try {
            result = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<CarEntity> filterByAll(String filterValue, String[] orderByValues, String[] orderDirectionValues) {
        List<Order> orderList = new ArrayList<>();
        List<CarEntity> result = new ArrayList<>();

        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> criteriaQuery = criteriaBuilder.createQuery(CarEntity.class);
        Root<CarEntity> root = criteriaQuery.from(CarEntity.class);

        for (int i = 0; i < orderByValues.length; i++) {
            orderList.add(orderDirectionValues[i].equals("asc") ?
                    criteriaBuilder.asc(root.get(orderByValues[i])) :
                    criteriaBuilder.desc(root.get(orderByValues[i])));
        }

        criteriaQuery.select(root)
                .where(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("vinNumberCar"), filterValue),
                        criteriaBuilder.like(root.get("yearOfIssueCar").as(String.class), filterValue),
                        criteriaBuilder.like(root.get("colourCar"), filterValue),
                        criteriaBuilder.like(root.get("markCar"), filterValue),
                        criteriaBuilder.like(root.get("modelCar"), filterValue),
                        criteriaBuilder.like(root.get("modelCar"), filterValue),
                        criteriaBuilder.like(root.get("manufactureCountry"), filterValue)
                )).orderBy(orderList);
        try {
            result = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<ComplectationEntity> getComplectations(String vinNumber) {
        List<ComplectationEntity> result = new ArrayList<>();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Optional<CarEntity> carEntityOptional = Optional.ofNullable(session.get(CarEntity.class, vinNumber));
        if (carEntityOptional.isPresent()) {
            result = carEntityOptional
                    .get().getComplectations();
            result.iterator();
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
