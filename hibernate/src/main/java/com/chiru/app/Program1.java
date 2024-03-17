package com.chiru.app;

import com.chiru.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class Program1 {
    public static void main(String[] args) {
        //if in case w have given proper name like hibernate.cfg.xml there is no need to pass file name in configuration otherwiise
        //we need to pass inside configuration like new Configuration(filename);

        Configuration configuration = new Configuration();
        configuration.configure("/com/chiru/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student s1 = new Student(2, "blex", "blex@gmail.com",89);
        Serializable id = session.save(s1);
        System.out.println(id);
        transaction.commit();


//
//                Configuration  config = new Configuration();
//        config.configure();
//        config.addAnnotatedClass(Student.class);
//        SessionFactory  sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction =  session.beginTransaction();
//        Student s1 = new Student(1,"alex","alex@gmail.com");
//        Serializable id = session.save(s1);
//        System.out.println(id);
//        transaction.commit();
////		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);




    }
}
