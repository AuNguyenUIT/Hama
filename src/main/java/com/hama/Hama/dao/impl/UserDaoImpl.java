package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.UserDao;
import com.hama.Hama.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao  {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<UserEntity> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public int saveUser(UserEntity UserEntity) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(UserEntity);
            return UserEntity.getId();
        } catch (Exception e) {
            System.out.println(e.getCause());
            session.clear();
            return 0;
        }
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity book = session.byId(UserEntity.class).load(id);
        session.delete(book);
    }

    @Override
    public UserEntity getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity user = session.get(UserEntity.class, id);
        return user;
    }

    @Override
    public UserEntity getUserByUserNameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM UserEntity  WHERE  (userName= :username OR mail= :email) AND password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setParameter("email", username);
        List results = query.getResultList();
        if (results != null && !results.isEmpty()) {
            UserEntity user = (UserEntity) results.get(0);
            return user;
        } else {
            return new UserEntity();
        }

    }
}
