package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FoodMainOneToOneRelationRead {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration()
                    .configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(CustomerDeatils.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Customer customer = (Customer) session.get(Customer.class, 1);
            System.out.println(customer);

            //if u want to print only customer details the we can do like this

            CustomerDeatils customerDeatils = customer.getCustomerDeatils();
            System.out.println(customerDeatils);

            //we can fetch only customer details using customerdetails object
            CustomerDeatils deatils = (CustomerDeatils) session.get(CustomerDeatils.class, 501);
            System.out.println(deatils);


            //birectional example
            CustomerDeatils details1 = (CustomerDeatils) session.get(CustomerDeatils.class, 501);
            System.out.println(details1);
            Customer customer1 = details1.getCustomer();
            System.out.println(customer1);


            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
