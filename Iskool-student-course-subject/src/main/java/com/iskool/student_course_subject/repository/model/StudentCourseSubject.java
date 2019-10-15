package com.iskool.student_course_subject.repository.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="StudentCourseSubject")
public class StudentCourseSubject implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String student_id;
	private int course_id;
	private int subject_id;

	public StudentCourseSubject() {
		super();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	@Override
	public String toString() {
		return "StudentCourseSubject [student_id=" + student_id + ", course_id=" + course_id + ", subject_id="
				+ subject_id + "]";
	}
	
	



}
