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
@Table(name = "KitRequest")
@NamedQuery(name = "AllKitRequests", query = "select p from KitRequest p")

@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", length = 36)
public class KitRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public KitRequest() {
	}

	@Id
	private String surgeryId;
	@Column(insertable = false, updatable = false)
	private String tENANT_ID;
	private String kitType;
	private String hospitalLocation;
	private String requestType;
	private String requestorId;
	private String requestorName;
	private String requestorRole;
	private String createdBy;
	private String updatedBy;
	@Temporal(TIMESTAMP)
	private java.util.Date requestedByDate;
	@Temporal(TIMESTAMP)
	private java.util.Date createdDate;
	@Temporal(TIMESTAMP)
	private java.util.Date updatedDate;
	

	public String getTENANT_ID() {
		return tENANT_ID;
	}

	public void setTENANT_ID(String param) {
		this.tENANT_ID = param;
	}

	public String getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date param) {
		this.updatedDate = param;
	}
	
	public Date getRequestedByDate() {
		return requestedByDate;
	}

	public void setRequestedByDate(Date param) {
		this.requestedByDate = param;
	}
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date param) {
		this.createdDate = param;
	}

	public String getKitType() {
		return kitType;
	}

	public void setKitType(String kitType) {
		this.kitType = kitType;
	}

	public String getHospitalLocation() {
		return hospitalLocation;
	}

	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(String requestorId) {
		this.requestorId = requestorId;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public String getRequestorRole() {
		return requestorRole;
	}

	public void setRequestorRole(String requestorRole) {
		this.requestorRole = requestorRole;
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