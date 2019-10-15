package com.iskool.student_course_subject.query.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.iskool.student_course_subject.repository.StudentCourseSubjectRepository;

public class StudentCourseSubjectQueryHandler {

	@Autowired
	private StudentCourseSubjectRepository studentCourseSubjectRepository;

	
	public StudentCourseSubjectRepository getStudentCourseSubjectRepository() {
		return studentCourseSubjectRepository;
	}

	public void setStudentCourseSubjectRepository(StudentCourseSubjectRepository studentCourseSubjectRepository) {
		this.studentCourseSubjectRepository = studentCourseSubjectRepository;
	}
	
	
	
}
