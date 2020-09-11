package com.hibernate.collection.Demo;

import com.hibernate.collection.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentSortSet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Viktor", "Dlk", "alex@lzd.lt");
            Set<String> theImages = student.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo5.jpg");

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the student and images..");
            session.persist(student);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");


        } finally {
            session.close();
            factory.close();
        }

    }
}
