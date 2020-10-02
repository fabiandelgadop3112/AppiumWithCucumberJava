package com.testSuiteMonefy.steps;

import com.testSuiteMonefy.pageObject.addExpensesHomePageObject;

public class addExpensesHomeSteps {
	
	addExpensesHomePageObject AddExpensesHomePageObject = new addExpensesHomePageObject();
	
	public void validateHome() {
		
		AddExpensesHomePageObject.openAppium();
		AddExpensesHomePageObject.validateHome();
		
	}

	public void selectAddExpense() {
		
		AddExpensesHomePageObject.selectAddExpense();
				
	}

	public void enterExpenseValue() {
		
		AddExpensesHomePageObject.enterExpenseValue();
		
	}

	public void chooseCategory() {
		
		AddExpensesHomePageObject.chooseCategory();
		
		
	}

	public void validateExpensesLabel() {
		
		AddExpensesHomePageObject.validateExpensesLabel();
		
		
	}

}
