package com.alianza.clients.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String sharedKey;
    private String bussinesId;
    @Column(unique = true)
    private String email;
    private String phone;
    private LocalDate dataAdded;

    public Client(){}

    public Client(Long id, String sharedKey, String bussinesId, String email, String phone, LocalDate dataAdded) {
        this.id = id;
        this.sharedKey = sharedKey;
        this.bussinesId = bussinesId;
        this.email = email;
        this.phone = phone;
        this.dataAdded = dataAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public String getBussinesId() {
        return bussinesId;
    }

    public void setBussinesId(String bussinesId) {
        this.bussinesId = bussinesId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDataAdded() {
        return dataAdded;
    }

    public void setDataAdded(LocalDate dataAdded) {
        this.dataAdded = dataAdded;
    }
}
