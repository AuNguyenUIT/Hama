package com.hama.Hama.model;

public class Bill extends BaseModel {
    private int userId;
    private float totalAmount;

    public Bill() {
        super();
    }

    public Bill(int userId, float totalAmount) {
        super();
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
