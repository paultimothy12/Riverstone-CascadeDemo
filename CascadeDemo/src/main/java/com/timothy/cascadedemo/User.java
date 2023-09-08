package com.timothy.cascadedemo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    private int user_id;
    private String user_name;

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PrimaryData> pdList;

    @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SecuredData> sdlist;

    public User() {
    }

    public User(int user_id, String user_name, List<PrimaryData> pdList, List<SecuredData> sdlist) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pdList = pdList;
        this.sdlist = sdlist;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<PrimaryData> getPdList() {
        return pdList;
    }

    public void setPdList(List<PrimaryData> pdList) {
        this.pdList = pdList;
    }

    public List<SecuredData> getSdlist() {
        return sdlist;
    }

    public void setSdlist(List<SecuredData> sdlist) {
        this.sdlist = sdlist;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name=" + user_name + ", pdList=" + pdList + ", sdlist=" + sdlist + '}';
    }
  
}
