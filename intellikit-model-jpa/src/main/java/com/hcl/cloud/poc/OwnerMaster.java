package com.hcl.cloud.poc;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

@Entity
@Table(name = "OwnerMaster")
@NamedQuery(name = "AllOwners", query = "select p from OwnerMaster p")

@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", length = 36)
public class OwnerMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	public OwnerMaster() {
	}

	@Id
	private String ownerId;
	@Column(insertable = false, updatable = false)
	private String tENANT_ID;
	private String ownerRole;
	private String ownerName;
	private String ownerLocation;
	private String contactPersonName;
	private String contactPersonPhone;
	private String username;
	private String password;
	private String latitude;
	private String longitude;	
	private String createdBy;
	private String updatedBy;
	@Temporal(TIMESTAMP)
	private java.util.Date createdDate;
	@Temporal(TIMESTAMP)
	private java.util.Date updatedDate;
	

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String param) {
		this.ownerId = param;
	}
	
	public String getTENANT_ID() {
		return tENANT_ID;
	}

	public void setTENANT_ID(String param) {
		this.tENANT_ID = param;
	}

	
	public String getOwnerRole() {
		return ownerRole;
	}

	public void setOwnerRole(String ownerRole) {
		this.ownerRole = ownerRole;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerLocation() {
		return ownerLocation;
	}

	public void setOwnerLocation(String ownerLocation) {
		this.ownerLocation = ownerLocation;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date param) {
		this.updatedDate = param;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date param) {
		this.createdDate = param;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}