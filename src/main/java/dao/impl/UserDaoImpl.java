package dao.impl;

import dao.IDao;
import entity.UserEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements IDao<UserEntity, String> {

    @Override
    public Optional<UserEntity> get(String id) {
        return Optional.ofNullable(HibernateUtil.getSession().get(UserEntity.class, id));
    }

    @Override
    public List<UserEntity> getAll() {
        return HibernateUtil.getSession().createQuery("FROM UserEntity", UserEntity.class).list();
    }

    @Override
    public void save(UserEntity userEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(UserEntity userEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(userEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(UserEntity userEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(userEntity);
        session.getTransaction().commit();
        session.close();
    }
}
