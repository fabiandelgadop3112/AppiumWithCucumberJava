package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.addIncomeHomePageObject;

public class addIncomeHomeSteps {
	
	addIncomeHomePageObject AddIncomePageObject = new addIncomeHomePageObject();

	public void validateHome() {

		AddIncomePageObject.openAppium();
		AddIncomePageObject.validateHome();
	}

	public void selectAddIncome() {

		AddIncomePageObject.selectAddIncome();
		
	}

	public void enterIncomeValue() {

		AddIncomePageObject.enterIncomeValue();
	}
	
	public void chooseCategory() {

		AddIncomePageObject.chooseCategory();
	}
	
	
	public void	validateIncomesLabel() {

		AddIncomePageObject.validateIncomesLabel();
	}
	

}
