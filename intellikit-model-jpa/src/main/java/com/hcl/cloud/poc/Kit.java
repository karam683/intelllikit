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
@Table(name = "Kit")
@NamedQuery(name = "AllKits", query = "select p from Kit p")

@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", length = 36)
public class Kit implements Serializable {

	private static final long serialVersionUID = 1L;

	public Kit() {
	}

	@Id
	private String kitId;
	@Column(insertable = false, updatable = false)
	private String tENANT_ID;
	private String kitStatus;
	private String kitLocation;
	private String currOwnerId;
	private String currOwnerRole;
	private String currOwnerName;
	private String currOwnerLocation;
	private String kitType;
	private String kitModel;
	private String firmwareVersion;
	private String buildNumber;
	private String buildBy;
	private String kitBattery;
	private String altitude;
	private String longitude;
	private String latitude;
	private String prevOwnerId;
	private String prevOwnerName;
	private String prevOwnerRole;
	private String transactionType;
	private String transactionMode;
	private String toolName1;
	private String toolName1Status;
	private String toolName2;
	private String toolName2Status;
	private String toolName3;
	private String toolName3Status;
	private String kitLifeCycles;
	private String surgeryId;
	@Temporal(TIMESTAMP)
	private java.util.Date lastSterilized;
	@Temporal(TIMESTAMP)
	private java.util.Date lastReceived;
	@Temporal(TIMESTAMP)
	private java.util.Date lastUpdated;
	

	public String getTENANT_ID() {
		return tENANT_ID;
	}

	public void setTENANT_ID(String param) {
		this.tENANT_ID = param;
	}

	public String getKitId() {
		return kitId;
	}

	public void setKitId(String param) {
		this.kitId = param;
	}

	public String getKitType() {
		return kitType;
	}

	public void setKitType(String param) {
		this.kitType = param;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String param) {
		this.firmwareVersion = param;
	}

	public String getKitStatus() {
		return kitStatus;
	}

	public void setKitStatus(String kitStatus) {
		this.kitStatus = kitStatus;
	}

	public String getKitLocation() {
		return kitLocation;
	}

	public void setKitLocation(String kitLocation) {
		this.kitLocation = kitLocation;
	}

	public String getCurrOwnerId() {
		return currOwnerId;
	}

	public void setCurrOwnerId(String currOwnerId) {
		this.currOwnerId = currOwnerId;
	}

	public String getCurrOwnerRole() {
		return currOwnerRole;
	}

	public void setCurrOwnerRole(String currOwnerRole) {
		this.currOwnerRole = currOwnerRole;
	}

	public String getCurrOwnerName() {
		return currOwnerName;
	}

	public void setCurrOwnerName(String currOwnerName) {
		this.currOwnerName = currOwnerName;
	}

	public String getCurrOwnerLocation() {
		return currOwnerLocation;
	}

	public void setCurrOwnerLocation(String currOwnerLocation) {
		this.currOwnerLocation = currOwnerLocation;
	}

	public String getKitModel() {
		return kitModel;
	}

	public void setKitModel(String kitModel) {
		this.kitModel = kitModel;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public String getBuildBy() {
		return buildBy;
	}

	public void setBuildBy(String buildBy) {
		this.buildBy = buildBy;
	}

	public String getKitBattery() {
		return kitBattery;
	}

	public void setKitBattery(String kitBattery) {
		this.kitBattery = kitBattery;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPrevOwnerId() {
		return prevOwnerId;
	}

	public void setPrevOwnerId(String prevOwnerId) {
		this.prevOwnerId = prevOwnerId;
	}

	public String getPrevOwnerName() {
		return prevOwnerName;
	}

	public void setPrevOwnerName(String prevOwnerName) {
		this.prevOwnerName = prevOwnerName;
	}

	public String getPrevOwnerRole() {
		return prevOwnerRole;
	}

	public void setPrevOwnerRole(String prevOwnerRole) {
		this.prevOwnerRole = prevOwnerRole;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getToolName1() {
		return toolName1;
	}

	public void setToolName1(String toolName1) {
		this.toolName1 = toolName1;
	}

	public String getToolName1Status() {
		return toolName1Status;
	}

	public void setToolName1Status(String toolName1Status) {
		this.toolName1Status = toolName1Status;
	}

	public String getToolName2() {
		return toolName2;
	}

	public void setToolName2(String toolName2) {
		this.toolName2 = toolName2;
	}

	public String getToolName2Status() {
		return toolName2Status;
	}

	public void setToolName2Status(String toolName2Status) {
		this.toolName2Status = toolName2Status;
	}

	public String getToolName3() {
		return toolName3;
	}

	public void setToolName3(String toolName3) {
		this.toolName3 = toolName3;
	}

	public String getToolName3Status() {
		return toolName3Status;
	}

	public void setToolName3Status(String toolName3Status) {
		this.toolName3Status = toolName3Status;
	}

	public String getKitLifeCycles() {
		return kitLifeCycles;
	}

	public void setKitLifeCycles(String kitLifeCycles) {
		this.kitLifeCycles = kitLifeCycles;
	}

	public String getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date param) {
		this.lastUpdated = param;
	}
	
	public Date getLastSterilized() {
		return lastSterilized;
	}

	public void setLastSterilized(Date param) {
		this.lastSterilized = param;
	}
	public Date getLastReceived() {
		return lastReceived;
	}

	public void setLastReceived(Date param) {
		this.lastReceived = param;
	}
}