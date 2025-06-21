package com.hibernatepractice.HibernatePractice.repository;

import com.hibernatepractice.HibernatePractice.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Page<Student> findAll(Pageable pageable);
}