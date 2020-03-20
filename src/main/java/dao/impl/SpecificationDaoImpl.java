package dao.impl;

import dao.IDao;
import entity.SpecificationEntity;
import entity.pk.SpecificationEntityPK;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class SpecificationDaoImpl implements IDao<SpecificationEntity, SpecificationEntityPK> {
    @Override
    public Optional<SpecificationEntity> get(SpecificationEntityPK id) {
        return Optional.ofNullable(HibernateUtil.getSession().get(SpecificationEntity.class, id));
    }

    @Override
    public List<SpecificationEntity> getAll() {
        return HibernateUtil.getSession()
                .createQuery("FROM SpecificationEntity", SpecificationEntity.class).list();
    }

    @Override
    public void save(SpecificationEntity specificationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(specificationEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(SpecificationEntity specificationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(specificationEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(SpecificationEntity specificationEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(specificationEntity);
        session.getTransaction().commit();
        session.close();
    }
}
