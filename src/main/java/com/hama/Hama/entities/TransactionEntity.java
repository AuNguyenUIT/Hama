package com.hama.Hama.entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends AbtractEntity {

    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String amount;
    @Column
    private String payment;
    @Column
    private String message;
    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "uid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
