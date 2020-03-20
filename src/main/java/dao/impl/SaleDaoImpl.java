package dao.impl;

import dao.IDao;
import entity.SaleEntity;
import entity.pk.SaleEntityPK;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class SaleDaoImpl implements IDao<SaleEntity, SaleEntityPK> {
    @Override
    public Optional<SaleEntity> get(SaleEntityPK id) {
        return Optional.ofNullable(HibernateUtil.getSession().get(SaleEntity.class, id));
    }

    @Override
    public List<SaleEntity> getAll() {
        return HibernateUtil.getSession().createQuery("FROM SaleEntity", SaleEntity.class).list();
    }

    @Override
    public void save(SaleEntity saleEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(saleEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(SaleEntity saleEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(saleEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(SaleEntity saleEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(saleEntity);
        session.getTransaction().commit();
        session.close();
    }
}
