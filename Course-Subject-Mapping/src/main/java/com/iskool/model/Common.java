package com.iskool.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Common extends ModelAudit{

	
	private static final long serialVersionUID = 1L;
	
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	
			//Constructors
	
	public Common() {
	
	}


	public Common(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

		// Getters and Setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
	
}
