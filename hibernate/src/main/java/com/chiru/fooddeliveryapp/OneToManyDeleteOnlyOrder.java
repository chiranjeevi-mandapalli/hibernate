package com.chiru.fooddeliveryapp;

import com.chiru.model.Customer;
import com.chiru.model.CustomerDeatils;
import com.chiru.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDeleteOnlyOrder {
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

            //in this case we want to delete only single order but not complete deletails of customer
            // for this we should not use CascadeType.All or CascadeType.REMOVE annotation in ordersclass we should use other annoatations
            Orders singleOrder = (Orders)session.get(Orders.class, 706);
            session.delete(singleOrder);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
