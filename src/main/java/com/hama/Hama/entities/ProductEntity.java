package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends AbtractEntity {

    @Column()
    private String title;

    @Column()
    private String thumb;

    @Column()
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String images;

    @OneToMany(mappedBy = "product")
    private List<CommentEntity> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<RateEntity> rateList = new ArrayList<>();

    @Column()
    private float sale;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column()
    private float price;

    @Column
    private float rate;

    @Column
    private boolean status;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public boolean isPublic() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public List<RateEntity> getRateList() {
        return rateList;
    }

    public void setRateList(List<RateEntity> rateList) {
        this.rateList = rateList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
