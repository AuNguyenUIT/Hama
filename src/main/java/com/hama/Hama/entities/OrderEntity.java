package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends AbtractEntity {

    @Column()
    private String status;
    @OneToOne(mappedBy = "order")
    private TransactionEntity transaction;
    @ManyToOne
    @JoinColumn(name = "uid")
    private UserEntity user;
    @Column()
    private String email;
    @Column(columnDefinition = "Decimal(20,6) default '00.00'")
    private Float total;
    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }
}
