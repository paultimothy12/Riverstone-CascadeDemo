package com.timothy.cascadedemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PrimaryData {
    @Id
    private int pd_id;
    private String user_email;
    private String user_address;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user1;
    
    public PrimaryData() {
    }

    public PrimaryData(int pd_id, String user_email, String user_address, User user1) {
        this.pd_id = pd_id;
        this.user_email = user_email;
        this.user_address = user_address;
        this.user1 = user1;
    }

    public int getPd_id() {
        return pd_id;
    }

    public void setPd_id(int pd_id) {
        this.pd_id = pd_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public User getUser() {
        return user1;
    }

    public void setUser(User user1) {
        this.user1= user1;
    }

}
