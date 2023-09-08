package com.timothy.cascadedemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SecuredData {
    @Id
    private int sd_id;
    private String token;
    private String reset_key;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user2;
    
    public SecuredData() {
    }

    public SecuredData(int sd_id, String token, String reset_key, User user2) {
        this.sd_id = sd_id;
        this.token = token;
        this.reset_key = reset_key;
        this.user2 = user2;
    }

    public int getSd_id() {
        return sd_id;
    }

    public void setSd_id(int sd_id) {
        this.sd_id = sd_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReset_key() {
        return reset_key;
    }

    public void setReset_key(String reset_key) {
        this.reset_key = reset_key;
    }

    public User getUser() {
        return user2;
    }

    public void setUser(User user2) {
        this.user2 = user2;
    }
  
}
