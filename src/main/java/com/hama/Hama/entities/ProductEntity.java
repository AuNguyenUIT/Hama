package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends AbtractEntity {

    @OneToMany(mappedBy = "product")
    private List<ImageEntity> imageList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<CommentEntity> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<RateEntity> rateList = new ArrayList<>();

    @Column()
    private String title;


    @Column()
    private float sale;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(length = 1000)
    private String description;

    @Column
    private float rate;

    @Column
    private boolean status;

    @OneToMany(mappedBy = "product")
    private List<ProductVariationEntity> productVariationList = new ArrayList<>();

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

    public List<ProductVariationEntity> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariationEntity> productVariationList) {
        this.productVariationList = productVariationList;
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

    public void setImageList(List<ImageEntity> imageList) {
        this.imageList = imageList;
    }

    public List<ImageEntity> getImageList() {
        return imageList;
    }
}
