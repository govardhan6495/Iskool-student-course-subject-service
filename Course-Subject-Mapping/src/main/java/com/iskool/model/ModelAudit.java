package com.iskool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ModelAudit implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@Column(nullable=false, updatable=false)
	private Date createdAt;
	
	
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(nullable=false)
	private Date updatedAt;

	
		//	Constructor

	public ModelAudit() {
	
	}

		// Getters and Setters

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
