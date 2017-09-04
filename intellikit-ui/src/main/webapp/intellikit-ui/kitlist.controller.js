sap.ui.controller("intellikit-ui.kitlist", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf intellikit-ui.kitlist
*/
	onInit: function() {
	

			 var sOrigin = window.location.protocol + "//"
				+ window.location.hostname
				+ (window.location.port ? ":" + window.location.port : "");
		var kitsListOdataServiceUrl = sOrigin
				+ "/intellikit-ui/intelliKit.svc";
		var odataModel = new sap.ui.model.odata.ODataModel(
				kitsListOdataServiceUrl);
		odataModel.setCountSupported(false);
		this.getView().setModel(odataModel);
	},
	addNewPerson : function(sKitId, sKitType, sLastChanged, oTable) {
		var kits = {};
		kits.KitId = sKitId;
		kits.KitType = sKitType;
		kits.KitStatus="Open";
		kits.CurrOwnerRole="Hospital";
		kits.LastUpdated = new Date(sLastChanged);
		
		this.getView().getModel().create("/Kits", kits, null,
				this.successMsg, this.errorMsg);
	},
	callAPI: function()
	{
		var sOrigin = window.location.protocol + "//"
		+ window.location.hostname
		+ (window.location.port ? ":" + window.location.port : "");
		var url = sOrigin+"/intellikit-ui/proxy/AssetManager/query";
		var data={"chaincodeId": "1463dca76e6123b98cee7fef905a085b","fcn": "searchsn","args": ["SN"]};
		
			$.ajax({
				url:url,
				type:"POST",
				data: JSON.stringify(data),
				headers:{
					"Content-Type": "application/json; charset=utf-8",
					"Accept": "application/json",
					"apikey": "BgQweBtY8bHspzgIksKSM0L9yVvWBxSnsELH6x9YRXUNGgdtdBdVnJ7dDLeG3a2FWGYInPRuM6ETfCgGvL13dWCl2eiGKQ3C0R3CqZwRokFiai2j8Xq5kAKB3TOQWiZ0I5PlEFkwGqqNe8ErJzPtldqk9b3RHcTRMndNs3IlxthCGpLTGBLrBS3gj24Y9D1gcrQtrIUu95fYEiiHtuRJgXyNWvlyuuqkr6NU3tfl1sSyQ4wMHfpdwsUS2s3zrnyTYUSu9rIbKkq8uO7bNIgfQEn5eCQPPOhUq9YMdPP67RQU6fixk1qFaM9nPecG2tc3ZEUXZAQ0etsu4R7OCDvhzJh6eDU4HenE8QsnvIw2RU1liHyule5SYLYbpJYbZI1FZ10qN2QhDsx8017wwpJF10BC2qulJWu2x9yJWacxVqa9SvwPSLVOS9UHJjZKE0COKo6UikiBfsnNtoueCjNQQVvwXAAuCwIb16Ftx3UEt37yuuecHnff6U7j0GKNIYNc"
					},
				success: function(oData)
				{
					window.console.log("SUCCESS");
				},
				error: function(oError){
					window.console.log("ERROR:"+oError);
					
				}
				
				});
	},
	
	successMsg : function() {
		sap.ui.commons.MessageBox
				.alert("Kit entity has been successfully created");
	},
	errorMsg : function() {
		sap.ui.commons.MessageBox
				.alert("Error occured when creating Kit entity");

		//
},

//
//	},

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf intellikit-ui.kitlist
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf intellikit-ui.kitlist
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf intellikit-ui.kitlist
*/
//	onExit: function() {
//
//	}

});