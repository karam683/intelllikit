package com.hcl.cloud.poc.odata.service;

import static org.apache.olingo.odata2.api.annotation.edm.EdmType.STRING;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.text.DateFormatter;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.HttpMethod;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.apache.olingo.odata2.api.annotation.edm.EdmType;

import com.hcl.cloud.poc.Kit;
import com.hcl.cloud.poc.KitRequest;



public class IntelliKitFunctionImport {

	EntityManager em;
	
	public IntelliKitFunctionImport()
	{
		EntityManagerFactory emf;
		String currentTenantId;
		HashMap properties=null;
		try {
			emf = JpaEntityManagerFactory.getEntityManagerFactory();
			currentTenantId=IntelliKitServiceFactory.getTenantId();
			properties = new HashMap();
			properties.put("eclipselink.tenant-id",currentTenantId);
			
			 em= emf.createEntityManager(properties);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	@EdmFunctionImport(name = "getTenantId", returnType = @ReturnType(type = Type.SIMPLE, isCollection = false),
    httpMethod = HttpMethod.GET)
	public String getTenantId()
	{
		String tenantId=null;
		tenantId=IntelliKitServiceFactory.getTenantId();
		if(tenantId!=null)
		{
		return tenantId;
		}
		else
			return "Tenant Id Not Found";
	}
	
	@SuppressWarnings("unchecked")
	@EdmFunctionImport(name = "getKitStatus", entitySet = "Kits",returnType = @ReturnType(type = Type.SIMPLE, isCollection = false),
    httpMethod = HttpMethod.GET)
	public String getKitStatus(
			@EdmFunctionImportParameter(name = "kitId",type =STRING)    
    final String kitId)
	{
		String kitStatus=null;
		//String currentOwnerRole=null;
		//String kitOpenClosed=null;
		
		Query q = em.createQuery("SELECT E1 from Kit E1 WHERE E1.kitId = '"
		           + kitId + "'");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    if(kitList.isEmpty())
		    {
		    	kitStatus = "Kit Not Available";
		    	return kitStatus; 
		    }
		    
		    Kit kit = (Kit) q.getResultList().get(0);
		     
		    kitStatus=kit.getKitStatus();
		    	
		    if(kitStatus!=null && !kitStatus.equals("") )
		    {
		    	return kitStatus;
		    }
		    else
		    {
		    	kitStatus = "Kit Status Not Available";
		    }
		    	
		    		
		return kitStatus;
	}
	
	@EdmFunctionImport(name = "getAssignedKits", entitySet = "Kits", returnType = @ReturnType(
		    type = Type.ENTITY, isCollection = true))
		public List<Kit> getAssignedKits()
		    {
 
		   Query q = em.createQuery("SELECT E1 from Kit E1 WHERE E1.currOwnerRole ='Distributor' AND E1.surgeryId !=''");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    return kitList;
		}
	@EdmFunctionImport(name = "getInventoryKits", entitySet = "Kits", returnType = @ReturnType(
		    type = Type.ENTITY, isCollection = true))
		public List<Kit> getInventoryKits()
		    {
 
		   Query q = em.createQuery("SELECT E1 from Kit E1 WHERE E1.currOwnerRole ='Distributor' AND E1.surgeryId =''");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    return kitList;
		}
	@EdmFunctionImport(name = "getKitsByOwnerRole", entitySet = "Kits", returnType = @ReturnType(
		    type = Type.ENTITY, isCollection = true))
		public List<Kit> getKitsByOwnerRole(
				@EdmFunctionImportParameter(name = "ownerRole",type =STRING)    
	    final String ownerRole)
		    {
 
		   Query q = em.createQuery("SELECT E1 from Kit E1 WHERE E1.currOwnerRole ='"+ownerRole+"'");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    return kitList;
		}
	@EdmFunctionImport(name = "getKitOwners", entitySet = "OwnerMasters", returnType = @ReturnType(
		    type = Type.ENTITY, isCollection = true))
		public List<Kit> getKitOwners(
				@EdmFunctionImportParameter(name = "ownerRole",type =STRING)    
	    final String ownerRole)
		    {
 
		   Query q = em.createQuery("SELECT E1 from OwnerMaster E1 WHERE E1.ownerRole ='"+ownerRole+"'");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    return kitList;
		}
	/*@EdmFunctionImport(name = "updateKitOwner", entitySet = "Kits", returnType = @ReturnType(
		    type = Type.SIMPLE, isCollection = false))
		public int updateKitOwner(
				@EdmFunctionImportParameter(name = "kitId",type =EdmType.STRING)    
	    final String kitId) throws ParseException
		    {
		
		String currOwnerRole="Distributor";
		String currOwnerId="10002";
		String currOwnerName="Metro Foods";
		String transactionType="Mobile";
		//Date lastUpdated= new Date(); //'2017-06-13T12:42:25+00:00'
		
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String string2 = "2001-07-04T12:08:56.235-07:00";
		Date result2 = df2.parse(string2);
		SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss");
				
		   Query q = em.createQuery("UPDATE Kit E1 SET E1.currOwnerId='"+currOwnerId+"',"
		   		+ "E1.currOwnerRole='"+currOwnerRole+"',"
		   				+ "E1.currOwnerName='"+currOwnerName+"',"
		   						+ "E1.transactionType='"+transactionType+"' WHERE E1.kitId='"+kitId+"'"); 
		
		      
		   int status=q.executeUpdate();
		    
		   return status;
		}*/
	@EdmFunctionImport(name = "getKitRequests", entitySet = "KitRequests", returnType = @ReturnType(
		    type = Type.ENTITY, isCollection = true))
		public List<Kit> getKitRequests(
				@EdmFunctionImportParameter(name = "requestorId",type =STRING)    
	    final String requestorId)
		    {
 
		   Query q = em.createQuery("SELECT E1 from KitRequest E1 WHERE E1.requestorId ='"+requestorId+"'");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    return kitList;
		}
	@EdmFunctionImport(name = "getRequestType", entitySet = "KitRequests", returnType = @ReturnType(
		    type = Type.SIMPLE, isCollection = false ))
		public String getRequestType(
				@EdmFunctionImportParameter(name = "surgeryId",type =STRING)    
	    final String surgeryId)
		    {
			String requestType=null;
		   Query q = em.createQuery("SELECT E1 from KitRequest E1 WHERE E1.surgeryId ='"+surgeryId+"'");
		    List<Kit> kitList = (List<Kit>) q.getResultList();
		    if(kitList.isEmpty())
		    {
		    	requestType = "No Kit Request for this Surgery Id";
		    	return requestType;
		    }
		    
		    KitRequest kitRequest = (KitRequest) q.getResultList().get(0);
		    requestType=kitRequest.getRequestType();
		    if(requestType!=null && !requestType.equals(""))
		    {
		    	return requestType;
		    }
		    else
		    {
		    	requestType="No Request Type Assigned";
		    }
		    
		    
		    return requestType;
		}
}

