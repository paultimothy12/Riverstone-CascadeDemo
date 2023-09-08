package com.timothy.cascadedemo;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

    public static void main(String args[]) {
        SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(SecuredData.class).addAnnotatedClass(PrimaryData.class).buildSessionFactory();
        Session se = sf.openSession();

        Query<User> q1 = se.createQuery("from User");
        List<User> users = q1.list();
        for (User u : users) {
            System.out.println(u.getUser_id()+" "+u.getUser_name());
        }

        Query<PrimaryData> q2 = se.createQuery("from PrimaryData");
        List<PrimaryData> pd = q2.list();
        for (PrimaryData p : pd) {
            System.out.println(p.getPd_id()+" "+p.getUser_email()+" "+p.getUser_address()+" "+p.getUser().getUser_id());
        }

        Query<SecuredData> q3 = se.createQuery("from SecuredData");
        List<SecuredData> sd = q3.list();
        for (SecuredData s : sd) {
            System.out.println(s.getSd_id()+ " "+s.getToken()+" "+s.getReset_key()+" "+s.getUser().getUser_id());
        }
        
        System.out.println("==========Removing user 2 ============");

        se.getTransaction().begin();       
        User user = se.get(User.class, 2);
        se.remove(user);        
        se.getTransaction().commit();
        
        Query<User> q4 = se.createQuery("from User");
        List<User> users1 = q4.list();
        for (User u : users1) {
            System.out.println(u.getUser_id()+" "+u.getUser_name());
        }

        Query<PrimaryData> q5 = se.createQuery("from PrimaryData");
        List<PrimaryData> pd1 = q5.list();
        for (PrimaryData p : pd1) {
            System.out.println(p.getPd_id()+" "+p.getUser_email()+" "+p.getUser_address()+" "+p.getUser().getUser_id());
        }

        Query<SecuredData> q6 = se.createQuery("from SecuredData");
        List<SecuredData> sd1 = q6.list();
        for (SecuredData s : sd1) {
            System.out.println(s.getSd_id()+ " "+s.getToken()+" "+s.getReset_key()+" "+s.getUser().getUser_id());
        }
        
        System.out.println("==========Changing user name of 3 and check if user_name in child tables are also changed============");
        
        System.out.println("BEFORE CHANGING");
        
        Query<User> q7 = se.createQuery("from User");
        List<User> users2 = q7.list();
        for (User u : users2) {
            System.out.println(u.getUser_id()+" "+u.getUser_name());
        }

        Query<PrimaryData> q8 = se.createQuery("from PrimaryData");
        List<PrimaryData> pd2 = q8.list();
        for (PrimaryData p : pd2) {
            System.out.println(p.getPd_id()+" "+p.getUser_email()+" "+p.getUser_address()+" "+p.getUser().getUser_id()+" "+p.getUser().getUser_name());
        }

        Query<SecuredData> q9 = se.createQuery("from SecuredData");
        List<SecuredData> sd2 = q9.list();
        for (SecuredData s : sd2) {
            System.out.println(s.getSd_id()+ " "+s.getToken()+" "+s.getReset_key()+" "+s.getUser().getUser_id()+" "+s.getUser().getUser_name());
        }
        
        se.getTransaction().begin();
        User user3 = se.get(User.class, 3);
        user3.setUser_name("Tim");
        se.save(user3);
        se.getTransaction().commit();
        
        System.out.println("AFTER CHANGING");
        
        Query<User> q10 = se.createQuery("from User");
        List<User> users3 = q10.list();
        for (User u : users3) {
            System.out.println(u.getUser_id()+" "+u.getUser_name());
        }

        Query<PrimaryData> q11 = se.createQuery("from PrimaryData");
        List<PrimaryData> pd3 = q11.list();
        for (PrimaryData p : pd3) {
            System.out.println(p.getPd_id()+" "+p.getUser_email()+" "+p.getUser_address()+" "+p.getUser().getUser_id()+" "+p.getUser().getUser_name());
        }

        Query<SecuredData> q12 = se.createQuery("from SecuredData");
        List<SecuredData> sd3 = q12.list();
        for (SecuredData s : sd3) {
            System.out.println(s.getSd_id()+ " "+s.getToken()+" "+s.getReset_key()+" "+s.getUser().getUser_id()+" "+s.getUser().getUser_name());
        }        
    }
}
