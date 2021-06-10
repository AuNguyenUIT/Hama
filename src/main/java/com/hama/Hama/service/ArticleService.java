package com.hama.Hama.service;

import com.hama.Hama.entities.ArticleEntity;

import java.util.List;

public interface ArticleService {

    ArticleEntity saveArticle(ArticleEntity category);

    void deleteArticleById(Integer id);

    List<ArticleEntity> getAll();

    ArticleEntity getArticleById(Integer id);
}
