package com.hibernate.inheritance.tableperclass.Entity;

import javax.persistence.Entity;

@Entity
public class Student extends User {

    private String course;

    public Student(String fistName, String lastName, String email, String course) {
        super(fistName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
