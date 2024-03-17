package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import com.chiru.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDeleteAllDetails {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration()
                    .configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(CustomerDeatils.class)
                    .addAnnotatedClass(Orders.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            // when i delete the customer all the deatilks present in the database should be deleted
            //i.e.. data should be deleted completely from customer,customerdetails and orders tables
            Customer bob = (Customer)session.get(Customer.class, 2);
            session.delete(bob);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
