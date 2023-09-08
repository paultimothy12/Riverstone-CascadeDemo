package com.timothy.cascadedemo;

import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StoreData {
    public static void main(String args[]){
        SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(SecuredData.class).addAnnotatedClass(PrimaryData.class).buildSessionFactory();
        Session se= sf.openSession();
        
        //==========PD===============
        PrimaryData pd1 = new PrimaryData();
        pd1.setPd_id(1);
        pd1.setUser_address("Address1");
        pd1.setUser_email("Email1");
        
        PrimaryData pd2 = new PrimaryData();
        pd2.setPd_id(2);
        pd2.setUser_address("Address2");
        pd2.setUser_email("Email2");
        
        PrimaryData pd3 = new PrimaryData();
        pd3.setPd_id(3);
        pd3.setUser_address("Address3");
        pd3.setUser_email("Email3");
        
        PrimaryData pd4 = new PrimaryData();
        pd4.setPd_id(4);
        pd4.setUser_address("Address4");
        pd4.setUser_email("Email4");
        
        PrimaryData pd5 = new PrimaryData();
        pd5.setPd_id(5);
        pd5.setUser_address("Address5");
        pd5.setUser_email("Email5");
        
        //==========SD===============
        SecuredData sd1 = new SecuredData();
        sd1.setSd_id(1);
        sd1.setToken("Token1");
        sd1.setReset_key("Reset Key1");
        
        SecuredData sd2 = new SecuredData();
        sd2.setSd_id(2);
        sd2.setToken("Token2");
        sd2.setReset_key("Reset Key2");
        
        SecuredData sd3 = new SecuredData();
        sd3.setSd_id(3);
        sd3.setToken("Token3");
        sd3.setReset_key("Reset Key3");
        
        SecuredData sd4 = new SecuredData();
        sd4.setSd_id(4);
        sd4.setToken("Token4");
        sd4.setReset_key("Reset Key4");
        
        SecuredData sd5 = new SecuredData();
        sd5.setSd_id(5);
        sd5.setToken("Token5");
        sd5.setReset_key("Reset Key5");
        
        //============User=========
        
        User user1 = new User();
        user1.setUser_id(1);
        user1.setUser_name("Paul");
        user1.setPdList(Arrays.asList(pd1,pd2));
        user1.setSdlist(Arrays.asList(sd1,sd2));
                
        User user2 = new User();
        user2.setUser_id(2);
        user2.setUser_name("Tim");
        user2.setPdList(Arrays.asList(pd3));
        user2.setSdlist(Arrays.asList(sd3));        
        
        User user3 = new User();
        user3.setUser_id(3);
        user3.setUser_name("Dan");
        user3.setPdList(Arrays.asList(pd4,pd5));
        user3.setSdlist(Arrays.asList(sd4,sd5));
        
        pd1.setUser(user1);
        pd2.setUser(user1);
        sd1.setUser(user1);
        sd2.setUser(user1);
        pd3.setUser(user2);
        sd3.setUser(user2);
        pd4.setUser(user3);
        pd5.setUser(user3);
        sd4.setUser(user3);
        sd5.setUser(user3);
        
        se.getTransaction().begin();    
        se.save(pd1);
        se.save(pd2);
        se.save(pd3);
        se.save(pd4);
        se.save(pd5);
        
        se.save(sd1);
        se.save(sd2);
        se.save(sd3);
        se.save(sd4);
        se.save(sd5);
        
        se.save(user1);
        se.save(user2);
        se.save(user3);        
        se.getTransaction().commit();        
    }
}