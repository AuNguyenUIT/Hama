package com.hama.Hama.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity extends AbtractEntity{

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private float totalAmount;

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
