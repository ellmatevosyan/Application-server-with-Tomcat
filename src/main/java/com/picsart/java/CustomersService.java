package com.picsart.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;

public class CustomersService {
    public void createCustomer(String name, String email,String address){
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Customers customers = new Customers();
            customers.setName(name);
            customers.setEmail(email);
            customers.setAddress(address);
            customers.setCreated_at(new Date());
            session.persist(customers);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public void deleteCustomer(Long customerId){
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Customers customers = session.get(Customers.class,customerId);
            if(customers != null){
                session.remove(customers);
            }
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public List<Customers> getAllCustomers(){
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customers> list = session.createQuery("FROM Customers", Customers.class).getResultList();
        transaction.commit();
        return list;
    }
}
