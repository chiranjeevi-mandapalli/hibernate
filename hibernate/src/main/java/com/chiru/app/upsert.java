package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class upsert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Student student = new Student(9, "ink", "ink@gmail.com", 75);
            session.saveOrUpdate(student);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
