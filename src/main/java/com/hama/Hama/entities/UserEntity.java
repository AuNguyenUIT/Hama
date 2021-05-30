package com.hama.Hama.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbtractEntity {

    @OneToMany(mappedBy = "user")
    private List<BillEntity> billList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<RateEntity> rateList = new ArrayList<>();
    @Column()
    private String userName;
    @Column(length = 255)
    private String password;
    @Column(length = 255)
    private String mail;
    @Column(length = 255)
    private String firstName;
    @Column(length = 255)
    private String lastName;
    @Column()
    private Integer gender;
    @Column()
    private Date date;
    @Column(length = 10)
    private String phoneNumber;
    @Column(length = 1000)
    private String address;
    @Column()
    private boolean status;
    @Column(length = 1000)
    private String picture;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public List<BillEntity> getBillList() {
        return billList;
    }

    public void setBillList(List<BillEntity> billList) {
        this.billList = billList;
    }

    public void setRateList(List<RateEntity> rateList) {
        this.rateList = rateList;
    }

    public List<RateEntity> getRateList() {
        return rateList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
