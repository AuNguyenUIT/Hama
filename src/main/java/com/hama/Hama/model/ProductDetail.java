package com.hama.Hama.model;

public class ProductDetail extends BaseModel {
    private int productId;
    private int colorId;
    private int sizeId;
    private int inventory;

    public ProductDetail(){
        super();
    }

    public ProductDetail(int productId, int colorId, int sizeId, int inventory) {
        super();
        this.productId = productId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
