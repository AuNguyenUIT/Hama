package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbtractEntity {
    @OneToMany(mappedBy = "category")
    private final List<CategoryEntity> categoryList = new ArrayList<>();
    @Column()
    private String title;
    @Column()
    private String thumb;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<ProductEntity> productList = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public List<CategoryEntity> getCategoryList() {
        return categoryList;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
