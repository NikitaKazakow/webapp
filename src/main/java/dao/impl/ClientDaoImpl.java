package dao.impl;

import dao.IDao;
import entity.ClientEntity;
import entity.pk.ClientEntityPK;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements IDao<ClientEntity, ClientEntityPK> {
    @Override
    public Optional<ClientEntity> get(ClientEntityPK id) {
        return Optional.ofNullable(HibernateUtil.getSession().get(ClientEntity.class, id));
    }

    @Override
    public List<ClientEntity> getAll() {
        return HibernateUtil.getSession().createQuery("FROM ClientEntity", ClientEntity.class).list();
    }

    @Override
    public void save(ClientEntity clientEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(clientEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ClientEntity clientEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(clientEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(ClientEntity clientEntity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(clientEntity);
        session.getTransaction().commit();
        session.close();
    }
}
