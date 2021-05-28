package com.hama.Hama.dao;

import com.hama.Hama.model.Comment;

import java.util.List;

public interface CommentDao {
    void insert(Comment comment);

    void edit(Comment comment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();

}
