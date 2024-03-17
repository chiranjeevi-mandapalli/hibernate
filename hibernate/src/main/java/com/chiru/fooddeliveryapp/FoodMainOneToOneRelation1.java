package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class FoodMainOneToOneRelation1 {
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

            Customer c1 = new Customer(2, "bob");
            CustomerDeatils cd1 = new CustomerDeatils(502, "bob@gmail.com", "456226", "pune");
            c1.setCustomerDeatils(cd1);
            Serializable store = session.save(c1);
            System.out.println(store);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
