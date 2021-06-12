package com.hama.Hama.dao.impl;

import com.hama.Hama.dao.PostDao;
import com.hama.Hama.entities.PostEntity;
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
public class PostDaoImpl implements PostDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<PostEntity> getPosts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PostEntity> cq = cb.createQuery(PostEntity.class);
        Root<PostEntity> root = cq.from(PostEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public int savePost(PostEntity PostEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(PostEntity);
        return PostEntity.getId();
    }

    public void deletePost(int id) {
        Session session = sessionFactory.getCurrentSession();
        PostEntity book = session.byId(PostEntity.class).load(id);
        session.delete(book);
    }

    public PostEntity getPost(int id) {
        Session session = sessionFactory.getCurrentSession();
        PostEntity Post = session.get(PostEntity.class, id);
        return Post;
    }
}
