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
    
    // Status field
    @Column(nullable = false)
    private String status = "ACTIVE";
    
    // Roll Number field
    @Column(unique = true)
    private String rollNumber;
    
    // Student Class field (e.g., 10th, 12th)
    private String studentClass;
    
    // ✅ NEW: Parent Details fields
    private String fatherName;
    private String motherName;
    
    @Column(length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Parent phone number must be 10 digits")
    private String parentPhone;
    
    public Student() {}
    
    public Student(String name, String email, String course, int age, String phone, String status, 
                   String rollNumber, String studentClass, String fatherName, String motherName, String parentPhone) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
        this.phone = phone;
        this.status = status != null ? status : "ACTIVE";
        this.rollNumber = rollNumber;
        this.studentClass = studentClass;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.parentPhone = parentPhone;
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
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    
    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }
    
    // ✅ NEW: Parent Details Getters and Setters
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    
    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }
    
    public String getParentPhone() { return parentPhone; }
    public void setParentPhone(String parentPhone) { this.parentPhone = parentPhone; }
}