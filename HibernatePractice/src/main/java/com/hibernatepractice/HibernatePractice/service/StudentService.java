package com.hibernatepractice.HibernatePractice.service;

import com.hibernatepractice.HibernatePractice.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

    public StudentDto createNewStudent(StudentDto studentDto);

    public List<StudentDto> getAllStudents();
}