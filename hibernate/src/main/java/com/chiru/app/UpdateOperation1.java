package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateOperation1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            //when u try to update which is not present u will get exception so its better to use saveorupdate(upsert)
            Student student = new Student(9,"ample","ample@gmail.com",75);
            student.setMarks(50);
            session.update(student);

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
