package com.hama.Hama.model;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseModel{
    private String title;
    private String[] images;

    public Category(){
        super();
    }

    public Category(String title, String[] images){
        super();
        this.title = title;
        this.images = images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String[] getImages() {
        return images;
    }
}
