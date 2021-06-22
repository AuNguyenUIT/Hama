package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends AbtractEntity {

    @Column()
    String name;

    @Column()
    String email;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(length = 1000)
    private String body;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
