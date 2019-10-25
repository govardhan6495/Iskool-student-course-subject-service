package com.iskool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="students")
public class Student extends ModelAudit{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String studentid;
	
	private String password;
	
	private String organization_id;
	
	private int enabled;
	
	private int expired;
	
	private String locked;
	

	@ManyToMany(
			fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "students"
            )
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Course> courses = new HashSet<>();
	
	
	// CONSTRUCTORS
	
	public Student() {
		
	}


	public Student(Long id, String firstName, String lastName, String email, String studentid, String password,
			String organization_id, int enabled, int expired, String locked) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studentid = studentid;
		this.password = password;
		this.organization_id = organization_id;
		this.enabled = enabled;
		this.expired = expired;
		this.locked = locked;
	}

			//GETTERS AND SETTERS	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStudentid() {
		return studentid;
	}


	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getOrganization_id() {
		return organization_id;
	}


	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}


	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	public int getExpired() {
		return expired;
	}


	public void setExpired(int expired) {
		this.expired = expired;
	}


	public String getLocked() {
		return locked;
	}


	public void setLocked(String locked) {
		this.locked = locked;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
}
