package dao.impl;

import dao.IDao;
import entity.UserEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements IDao<UserEntity, String> {

    public boolean isUserExist(String username, String password) {
        boolean result = true;
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.and(criteriaBuilder.equal(root.get("passwordUser"), password)),
                        criteriaBuilder.equal(root.get("loginUser"), username));
        try {
            session.createQuery(criteriaQuery).getSingleResult();
            result = true;
        }
        catch (NoResultException ex) {
            ex.printStackTrace();
            result = false;
        }
        finally {
            return result;
        }
    }

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
