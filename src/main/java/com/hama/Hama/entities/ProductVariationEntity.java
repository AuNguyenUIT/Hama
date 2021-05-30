package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_variaion")
public class ProductVariationEntity extends AbtractEntity {

    @Column()
    private String title;

    @Column()
    private Integer inventory;

    @Column()
    private float price;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private SizeEntity size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity color;

    @OneToMany(mappedBy = "productVariation")
    private List<BillDetailEntity> billDetailList = new ArrayList<>();

    @Column()
    private boolean status;

    public List<BillDetailEntity> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetailEntity> billDetailList) {
        this.billDetailList = billDetailList;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPublic() {
        return status;
    }
}
