package com.hama.Hama.model;

public class Order extends BaseModel {
    private int userId;
    private int productDetailId;
    private int quantity;
    private String address;
    private boolean status;
    private String orderStatus;

    public Order() {
        super();
    }

    public Order(int userId, int productDetailId, int quantity, String address, boolean status, String orderStatus) {
        super();
        this.userId = userId;
        this.productDetailId = productDetailId;
        this.quantity = quantity;
        this.address = address;
        this.status = status;
        this.orderStatus = orderStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
