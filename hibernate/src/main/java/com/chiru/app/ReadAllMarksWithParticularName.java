package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadAllMarksWithParticularName {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            // in the query we should give class name not the table name
            String Query = "FROM Student s where s.marks >= 90 or s.name like 'c%'";
            Query query = session.createQuery(Query);
            List students = query.list();
            display(students);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    private static void display(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
