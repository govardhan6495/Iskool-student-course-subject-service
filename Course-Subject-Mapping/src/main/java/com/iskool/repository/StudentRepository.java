package com.iskool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iskool.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
