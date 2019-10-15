package com.iskool.student_course_subject.service;

import java.util.List;

import com.iskool.student_course_subject.model.StudentCourseSubject;

public interface StudentCourseSubjectService {

	public boolean createStudentCourseSubjectDetails(StudentCourseSubject studentCourseSubject);
	
	List<StudentCourseSubject> getAllStudentCourseSubjectDetails();
	
	StudentCourseSubject getStudentCourseSubjectDeatilsById(String student_id);
	
	
	boolean updateStudentCourseSubjectDetails(StudentCourseSubject studentCourseSubject);
	
	
	void deleteStudentCourseSubjectDetails(String student_id);
	
	
	
}
