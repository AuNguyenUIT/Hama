package com.hama.Hama.service.Impl;

import com.hama.Hama.entities.ArticleEntity;
import com.hama.Hama.repository.ArticleRepository;
import com.hama.Hama.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    ArticleRepository articleRepository;
    
    @Override
    public ArticleEntity saveArticle(ArticleEntity article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleEntity> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public ArticleEntity getArticleById(Integer id) {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findById(id);
       if (articleEntityOptional.equals("")) {
            return new ArticleEntity();
        }
        return articleEntityOptional.get();
    }
    
    
}
