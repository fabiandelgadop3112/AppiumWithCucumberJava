package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.validateBalancePageObject;

public class validateBalanceSteps {
	
	validateBalancePageObject ValidateBalancePageObject = new validateBalancePageObject();
	
	public void validateHome() {
		ValidateBalancePageObject.validateHome();
	}

	public void addIncome() {
		ValidateBalancePageObject.addIncome();		
	}

	public void addExpense() {
		ValidateBalancePageObject.addExpense();		
	}

	public void validateBalance() {
		ValidateBalancePageObject.validateBalance();
		
	}

}
