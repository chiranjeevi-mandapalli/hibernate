package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import com.chiru.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class OneToMany1 {
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

            Orders o1 = new Orders(701, "Burger", 300);
            Orders o2 = new Orders(702, "Pizza", 350);
            Orders o3 = new Orders(703, "Burger", 300);

            Customer alex = (Customer) session.get(Customer.class, 1);
            o1.setCustomer(alex);
            o2.setCustomer(alex);
            o3.setCustomer(alex);

            System.out.println(session.save(o1));
            System.out.println(session.save(o2));
            System.out.println(session.save(o3));


            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
