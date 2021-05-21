package com.hama.Hama.model;

import java.util.List;

public class Product extends BaseModel {

    private String title;
    private List<Image> images;
    private float price;
    private float sale;
    private List<Category> categories;
    private String description;
    private float rate;
    private boolean status;

    public Product() {
        super();
    }

    public Product(String title, List<Image> images, float price, float sale, List<Category> categories, String description, float rate, boolean status) {
        super();
        this.title = title;
        this.images = images;
        this.price = price;
        this.sale = sale;
        this.categories = categories;
        this.description = description;
        this.rate = rate;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean isPublic() {
        return status;
    }
}

