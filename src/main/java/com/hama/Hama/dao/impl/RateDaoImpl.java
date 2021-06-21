package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.RateDao;
import com.hama.Hama.dao.RateDao;
import com.hama.Hama.entities.RateEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RateDaoImpl implements RateDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<RateEntity> getRates() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<RateEntity> cq = cb.createQuery(RateEntity.class);
        Root<RateEntity> root = cq.from(RateEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public int saveRate(RateEntity rateEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(rateEntity);
        return rateEntity.getId();
    }

    @Override
    public void deleteRate(int id) {
        Session session = sessionFactory.getCurrentSession();
        RateEntity book = session.byId(RateEntity.class).load(id);
        session.delete(book);
    }

    @Override
    public RateEntity getRate(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RateEntity.class, id);
    }
}
