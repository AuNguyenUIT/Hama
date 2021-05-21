package com.hama.Hama.model;

public class BaseModel {
    private String id;
    private String created;
    private String updated;

    public BaseModel() {
        super();
    }

    public BaseModel(String id, String created, String updated) {
        super();
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
