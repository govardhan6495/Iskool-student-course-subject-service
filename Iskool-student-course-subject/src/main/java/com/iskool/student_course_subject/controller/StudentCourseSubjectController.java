package com.iskool.student_course_subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iskool.student_course_subject.model.StudentCourseSubject;
import com.iskool.student_course_subject.service.StudentCourseSubjectService;

@RestController
@RequestMapping("/StudentCourseSubjectDetails")
public class StudentCourseSubjectController {

	@Autowired
	private StudentCourseSubjectService studentCourseSubjectService;
	
	
	@PostMapping(path= "/create" )
	public boolean enterStudentCourseSubjectDetails(@RequestBody StudentCourseSubject studentCourseSubject ) {
		return studentCourseSubjectService.createStudentCourseSubjectDetails(studentCourseSubject);
	}
	
	
	@PostMapping(path= "/update")
	public boolean updateStudentCourseSubjectDetails(@RequestBody StudentCourseSubject studentCourseSubject) {
		
		return studentCourseSubjectService.updateStudentCourseSubjectDetails(studentCourseSubject);
	}
	
	@GetMapping(path= "/getAll")
	public List<StudentCourseSubject > getAllStudentCourseSubjectDetails(){
		
		return studentCourseSubjectService.getAllStudentCourseSubjectDetails();
	}
	
	@GetMapping(path= "/getById/{student_id}")
	public StudentCourseSubject getStudentCourseSubjectDetails(@PathVariable(value="student_id") String student_id) {
		
		return studentCourseSubjectService.getStudentCourseSubjectDeatilsById(student_id);
	}
	
	@GetMapping(path= "/delete/{student_id}")
	public void deleteStudentCourseSubjectDetails(@PathVariable(value="student_id") String student_id) {
		studentCourseSubjectService.deleteStudentCourseSubjectDetails(student_id);
	}
}
