package com.hama.Hama.model;

public class Blog extends BaseModel{
    private String title;
    private String body;
    private Image thumb;
    private boolean status;

    public Blog(){
        super();
    }

    public Blog(String title, String body, Image thumb, boolean status) {
        super();
        this.title = title;
        this.body = body;
        this.thumb = thumb;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Image getThumb() {
        return thumb;
    }

    public void setThumb(Image thumb) {
        this.thumb = thumb;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
