package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetailEntity extends AbtractEntity {

    @ManyToOne()
    @JoinColumn(name = "bill_id")
    private BillEntity bill;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column()
    private int quantity;

    @Column()
    private int amount;

    public BillEntity getBill() {
        return bill;
    }

    public void setBill(BillEntity bill) {
        this.bill = bill;
    }

    public ProductEntity getProductVariation() {
        return product;
    }

    public void setProductVariation(ProductEntity product) {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
