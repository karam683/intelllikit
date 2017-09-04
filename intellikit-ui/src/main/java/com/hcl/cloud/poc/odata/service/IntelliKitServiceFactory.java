package com.hcl.cloud.poc.odata.service;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

import com.sap.cloud.account.TenantContext;

/**
 * Odata JPA Processor implementation class
 */
public class IntelliKitServiceFactory extends ODataJPAServiceFactory  {
	private static final String PERSISTENCE_UNIT_NAME = "intellikit-model-jpa";

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		
		TenantContext tenantContext;
		String currentTenantId=null;
		HashMap properties = null;
    	properties = new HashMap();
		
		try {
					
			InitialContext ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			tenantContext =(TenantContext)envCtx.lookup("TenantContext");
			currentTenantId=tenantContext.getTenant().getId();
			properties.put("eclipselink.tenant-id",currentTenantId);
			
			EntityManagerFactory emf = JpaEntityManagerFactory.getEntityManagerFactory();
								
			EntityManager em= emf.createEntityManager(properties);
			
			oDataJPAContext.setEntityManager(em);
			
			oDataJPAContext.setEntityManagerFactory(emf);
			oDataJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
			return oDataJPAContext;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
