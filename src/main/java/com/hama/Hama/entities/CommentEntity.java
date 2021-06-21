package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends AbtractEntity{

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(length = 1000)
    private String body;

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
