package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.CommentDao;
import com.hama.Hama.entities.CommentEntity;
import com.hama.Hama.service.CommentService;
import com.hama.Hama.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    @Transactional
    public Integer saveComment(CommentEntity comment) {
        return commentDao.saveComment(comment);
    }

    @Override
    @Transactional
    public Boolean deleteComment(Integer id) {
        return commentDao.deleteComment(id);
    }

    @Override
    @Transactional
    public List<CommentEntity> getComments() {
        return commentDao.getComments();
    }

    @Override
    @Transactional
    public CommentEntity getComment(Integer id) {
        return commentDao.getComment(id);
    }

    @Override
    @Transactional
    public List<CommentEntity> getCommentsByProductId(Integer product_id) {
        return commentDao.getCommentsByProductId(product_id);
    }


}
