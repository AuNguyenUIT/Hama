package com.hama.Hama.model;

public class Color extends BaseModel {
    private String title;

    public Color() {
        super();
    }

    public Color(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
