package com.iskool.student_course_subject.service.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iskool.student_course_subject.model.StudentCourseSubject;
import com.iskool.student_course_subject.repository.StudentCourseSubjectRepository;
import com.iskool.student_course_subject.service.StudentCourseSubjectService;

@Service
@Transactional
public class StudentCourseSubjectServiceImpl implements StudentCourseSubjectService{

	@Autowired
	private StudentCourseSubjectRepository studentCourseSubjectRepository; 
	
	
	DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
	
	
	@Override
	public boolean createStudentCourseSubjectDetails(StudentCourseSubject studentCourseSubject) {
		
		com.iskool.student_course_subject.repository.model.StudentCourseSubject repoStudentCourseSubject = 
				dozerBeanMapper.map(studentCourseSubject, com.iskool.student_course_subject.repository.model.StudentCourseSubject.class);
		
		com.iskool.student_course_subject.repository.model.StudentCourseSubject savedStudentCourseSubject = 
				studentCourseSubjectRepository.save(repoStudentCourseSubject);
		
		if(savedStudentCourseSubject != null) {
			return true;
		}
		
		return false;
	}

	
	@Override
	public List<StudentCourseSubject> getAllStudentCourseSubjectDetails() {
		
		List<StudentCourseSubject> restStudentCourseSubjects = new ArrayList<StudentCourseSubject>();
		
		List<com.iskool.student_course_subject.repository.model.StudentCourseSubject> studentCourseSubjects = 
			(List<com.iskool.student_course_subject.repository.model.StudentCourseSubject>)	studentCourseSubjectRepository.findAll();
		
		for(Iterator<com.iskool.student_course_subject.repository.model.StudentCourseSubject> iterator = studentCourseSubjects.iterator(); iterator.hasNext();) {
			
			com.iskool.student_course_subject.repository.model.StudentCourseSubject repoStudentCourseSubject = 
					(com.iskool.student_course_subject.repository.model.StudentCourseSubject) iterator.next();
			
			StudentCourseSubject restStudentCourseSubject = dozerBeanMapper.map(repoStudentCourseSubject, StudentCourseSubject.class);
			
			restStudentCourseSubjects.add(restStudentCourseSubject);
		}
		
		
		if(restStudentCourseSubjects.size() != 0) {
			return restStudentCourseSubjects;
		}
		
		
		return null;
	
	}

	
	@Override
	public StudentCourseSubject getStudentCourseSubjectDeatilsById(String student_id) {
		
		Optional<com.iskool.student_course_subject.repository.model.StudentCourseSubject> studentCourseSubject = 
				studentCourseSubjectRepository.findById(student_id);
		
		if(studentCourseSubject.get() != null ) {
			StudentCourseSubject restStudentCourseSubject = dozerBeanMapper.map(studentCourseSubject.get(), StudentCourseSubject.class);
			return restStudentCourseSubject;
		}
		
		
		return null;
	}

	@Override
	public boolean updateStudentCourseSubjectDetails(StudentCourseSubject studentCourseSubject) {
		
		Optional<com.iskool.student_course_subject.repository.model.StudentCourseSubject> repoStudentCourseSubject = 
				studentCourseSubjectRepository.findById(studentCourseSubject.getStudent_id());
		
		if(repoStudentCourseSubject.get() != null ) {
			
			repoStudentCourseSubject.get().setCourse_id(studentCourseSubject.getCourse_id());
			repoStudentCourseSubject.get().setSubject_id(studentCourseSubject.getSubject_id());
			
			com.iskool.student_course_subject.repository.model.StudentCourseSubject savedCourseSubject = 
					studentCourseSubjectRepository.save(repoStudentCourseSubject.get());
			
			if(savedCourseSubject != null) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void deleteStudentCourseSubjectDetails(String student_id) {
		Optional<com.iskool.student_course_subject.repository.model.StudentCourseSubject> studentCourseSubject = 
				studentCourseSubjectRepository.findById(student_id);
		
		if(studentCourseSubject.get() != null ) {
			studentCourseSubjectRepository.delete(studentCourseSubject.get());
		}
		
	}

}
