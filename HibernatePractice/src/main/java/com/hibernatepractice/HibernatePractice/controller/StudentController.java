package com.hibernatepractice.HibernatePractice.controller;

import com.hibernatepractice.HibernatePractice.dto.StudentDto;
import com.hibernatepractice.HibernatePractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        try {
            StudentDto studtDto = studentService.createNewStudent(studentDto);
            return new ResponseEntity<StudentDto>(studtDto, HttpStatus.CREATED);
        } catch (Exception e) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//            pd.setType(URI.create("https://localhost:8000/1749673743737-internal-server-error"));
            pd.setTitle("Internal Server Error");
            pd.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            pd.setDetail(e.getMessage());
            pd.setInstance(URI.create("Student"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(pd);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() throws Exception {
        List<StudentDto> listStudsDto = studentService.getAllStudents();
        if (listStudsDto.size() == 0) {
            return ResponseEntity.status(HttpStatus.OK).body("List is empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listStudsDto);
    }
}