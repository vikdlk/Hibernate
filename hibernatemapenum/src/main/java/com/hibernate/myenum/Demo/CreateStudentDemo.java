package com.hibernate.myenum.Demo;

import com.hibernate.myenum.Entity.Status;
import com.hibernate.myenum.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student student1 = new Student("Dima", "Slepuxa", "slepoi@lama.lt", Status.ACTIVE);
            Student student2 = new Student("Pavel", "Zamaro", "zamaro@lama.lt", Status.INACTIVE);


            session.beginTransaction();

            System.out.println("Saving the Student...");

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
