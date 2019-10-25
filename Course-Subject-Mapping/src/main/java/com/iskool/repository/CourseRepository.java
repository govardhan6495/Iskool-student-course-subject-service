package com.iskool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iskool.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
