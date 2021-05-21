package com.hama.Hama.model;

public class Comment extends BaseModel {
    private int userId;
    private int productId;
    private String body;

    public Comment() {
        super();
    }
    public Comment(int userId, int productId, String body) {
        super();
        this.userId = userId;
        this.productId = productId;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
