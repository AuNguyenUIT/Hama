package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItemEntity extends AbtractEntity {
    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(columnDefinition = "Decimal(20,6) default '00.00'")
    private Float total;

    @Column(columnDefinition = "Decimal(20,6) default '00.00'")
    private Float unitPrice;

    @Column()
    private String size;

    @Column()
    private Integer quantity;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }


}
