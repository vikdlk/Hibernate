package com.hibernate.collection.Demo;

import com.hibernate.collection.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentSet {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Igor", "Stex", "Igror@mail.com");
            Set<String> images = student.getImages();

            images.add("photo1.jpg");
            images.add("photo2.jpg");
            images.add("photo3.jpg");
            images.add("photo4.jpg");
            images.add("photo5.jpg");
            images.add("images.jpg");

            session.beginTransaction();

            //save the object
            System.out.println("Saving the Student and images...");
            session.persist(student);

            session.getTransaction().commit();
            System.out.println("Done");


        } finally {

            session.close();
            factory.close();
        }
    }
}
