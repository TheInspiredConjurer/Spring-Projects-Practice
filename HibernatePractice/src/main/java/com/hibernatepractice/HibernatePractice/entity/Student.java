package com.hibernatepractice.HibernatePractice.entity;

import com.hibernatepractice.HibernatePractice.dto.StudentDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Student") // to customize table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name", unique = true)
    private String name;

    private String college;
    private String phone;
    private String fatherName;
    private Boolean active;
    @Lob
    private String about;

    public Student() {
    }

    public Student(Long id, String name, String college, String phone, String fatherName, Boolean active, String about) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.phone = phone;
        this.fatherName = fatherName;
        this.active = active;
        this.about = about;
    }

    public Student(String name, String college, String phone, String fatherName, Boolean active, String about) {
        this.name = name;
        this.college = college;
        this.phone = phone;
        this.fatherName = fatherName;
        this.active = active;
        this.about = about;
    }

    public static Student convertDtoToEntity(StudentDto studentDto) {
        return new Student(studentDto.getName(), studentDto.getCollege(), studentDto.getPhone(), studentDto.getFatherName(), studentDto.getActive(), studentDto.getAbout());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", phone='" + phone + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", active=" + active +
                ", about='" + about + '\'' +
                '}';
    }


}