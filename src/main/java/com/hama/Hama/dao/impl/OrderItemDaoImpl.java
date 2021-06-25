package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.OrderItemDao;
import com.hama.Hama.entities.OrderItemEntity;
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
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<OrderItemEntity> getOrderItems() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<OrderItemEntity> cq = cb.createQuery(OrderItemEntity.class);
        Root<OrderItemEntity> root = cq.from(OrderItemEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public int saveOrderItem(OrderItemEntity orderItemEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderItemEntity);
        return orderItemEntity.getId();
    }

    @Override
    public Boolean deleteOrderItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderItemEntity book = session.byId(OrderItemEntity.class).load(id);
        try {
            session.remove(book);
            session.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrderItemEntity getOrderItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderItemEntity order = session.get(OrderItemEntity.class, id);
        return order;
    }

    @Override
    public List<OrderItemEntity> getOrderItemsByOrderId(Integer order_id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM OrderItemEntity  WHERE order.id =:order_id ");
        query.setParameter("order_id", order_id);
        return query.getResultList();
    }
}
