package com.hcl.cloud.poc.odata.service;

import java.io.InputStream;

import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;



public class IntelliKitFunctionImportExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView view) {
		// TODO Auto-generated method stub
		view.registerOperations(IntelliKitFunctionImport.class, null);
	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
