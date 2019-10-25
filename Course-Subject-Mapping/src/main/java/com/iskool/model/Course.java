package com.iskool.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class Course extends Common{

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column
	private int durationInMonths;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
//			mappedBy = "courses"
            )
	@JoinTable(
			name="course_subjects",
			joinColumns = {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="subject_id")}
			)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Subject> subjects = new HashSet<>();
	
	@ManyToMany(
			fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
//            mappedBy = "courses"
            )
	@JoinTable(
			name="course_students",
			joinColumns = {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="student_id")}
			)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Student> students = new HashSet<>();
	
	
	
	// CONSTRUCTORS
	
	public Course() {
	
	}


	public Course(Long id,String name, String description, int durationInMonths) {
		super(name, description);
		this.id = id;
		this.durationInMonths = durationInMonths;
	}

	// GETTERS AND SETTERS
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}


	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}


	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
}
