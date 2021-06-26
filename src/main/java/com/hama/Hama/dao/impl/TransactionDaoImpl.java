package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.TransactionDao;
import com.hama.Hama.entities.TransactionEntity;
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
public class TransactionDaoImpl implements TransactionDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<TransactionEntity> getTransactions() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TransactionEntity> cq = cb.createQuery(TransactionEntity.class);
        Root<TransactionEntity> root = cq.from(TransactionEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public int saveTransaction(TransactionEntity transactionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(transactionEntity);
        return transactionEntity.getId();
    }

    @Override
    public Boolean deleteTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        TransactionEntity book = session.byId(TransactionEntity.class).load(id);
        try {
            session.remove(book);
            session.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TransactionEntity getTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        TransactionEntity transaction = session.get(TransactionEntity.class, id);
        return transaction;
    }
}
