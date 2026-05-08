package com.student.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private String email;
    
    @NotBlank(message = "Course is required")
    private String course;
    
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;
    
    @Column(length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;
    
    // NEW: Status field
    @Column(nullable = false)
    private String status = "ACTIVE";
    
    public Student() {}
    
    public Student(String name, String email, String course, int age, String phone, String status) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
        this.phone = phone;
        this.status = status != null ? status : "ACTIVE";
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    // NEW: Status getter and setter
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}