package com.hibernate.collection.Demo;

import com.hibernate.collection.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentImageMap {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            // get the student id
            int theId = 1;
            Student student = session.get(Student.class, theId);

            //print the student detail
            System.out.println("Student details: " + student);

            //print the associated images
            System.out.println("The associated images: " + student.getImages());

            //commit the transaction
            session.getTransaction().commit();

            //done
            System.out.println("Done!");


        } finally {
            session.close();
            factory.close();
        }
    }
}
