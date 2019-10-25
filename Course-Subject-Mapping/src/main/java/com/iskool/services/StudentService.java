package com.iskool.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iskool.exception.ResourceNotFoundException;
import com.iskool.model.Course;
import com.iskool.model.Student;
import com.iskool.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public  Student createStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public Student getStudent(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Student", id)
					);
	}

	public List<Student> getStudent(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.findById(student.getId())
				.map(
						(toUpdate) -> {
							
							toUpdate.setId(student.getId());
							toUpdate.setFirstName(student.getFirstName());
							toUpdate.setLastName(student.getLastName());
							toUpdate.setEmail(student.getEmail());
							toUpdate.setStudentid(student.getStudentid());
							toUpdate.setPassword(student.getPassword());
							toUpdate.setOrganization_id(student.getPassword());
							toUpdate.setEnabled(student.getEnabled());
							toUpdate.setExpired(student.getExpired());
							toUpdate.setLocked(student.getLocked());
							
							return studentRepository.save(toUpdate);
						}).orElseThrow(
								  () -> new ResourceNotFoundException("Student", student.getId())
								);
						
	}
	
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteStudent(Long id) {
		return studentRepository.findById(id)
				.map(
						(toDelete) -> {
							studentRepository.delete(toDelete);
							return ResponseEntity.ok("Student with Id " + id + " deleted " );
						}).orElseThrow(
								() -> new ResourceNotFoundException("Student", id)
								);
	}
	
	public Set<Course> getCourses(Long studentId){
		return studentRepository.findById(studentId)
				.map(
						(student) -> {
							return student.getCourses();
						}).orElseThrow(
								() -> new ResourceNotFoundException("Student", studentId)
								);
	}
 
	
}
