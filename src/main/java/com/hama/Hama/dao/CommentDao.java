package com.hama.Hama.dao;

import com.hama.Hama.entities.CommentEntity;

import java.util.List;

public interface CommentDao {

    List<CommentEntity> getComments();

    int saveComment(CommentEntity commentEntity);

    void deleteComment(int id);

    CommentEntity getComment(int id);

    List<CommentEntity> getCommentsByProductId(Integer product_id);
}
