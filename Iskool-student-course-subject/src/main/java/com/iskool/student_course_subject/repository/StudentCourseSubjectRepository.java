package com.iskool.student_course_subject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iskool.student_course_subject.repository.model.StudentCourseSubject;

@Repository
public interface StudentCourseSubjectRepository extends JpaRepository<StudentCourseSubject, String>{

	public Optional<StudentCourseSubject> findById(String student_id);
	
}
