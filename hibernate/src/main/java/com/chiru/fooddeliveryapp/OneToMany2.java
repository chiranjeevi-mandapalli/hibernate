package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import com.chiru.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany2 {
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
            Customer bob = new Customer(2, "bob");
            CustomerDeatils bobDeatils = new CustomerDeatils(502, "bob@gmail.com", "4559", "pune");
            bob.setCustomerDeatils(bobDeatils);

            Orders o1 = new Orders(704, "Idli", 300);
            Orders o2 = new Orders(705, "Vada", 350);
            Orders o3 = new Orders(706, "pongal", 300);

            o1.setCustomer(bob);
            o2.setCustomer(bob);
            o3.setCustomer(bob);

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
