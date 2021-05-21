package com.hama.Hama.model;

public class Size extends BaseModel{

    private String title;

    public Size(){
        super();
    }

    public Size(String title){
        super();
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
