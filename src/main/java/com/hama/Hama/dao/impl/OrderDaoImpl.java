package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.OrderDao;
import com.hama.Hama.entities.OrderEntity;
import com.hama.Hama.entities.UserEntity;
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
public class OrderDaoImpl implements OrderDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<OrderEntity> getOrders() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> cq = cb.createQuery(OrderEntity.class);
        Root<OrderEntity> root = cq.from(OrderEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public int saveOrder(OrderEntity OrderEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(OrderEntity);
        return OrderEntity.getId();
    }

    @Override
    public Boolean deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderEntity book = session.byId(OrderEntity.class).load(id);
        try {
            session.remove(book);
            session.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrderEntity getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderEntity order = session.get(OrderEntity.class, id);
        return order;
    }

    @Override
    public OrderEntity getOrderByStatusAndUid(String status, Integer uid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM OrderEntity  WHERE status =:status AND user.id =:uid");
        query.setParameter("status", status);
        query.setParameter("uid", uid);
        List<OrderEntity> results = query.getResultList();
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        } else {
            return new OrderEntity();
        }
    }
}
