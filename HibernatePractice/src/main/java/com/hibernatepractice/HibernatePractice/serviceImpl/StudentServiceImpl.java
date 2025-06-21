package com.hibernatepractice.HibernatePractice.serviceImpl;

import com.hibernatepractice.HibernatePractice.dto.StudentDto;
import com.hibernatepractice.HibernatePractice.entity.Student;
import com.hibernatepractice.HibernatePractice.repository.StudentRepository;
import com.hibernatepractice.HibernatePractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto createNewStudent(StudentDto studentDto) {
        return StudentDto.convertEntityToDto(studentRepository.save(Student.convertDtoToEntity(studentDto)));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 5);
        List<StudentDto> a = studentRepository.findAll(firstPageWithTwoElements).stream().map(stu -> StudentDto.convertEntityToDto(stu)).collect(Collectors.toList());
        return a;
    }
}