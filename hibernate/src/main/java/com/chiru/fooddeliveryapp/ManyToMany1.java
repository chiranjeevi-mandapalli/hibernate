package com.chiru.fooddeliveryapp;

import com.chiru.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ManyToMany1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = new Configuration()
                    .configure("/com/chiru/hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            //creating employees
            Employee alex = new Employee(1, "alex", "alex@gmail.com");
            Employee bob = new Employee(2, "bob", "bob@gmail.com");
            Employee charlie = new Employee(3, "charlie", "charlie@gmail.com");

            //creating projects
            Project pr = new Project(1, "PremiumPro");
            Project af = new Project(2, "AfterEffects");


            ArrayList<Employee> premployees = new ArrayList<>();
            ArrayList<Employee> afemployees = new ArrayList<>();

            //assigning employee to premierpro project
            premployees.add(alex);
            premployees.add(bob);
            premployees.add(charlie);
            pr.setEmployees(premployees);

            //assigning employee to aftereffetcs project
            afemployees.add(bob);
            afemployees.add(charlie);
            af.setEmployees(afemployees);

            session.save(alex);
            session.save(bob);
            session.save(charlie);

            session.save(pr);
            session.save(af);

            //we can use session.save or session.merge method both will work

//            session.merge(alex);
//            session.merge(bob);
//            session.merge(charlie);
//
//            session.merge(pr);
//            session.merge(af);


//   It means you are trying to save or update a detached object which has an un-unique or set auto-incrementing identifier.
//If you want to insert a new object you want it's id to be empty or unique depending on whether you use auto incrementation or
// not(null for auto incrementation, set with a unique value for non-auto-incrementation),
// if you want to update it you want to make sure it is attached to the context.
//You can reattach an object to the context using session.merge(object) which returns an attached version of the object.
//In other words:
//If you are trying to insert make sure the field that is configured as Id is either null if you use auto incrementation or is unique.
//If you are trying to update make sure the object is attached. You can do this by selecting it from your database (based on the fields you have), make the changes, and then update, or just call the session.merge(object) method and receive an attached version of the object which you can then also update.

            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
