package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class Create {
    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//        configuration.configure("/com/chiru/hibernate.cfg.xml");
//        configuration.addAnnotatedClass(Student.class);
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Student s1 = new Student(2, "blex", "blex@gmail.com");
//        Serializable id = session.save(s1);
//        System.out.println(id);
//        transaction.commit();
        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Student s1 = new Student(4, "dlex", "dlex@gmail.com",98);
            Serializable id = session.save(s1);
            System.out.println(id);
            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
