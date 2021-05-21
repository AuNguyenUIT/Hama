package com.hama.Hama.model;

public class BillDetail extends BaseModel{

    private int billId;
    private int productDetailId;
    private int quantity;
    private float amount;

    public BillDetail(){
        super();
    }
    public BillDetail(int billId, int productDetailId, int quantity, float amount) {
        super();
        this.billId = billId;
        this.productDetailId = productDetailId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
