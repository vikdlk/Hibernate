package com.hibernate.collection.Demo;

import com.hibernate.collection.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;

public class CreateStudentMap {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Name1", "Zamaro", "name1@vilnius.lt");
            Map<String,String> theImages = student.getImages();

            theImages.put("photo1.jpg", "Photo 1");
            theImages.put("photo2.jpg", "Photo 2");
            theImages.put("photo3.jpg", "Photo 3");
            theImages.put("photo4.jpg", "Photo 4");

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the student and images..");
            session.persist(student);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
