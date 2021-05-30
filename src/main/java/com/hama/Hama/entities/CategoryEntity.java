package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbtractEntity {

    @Column()
    private String title;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> productList = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }
}
