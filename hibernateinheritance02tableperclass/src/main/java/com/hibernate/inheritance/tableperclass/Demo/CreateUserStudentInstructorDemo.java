package com.hibernate.inheritance.tableperclass.Demo;

import com.hibernate.inheritance.tableperclass.Entity.Instructor;
import com.hibernate.inheritance.tableperclass.Entity.Student;
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


            session.beginTransaction();

            System.out.println("Saving the Student and Instructor...");

            session.save(student1);
            session.save(instructor1);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
