package com.ronak.studentapi;

import jakarta.persistence.*;

@Entity                     // Marks this as a DB table
@Table(name ="Students")    // table name in database
public class Student {

    @Id                         // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Increment
    private Long id;

    private String name;
    private int age;
    private String grade;

    //Default  Constructor (JPA needs this!)
    public Student( ) {}

    //Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    //Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {this.name = name; }


    public int getAge() { return age; }
    public void setAge(int age) {this.age = age; }


    public String getGrade() { return grade; }
    public void setGrade(String grade) {this.grade = grade; }
}
