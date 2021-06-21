package com.hama.Hama.service;

import com.hama.Hama.entities.PostEntity;

import java.util.List;

public interface PostService {

    Integer savePost(PostEntity post);

    void deletePost(Integer id);

    List<PostEntity> getPosts();

    PostEntity getPost(Integer id);
}
