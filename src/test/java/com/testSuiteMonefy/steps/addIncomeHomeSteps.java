package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.addIncomeHomePageObject;

public class addIncomeHomeSteps {
	
	addIncomeHomePageObject AddIncomePageObject = new addIncomeHomePageObject();

	public void validateHome() {
		System.out.print("SelectValidateSteps Home works OK \r\n");
		AddIncomePageObject.openAppium();
		AddIncomePageObject.validateHome();
	}

	public void selectAddIncome() {
		System.out.print("selectAddIncome Steps works OK \r\n");
		AddIncomePageObject.selectAddIncome();
		
	}

	public void validateCalculator() {
		System.out.print("validateCalculator Steps works OK \r\n");
		AddIncomePageObject.ValidateCalculator();
	}

}
