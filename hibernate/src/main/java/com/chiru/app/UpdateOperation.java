package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateOperation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration().configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class).buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Student student = (Student) session.get(Student.class, 2);
            student.setMarks(50);
            session.update(student);

            // or we can do like this there is no need to call session.update if we
            // do set it will automatically update

//            Student student = (Student) session.get(Student.class, 2);
//            student.setMarks(50);


            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
