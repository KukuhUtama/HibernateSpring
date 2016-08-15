/*
 * 
 */
package org.personal.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *@author kukuh.utama
 * The Class BaseEntity.
 */
@MappedSuperclass
public class BaseEntity {

	/** The created by. */
	@Column(name = "created_by")
	private String createdBy;

	/** The created time. */
	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = (createdBy == null ? "Admin" : createdBy);
	}

	/**
	 * Gets the created time.
	 *
	 * @return the created time
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * Sets the created time.
	 *
	 * @param createdTime
	 *            the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = (createdTime == null ? new Date() : createdTime);
	}

}
