package com.hibernate.joined.Demo;

import com.hibernate.joined.Entity.Instructor;
import com.hibernate.joined.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserStudentInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student student1 = new Student("Dima", "Slepuxa", "slepoi@lama.lt","Hibernate");
            Instructor instructor1 = new Instructor("Pavel", "Zamaro", "zamaro@lama.lt", 20000.00);

            //start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the Student and Instructor...");

            session.save(student1);
            session.save(instructor1);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
