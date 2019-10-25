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
import com.iskool.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping()
	public Student createStudent(@Valid @RequestBody Student student) {
		
		return studentService.createStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
	}
	
	@GetMapping()
	public List<Student> getStudent(){
		return studentService.getStudent();
	}
	
	@PutMapping()
	public Student updateStudent(@Valid @RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/{studentId}/courses")
	public Set<Course> getCourses(@PathVariable Long studentId){
		return studentService.getCourses(studentId);
	}
	
}
