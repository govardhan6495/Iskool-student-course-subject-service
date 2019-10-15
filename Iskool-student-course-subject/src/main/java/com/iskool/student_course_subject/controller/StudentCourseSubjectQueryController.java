package com.iskool.student_course_subject.controller;

import org.axonframework.config.ProcessingGroup;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iskool.student_course_subject.repository.StudentCourseSubjectRepository;


@SuppressWarnings("unused")
@Service
@ProcessingGroup("StudentCourseSubjects")
public class StudentCourseSubjectQueryController {

	
	@Autowired
	private StudentCourseSubjectRepository studentCourseSubjectRepository;

	public StudentCourseSubjectQueryController(StudentCourseSubjectRepository studentCourseSubjectRepository) {
		this.studentCourseSubjectRepository = studentCourseSubjectRepository;
	}
	

	/*
	
	@EventHandler
	public StudentCourseSubject on(StudentCourseSubjectDetailsFoundEvent event) {
		StudentCourseSubject studentCourseSubject  = studentCourseSubjectRepository.findById(event.getId()).get();
		
		System.out.println("in on event");
		System.out.println(" studentCourseSubject is "+ studentCourseSubjec.toString() );
	
		return studentCourseSubject;
	}
	
	*/
}
