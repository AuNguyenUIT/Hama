package com.hama.Hama.dao;

import com.hama.Hama.entities.PostEntity;
import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface PostDao {

    List<PostEntity> getPosts();

    int savePost(PostEntity postEntity);

    Boolean deletePost(int id);

    PostEntity getPost(int id);

    List<PostEntity> getPostsByQuery(String query);

}
