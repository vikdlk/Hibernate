package com.hibernate.components.Demo;

import com.hibernate.components.Entity.Address;
import com.hibernate.components.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateStudentAddress {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Dima", "Slepuxa", "slepoi@lama.lt");

            Address homeAddress = new Address("Zerucio", "Vilnius", "LT2043");
            Address billingAddress = new Address("billingAddress Zerucio", "billingAddress Vilnius", "billingAddressLT2043");


            session.beginTransaction();

            System.out.println("Saving the Student and address...");
            student.setBillingAddress(billingAddress);
            student.setHomeAddress(homeAddress);
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
