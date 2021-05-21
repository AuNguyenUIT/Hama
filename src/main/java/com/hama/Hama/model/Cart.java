package com.hama.Hama.model;

public class Cart extends BaseModel {
    private int productDetailId;
    private int quantity;
    private int userId;

    public Cart() {
        super();
    }

    public Cart(int productDetailId, int quantity, int userId) {
        super();
        this.productDetailId = productDetailId;
        this.quantity = quantity;
        this.userId = userId;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
