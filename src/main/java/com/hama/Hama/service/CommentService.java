package com.hama.Hama.service;

import com.hama.Hama.entities.CommentEntity;

import java.util.List;

public interface CommentService {
    Integer saveComment(CommentEntity commentEntity);

    Boolean deleteComment(Integer id);

    List<CommentEntity> getComments();

    CommentEntity getComment(Integer id);

    List<CommentEntity> getCommentsByProductId(Integer product_id);

}
