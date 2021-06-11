package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.ProductDao;
import com.hama.Hama.entities.ProductEntity;
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
public class ProductDaoImpl implements ProductDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<ProductEntity> getProducts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = cq.from(ProductEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public int saveProduct(ProductEntity productEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(productEntity);
        return productEntity.getId();
    }

    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductEntity book = session.byId(ProductEntity.class).load(id);
        session.delete(book);
    }

    public ProductEntity getProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductEntity product = session.get(ProductEntity.class, id);
        return product;
    }
}
