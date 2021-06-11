package com.hama.Hama.dao;

import com.hama.Hama.entities.PostEntity;

import java.util.List;

public interface PostDao {

    List<PostEntity> getPosts();

    int savePost(PostEntity PostEntity);

    void deletePost(int id);

    PostEntity getPost(int id);
}
