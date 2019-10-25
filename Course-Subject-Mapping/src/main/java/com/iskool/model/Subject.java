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

@SuppressWarnings("unused")
@Entity
@Table(name="subjects")
public class Subject extends Common{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column
	private int subject_type;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "subjects"
            )
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Course> courses = new HashSet<>();
	
	
	//CONSTRUCTORS
	
	public Subject() {
	
	}

	public Subject(Long id,String name, String description, int subject_type) {
		super(name, description);
		this.id = id;
		this.subject_type = subject_type;
	}

	//GETTERS AND SETTERS	
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}

	
	public int getSubject_type() {
		return subject_type;
	}
	public void setSubject_type(int subject_type) {
		this.subject_type = subject_type;
	}

	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
}
