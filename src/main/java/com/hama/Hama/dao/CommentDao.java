package com.hama.Hama.dao;

import com.hama.Hama.entities.CommentEntity;

import java.util.List;

public interface CommentDao {
    void insert(CommentEntity comment);

    void edit(CommentEntity comment);

    void delete(int id);

    CommentEntity get(int id);

    List<CommentEntity> getAll();

}
