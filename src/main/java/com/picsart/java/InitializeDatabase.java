package com.picsart.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class InitializeDatabase {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customers customer1 = new Customers("John Doe", "john@example.com", "123 Main St, Anytown, USA",new Date());
        Customers customer2 = new Customers("Alice Smith", "alice@example.com", "456 Elm St, Othertown, USA",new Date());
        Customers customer3 = new Customers("Bob Johnson", "bob@example.com", "789 Oak St, Anycity, USA",new Date());
        Customers customer4 = new Customers("Emily Brown", "emily@example.com", "246 Maple St, Anothercity, USA",new Date());
        Customers customer5 = new Customers("Michael Jones", "michael@example.com", "135 Pine St, Yetanothercity, USA",new Date());

        session.persist(customer1);
        session.persist(customer2);
        session.persist(customer3);
        session.persist(customer4);
        session.persist(customer5);

        session.flush();
        transaction.commit();
        session.close();
    }
}
