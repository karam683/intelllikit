package com.hcl.cloud.poc.odata.service;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;

import com.sap.cloud.account.TenantContext;

/**
 * Odata JPA Processor implementation class
 */
public class IntelliKitServiceFactory extends ODataJPAServiceFactory  {
	private static final String PERSISTENCE_UNIT_NAME = "intellikit-model-jpa";
	
	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		String currentTenantId=null;
		HashMap properties = null;
    	properties = new HashMap();		
		try {
								
			EntityManagerFactory emf = JpaEntityManagerFactory.getEntityManagerFactory();
			currentTenantId=getTenantId();
			
			properties.put("eclipselink.tenant-id",currentTenantId);
														
			EntityManager em= emf.createEntityManager(properties);
			oDataJPAContext.setEntityManager(em);
			oDataJPAContext.setEntityManagerFactory(emf);
			oDataJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
			oDataJPAContext.setJPAEdmExtension((JPAEdmExtension) new IntelliKitFunctionImportExtension() );
			return oDataJPAContext;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static synchronized String getTenantId()
	{
		String tenantId=null;
		TenantContext tenantContext;
		try{
			InitialContext ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			tenantContext =(TenantContext)envCtx.lookup("TenantContext");
			tenantId=tenantContext.getTenant().getId();
			
		}catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		return tenantId;
	}
	
	
}
