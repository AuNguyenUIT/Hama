package com.hama.Hama.model;

public class Image extends BaseModel {
    private String alt;

    public Image(){

    }
    public Image(String alt) {
        super();
        this.alt = alt;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
