package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class updatemultiple {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "UPDATE Student s set s.marks = 85 where s.marks< 80";
            Query updateQuery = session.createQuery(hql);
            int rowseffected = updateQuery.executeUpdate();
            System.out.println(rowseffected);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
