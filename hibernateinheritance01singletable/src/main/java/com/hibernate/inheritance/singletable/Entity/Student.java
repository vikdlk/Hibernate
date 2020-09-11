package com.hibernate.inheritance.singletable.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MyStud")
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
