package com.alianza.clients.models.dto;

import java.time.LocalDate;

public class ClientDTO {

    private String sharedKey;
    private String bussinesId;
    private String email;
    private String phone;
    private LocalDate dataAdded;

    public ClientDTO() {
    }

    public ClientDTO(String sharedKey, String bussinesId, String email, String phone, LocalDate dataAdded) {
        this.sharedKey = sharedKey;
        this.bussinesId = bussinesId;
        this.email = email;
        this.phone = phone;
        this.dataAdded = dataAdded;
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

    @Override
    public String toString() {
        return "ClientDTO{" +
                ", sharedKey='" + sharedKey + '\'' +
                ", bussinesId='" + bussinesId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dataAdded=" + dataAdded +
                '}';
    }
}
