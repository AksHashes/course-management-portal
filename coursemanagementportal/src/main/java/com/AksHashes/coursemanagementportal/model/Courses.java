package com.AksHashes.coursemanagementportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.action.internal.OrphanRemovalAction;
import java.util.List;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name cannot be blank!")
    @Size(min = 2, max = 100, message = "Course name should be under 2-100 characters")
    private String name;

    @NotBlank(message = "Course description cannot be blank!")
    @Size(min = 10, max = 500, message = "Course description should be under 10-500 characters")
    private String description;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
    //default constructor
    public Courses(){}

    //Constructor with parameters
    public Courses(String name, String description){
        this.name=name;
        this.description=description;
    }
    //Getter and Setters
        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id=id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description=description;
        }
        public List<Student> getStudents(){
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }
}
