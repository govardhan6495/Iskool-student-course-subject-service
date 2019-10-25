package com.iskool.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iskool.model.Course;
import com.iskool.model.Subject;
import com.iskool.services.SubjectService;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping()
	public Subject createSubject(@Valid @RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}
	
	@GetMapping("/{id}")
	public Subject getSubject(@PathVariable Long id) {
		return subjectService.getSubject(id);
	}
	
	@GetMapping()
	public List<Subject> getSubject(){
		return subjectService.getSubject();
	}
	
	@PutMapping()
	public Subject updateSubject(@Valid @RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteSubject(@PathVariable Long id) {
		return subjectService.deleteSubject(id);
	} 
	
	@GetMapping("/{subjectId}/courses")
	public Set<Course> getCourses(@PathVariable Long subjectId){
		return subjectService.getCourses(subjectId);
	}
	
}
