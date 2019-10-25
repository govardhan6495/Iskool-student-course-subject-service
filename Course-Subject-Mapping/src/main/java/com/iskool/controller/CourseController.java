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
import com.iskool.model.Student;
import com.iskool.model.Subject;
import com.iskool.services.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@PostMapping()
	public Course createCourse(@Valid @RequestBody Course course) {
		return courseService.createCource(course);
	}
	
	
	@GetMapping
	public List<Course> getCourse(){
		return courseService.getCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	@PutMapping
	public Course updateCourse(@Valid @RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCourse(@PathVariable Long id) {
		
		return courseService.deleteCourse(id);
	}
	
	@PostMapping("/{courseId}/subjects")
	public Set<Subject> getSubjects(@PathVariable Long courseId){
		return courseService.getSubjects(courseId);
	}
	
	@PostMapping("/{courseId}/subjects/{subjectId}")
	public Set<Subject> addSubject(@PathVariable Long courseId, @PathVariable Long subjectId){
		return courseService.addSubject(courseId, subjectId);
	}
	
	
	@PostMapping("/{courseId}/students")
	public Set<Student> getStudents(@PathVariable Long courseId){
		return courseService.getStudents(courseId);
	}
	
	@PostMapping("/{courseId}/students/{studentId}")
	public Set<Student> addStudent(@PathVariable Long courseId, @PathVariable Long studentId){
		return courseService.addStudent(courseId, studentId);
	}
	
	
}
