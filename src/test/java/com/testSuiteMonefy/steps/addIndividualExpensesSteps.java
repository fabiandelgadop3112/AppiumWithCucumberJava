package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.addIndividualExpensesPageObject;

public class addIndividualExpensesSteps {
	
	addIndividualExpensesPageObject AddIndividualExpensesPageObject = new addIndividualExpensesPageObject ();
 
	public void validateHome() {
		
		AddIndividualExpensesPageObject.openAppium();
		AddIndividualExpensesPageObject.validateHome();
		
	}

	public void addAllExpenses() {
		
		AddIndividualExpensesPageObject.addAllExpenses();
		
	}


}
