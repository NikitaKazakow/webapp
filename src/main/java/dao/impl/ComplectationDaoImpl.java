package dao.impl;

import dao.IDao;
import entity.ComplectationEntity;
import entity.pk.ComplectationEntityPK;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class ComplectationDaoImpl implements IDao<ComplectationEntity, ComplectationEntityPK> {
    @Override
    public Optional<ComplectationEntity> get(ComplectationEntityPK id) {
        return Optional.ofNullable(HibernateUtil.getSession().get(ComplectationEntity.class, id));
    }

    @Override
    public List<ComplectationEntity> getAll() {
        return HibernateUtil.getSession()
                .createQuery("FROM ComplectationEntity", ComplectationEntity.class).list();
    }

    @Override
    public void save(ComplectationEntity complectationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(complectationEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ComplectationEntity complectationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(complectationEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(ComplectationEntity complectationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(complectationEntity);
        session.getTransaction().commit();
        session.close();
    }
}
