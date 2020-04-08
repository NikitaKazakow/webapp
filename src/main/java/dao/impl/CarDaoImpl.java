package dao.impl;

import dao.IDao;
import entity.CarEntity;
import org.hibernate.Session;
import util.HibernateUtil;

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
        return HibernateUtil.getSession().createQuery("FROM CarEntity", CarEntity.class).list();
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
}
