package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deleteMultiple {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "Delete Student s where s.marks = 85";
            Query deleteQuery = session.createQuery(hql);
            int rowsDeleted = deleteQuery.executeUpdate();
            System.out.println(rowsDeleted);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
