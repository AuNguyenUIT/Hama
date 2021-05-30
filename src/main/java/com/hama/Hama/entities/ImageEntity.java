package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity extends AbtractEntity {
    @Column()
    private String alt;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public ProductEntity getProduct() {
        return product;
    }
}
