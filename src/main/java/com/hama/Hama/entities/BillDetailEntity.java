package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetailEntity extends AbtractEntity {

    @ManyToOne()
    @JoinColumn(name = "bill_id")
    private BillEntity bill;

    @ManyToOne()
    @JoinColumn(name = "product_variation_id")
    private ProductVariationEntity productVariation;

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

    public ProductVariationEntity getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariationEntity productVariation) {

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
