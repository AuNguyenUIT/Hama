package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
public class ArticleEntity extends AbtractEntity{
    @Column()
    private String title;
    
    @Column()
    private String thumb;
   
   @Column(length = 10000)
    private String body;
   
   @Column()
   private int status;
   

    
    @ManyToOne()
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @OneToMany(mappedBy = "article")
    private final List<ArticleEntity> articleList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public ArticleEntity getArticle() {
        return article;
    }

    public List<ArticleEntity> getArticleList() {
        return articleList;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }
    
    
    
    
}
