package com.AksHashes.coursemanagementportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name cannot be blank!")
    @Size(min=2, max=50, message = "Name must be between 2 and 50 characters!")
    private  String name;

    @Email(message = "Invalid email format")
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;
    //constructors
    public Student(){}

    public Student(String name, String email, Courses courses){
        this.name=name;
        this.email=email;
        this.courses=courses;
    }

    //getter/setters

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public Courses getCourses(){
        return courses;
    }
    public void setCourses(Courses courses){
        this.courses=courses;
    }
}