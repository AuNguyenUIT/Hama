package com.hama.Hama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "color")
public class ColorEntity extends AbtractEntity{

    @Column()
    private String title;

    @OneToMany(mappedBy = "color")
    private List<ProductVariationEntity> productVariationList = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<ProductVariationEntity> getProductVariationList() {
        return productVariationList;
    }

    public void setProductVariationList(List<ProductVariationEntity> productVariationList) {
        this.productVariationList = productVariationList;
    }
}
