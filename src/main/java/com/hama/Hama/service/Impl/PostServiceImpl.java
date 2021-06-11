package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.PostDao;
import com.hama.Hama.entities.PostEntity;
import com.hama.Hama.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    @Transactional
    public Integer savePost(PostEntity post) {
        return postDao.savePost(post);
    }

    @Override
    @Transactional
    public void deletePost(Integer id) {
        postDao.deletePost(id);
    }

    @Override
    @Transactional
    public List<PostEntity> getPosts() {
        return postDao.getPosts();
    }

    @Override
    @Transactional
    public PostEntity getPost(Integer id) {
        return postDao.getPost(id);
    }


}
