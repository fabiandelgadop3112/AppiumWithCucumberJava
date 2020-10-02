package com.testSuiteMonefy.definition;

import com.testSuiteMonefy.steps.addExpensesHomeSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addExpensesHomeDefinition {
	
	addExpensesHomeSteps AddExpensesHomeSteps = new addExpensesHomeSteps();

	
	@Given("^Staying in home screen for add expense$")
	public void staying_in_home_screen_for_add_expense(){
		AddExpensesHomeSteps.validateHome();
		
	}

	@When("^I push button minus$")
	public void i_push_button_minus() {
		AddExpensesHomeSteps.selectAddExpense();
		
	}
	
	@And("^I enter a value in the expenses calculator$")
	public void i_enter_a_value_in_the_expenses_calculator()
	{	AddExpensesHomeSteps.enterExpenseValue();
		
	}
	
	@And("^I Choose a category of expense$")
	public void i_choose_a_category_of_expense()
	{	AddExpensesHomeSteps.chooseCategory();
		;
	}

	@Then("^I view the amount reflected on the label to expenses$")
	public void i_view_the_amount_reflected_on_the_label_to_expenses() throws Throwable {
	   AddExpensesHomeSteps.validateExpensesLabel();
		
	}


}