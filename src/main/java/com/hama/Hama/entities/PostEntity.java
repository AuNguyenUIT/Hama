package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity extends AbtractEntity {
    @Column()
    private String title;

    @Column()
    private String thumb;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column()
    private boolean status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
