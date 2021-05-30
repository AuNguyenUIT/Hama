package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class RateEntity extends AbtractEntity {

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column()
    private float numberStar;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public float getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(float numberStar) {
        this.numberStar = numberStar;
    }
}
