package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.addIncomeHomePageObject;

public class addIncomeHomeSteps {
	
	addIncomeHomePageObject AddIncomePageObject = new addIncomeHomePageObject();

	public void validateHome() {
		System.out.print("Select Validate Home Step OK \r\n");
		AddIncomePageObject.openAppium();
		AddIncomePageObject.validateHome();
	}

	public void selectAddIncome() {
		System.out.print("Select Add Income Step OK \r\n");
		AddIncomePageObject.selectAddIncome();
		
	}

	public void enterIncomeValue() {
		System.out.print("Select enter Income value Step OK \r\n");
		AddIncomePageObject.enterIncomeValue();
	}
	
	public void chooseCategory() {
		System.out.print("Select choose category Step OK \r\n");
		AddIncomePageObject.chooseCategory();
	}
	
	
	public void	validateIncomesLabel() {
		System.out.print("Select validate income label step ok \r\n \r\n");
		AddIncomePageObject.validateIncomesLabel();
	}
	

}
