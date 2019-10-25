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
import com.iskool.model.Subject;
import com.iskool.repository.CourseRepository;
import com.iskool.repository.StudentRepository;
import com.iskool.repository.SubjectRepository;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	//create	
	public Course createCource(Course course) {
				
		return courseRepository.save(course);
	}
	
	//getAll	
	public List<Course> getCourse(){
		return courseRepository.findAll();
	}
	
	//getById	
	public Course getCourse(Long id) {

		return courseRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Course", id)
					);
	}
	
	//update course
	public Course updateCourse(Course course) {	
		return courseRepository.findById(course.getId())
				.map(
					  (toUpdate) -> {
						  toUpdate.setId(course.getId());
						  toUpdate.setName(course.getName());
						  toUpdate.setDescription(course.getDescription());
						  toUpdate.setDurationInMonths(course.getDurationInMonths());
						  
						  return courseRepository.save(toUpdate);
					   
					  }).orElseThrow(
							   () -> new ResourceNotFoundException("Course", course.getId())
							   );
	}
	
	// delete by Id
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteCourse(Long id) {  
		return courseRepository.findById(id)
				.map(
					  (toDelete) -> {
						  courseRepository.delete(toDelete);
						  return ResponseEntity.ok("Course with id" + id + "deleted");
					  }
					).orElseThrow(
							() -> new ResourceNotFoundException("Course", id)
							);
	}	
	
	// getting subject for particular courseId
	public Set<Subject> getSubjects(Long courseId){
		return courseRepository.findById(courseId)
				.map(
						(course) -> {
							return course.getSubjects();
						}
						).orElseThrow(
								() -> new ResourceNotFoundException("Course", courseId) 
								);
	}
	
	// mapping courseId to subjectId 
	// adding/setting subjectId to courseId
	public Set<Subject> addSubject(Long courseId, Long subjectId){
		
	Subject subject = subjectRepository.findById(subjectId)
			.orElseThrow(
					() -> new ResourceNotFoundException("Subject", subjectId)
					);
	return courseRepository.findById(courseId)
			.map(
					(course) -> {
						course.getSubjects().add(subject);
						return courseRepository.save(course).getSubjects();
					}
					
					).orElseThrow(
							() -> new ResourceNotFoundException("Course", courseId)
							);
	}
	
	
	
	// getting Student for particular courseId
			public Set<Student> getStudents(Long courseId){
				return courseRepository.findById(courseId)
						.map(
								(course) -> {
									return course.getStudents();
								}
								).orElseThrow(
										() -> new ResourceNotFoundException("Course", courseId) 
										);
			}
			
			// mapping courseId to StudentId 
			// adding/setting StudentId to courseId
			public Set<Student> addStudent(Long courseId, Long studentId){
				
				Student student = studentRepository.findById(studentId)
					.orElseThrow(
							() -> new ResourceNotFoundException("Student", studentId)
							);
			return courseRepository.findById(courseId)
					.map(
							(course) -> {
								course.getStudents().add(student);
								return courseRepository.save(course).getStudents();
							}
							
							).orElseThrow(
									() -> new ResourceNotFoundException("Course", courseId)
									);
			}
	
}
