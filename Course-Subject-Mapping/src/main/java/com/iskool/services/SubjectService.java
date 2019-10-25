package com.iskool.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iskool.exception.ResourceNotFoundException;
import com.iskool.model.Course;
import com.iskool.model.Subject;
import com.iskool.repository.CourseRepository;
import com.iskool.repository.SubjectRepository;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@SuppressWarnings("unused")
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public Subject getSubject(Long id) {
		return subjectRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Subject", id)
					);
	}
	
	public List<Subject> getSubject(){
		return subjectRepository.findAll();
	}
	
	public Subject updateSubject(Subject subject) {
		return subjectRepository.findById(subject.getId())
				.map(
					  (toUpdate) -> {
						
						  toUpdate.setId(subject.getId());
						  toUpdate.setName(subject.getName());
						  toUpdate.setDescription(subject.getDescription());
						  toUpdate.setSubject_type(subject.getSubject_type());
					  	  return subjectRepository.save(toUpdate);
					  
					  }).orElseThrow(
							  () -> new ResourceNotFoundException("Subject", subject.getId())
							);
	}
	
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteSubject(Long id) {
		return subjectRepository.findById(id)
				.map(
						(toDelete) -> {
							subjectRepository.delete(toDelete);
							return ResponseEntity.ok("Subject with Id "+ id + " deleted");
						}).orElseThrow(
								() -> new ResourceNotFoundException("Subject", id)
								);
	}
	
	
	public Set<Course> getCourses(Long subjectId){
		return subjectRepository.findById(subjectId)
				.map(
						(subject) -> {
							return subject.getCourses();
						}).orElseThrow(
								() -> new ResourceNotFoundException("Subject", subjectId)
								);
	}
	
	
	
}
