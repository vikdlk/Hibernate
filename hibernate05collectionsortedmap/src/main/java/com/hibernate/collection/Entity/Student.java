package com.hibernate.collection.Entity;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String fistName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name="image")
    @MapKeyColumn(name="file_name") //Maps Key
    @Column(name="image_name") //Maps Value
	@OrderBy
//    @SortComparator(ReverseStringComparator.class)
    private SortedMap<String, String> images = new TreeMap<>();

    //Reverse String
//    public static class ReverseStringComparator implements Comparator<String>{
//
//        @Override
//        public int compare(String o1, String o2) {
//
//            return o2.compareTo(o1);
//        }
//
//    }

    public Student() {
    }

    public Student(String fistName, String lastName, String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SortedMap<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}