sap.ui.jsview("intellikit-ui.kitlist", {

	/**
	 * Specifies the Controller belonging to this View. In the case that it is
	 * not implemented, or that "null" is returned, this View does not have a
	 * Controller.
	 * 
	 * @memberOf intellikit-ui.kitlist
	 */
	getControllerName : function() {
		return "intellikit-ui.kitlist";
	},

	/**
	 * Is initially called once after the Controller has been instantiated. It
	 * is the place where the UI is constructed. Since the Controller is given
	 * to this method, its event handlers can be attached right away.
	 * 
	 * @memberOf intellikit-ui.kitlist
	 */
	createContent : function(oController) {

		// Create an instance of the table control
		var oTable = new sap.ui.table.Table({
			title : "Medical Kit List",
			visibleRowCount : 7,
			firstVisibleRow : 3,
			selectionMode : sap.ui.table.SelectionMode.Single,
		});
		// toolbar
		var oTableToolbar = new sap.ui.commons.Toolbar();
		// Kit Id field
		var oKitIdLabel = new sap.ui.commons.Label({
			text : 'Kit Id'
		});
		var oKitIdField = new sap.ui.commons.TextField({
			id : 'kitIdFieldId',
			value : '',
			width : '10em',
		});
		oKitIdLabel.setLabelFor(oKitIdField);
		oTableToolbar.addItem(oKitIdLabel);
		oTableToolbar.addItem(oKitIdField);
		// Kit Type field
		var oKitTypeLabel = new sap.ui.commons.Label({
			text : 'Kit Type'
		});
		var oKitTypeField = new sap.ui.commons.TextField({
			id : 'kitTypeFieldId',
			value : '',
			width : '10em',
		});
		oKitTypeLabel.setLabelFor(oKitTypeField);
		oTableToolbar.addItem(oKitTypeLabel);
		oTableToolbar.addItem(oKitTypeField);
		// lastChanged field
		var olastChangedLabel = new sap.ui.commons.Label({
			text : 'Last Changed'
		});
		var olastChangedField = new sap.ui.commons.TextField({
			id : 'lastChangedFieldId',
			value : '',
			width : '10em',
		});
		olastChangedLabel.setLabelFor(olastChangedField);
		oTableToolbar.addItem(olastChangedLabel);
		oTableToolbar.addItem(olastChangedField);
		// add button
		var oAddPersonButton = new sap.ui.commons.Button({
			id : 'addPersonButtonId',
			text : "Add Kit",
			press : function() {

				oController.addNewPerson(sap.ui.getCore().getControl(

				"kitIdFieldId").getValue(), sap.ui.getCore()

				.getControl("kitTypeFieldId").getValue(), sap.ui.getCore()

				.getControl("lastChangedFieldId").getValue(), oTable);
			}
		});
		// call API button
		var oCallAPIButton = new sap.ui.commons.Button({
			id : 'callAPIButtonId',
			text : "Call BlockChain",
			press : function() {

				oController.callAPI();
			}
		});
			
		
		oTableToolbar.addItem(oAddPersonButton);
		oTableToolbar.addItem(oCallAPIButton);
		
		oTable.setToolbar(oTableToolbar);
		// define the columns and the control templates to be used
		oTable.addColumn(new sap.ui.table.Column({
			label : new sap.ui.commons.Label({
				text : "Kit Id"
			}),
			template : new sap.ui.commons.TextField().bindProperty("value",
					"KitId"),
			sortProperty : "KitId",
			filterProperty : "KitId",
			width : "100px"
		}));
		oTable.addColumn(new sap.ui.table.Column({
			label : new sap.ui.commons.Label({
				text : "Kit Type"
			}),
			template : new sap.ui.commons.TextField().bindProperty("value",
					"KitType"),
			sortProperty : "KitType",
			filterProperty : "KitType",
			width : "200px"
		}));
		oTable.addColumn(new sap.ui.table.Column({
			label : new sap.ui.commons.Label({
				text : "Last Changed"
			}),
			template : new sap.ui.commons.TextField().bindProperty("value",
					"LastChanged"),
			sortProperty : "LastChanged",
			filterProperty : "LastChanged",
			width : "200px"
		}));
		oTable.addColumn(new sap.ui.table.Column({
			label : new sap.ui.commons.Label({
				text : "Tenant Id"
			}),
			template : new sap.ui.commons.TextField().bindProperty("value",
					"TENANT_ID"),
			sortProperty : "TENANT_ID",
			filterProperty : "TENANT_ID",
			width : "200px"
		}));
		// bind table rows to /Persons based on the model defined in the init
		// method of the controller
		oTable.bindRows("/Kits");
		return oTable;

	}

});
