package com.hama.Hama.model;

public class Rate extends BaseModel {
    private int userId;
    private int productId;
    private float numberStart;

    public Rate() {

    }

    public Rate(int userId, int productId, float numberStart) {
        super();
        this.userId = userId;
        this.productId = productId;
        this.numberStart = numberStart;
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

    public float getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(float numberStart) {
        this.numberStart = numberStart;
    }
}
