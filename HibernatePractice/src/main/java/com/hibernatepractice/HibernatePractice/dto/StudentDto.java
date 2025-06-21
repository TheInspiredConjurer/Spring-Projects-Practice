package com.hibernatepractice.HibernatePractice.dto;

import com.hibernatepractice.HibernatePractice.entity.Student;

public class StudentDto {
    private String name;
    private String college;
    private String phone;
    private String fatherName;
    private Boolean active = true;
    private String about;

    public StudentDto(String name, String college, String phone, String fatherName, Boolean active, String about) {
        this.name = name;
        this.college = college;
        this.phone = phone;
        this.fatherName = fatherName;
        this.active = active;
        this.about = about;
    }

    public static StudentDto convertEntityToDto(Student student) {
        return new StudentDto(student.getName(), student.getCollege(), student.getPhone(), student.getFatherName(), student.getActive(), student.getAbout());
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
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", phone='" + phone + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", active=" + active +
                ", about='" + about + '\'' +
                '}';
    }
}