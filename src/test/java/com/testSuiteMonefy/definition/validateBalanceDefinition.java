package com.testSuiteMonefy.definition;

import com.testSuiteMonefy.steps.validateBalanceSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class validateBalanceDefinition {
	
	validateBalanceSteps ValidateBalanceSteps = new validateBalanceSteps();
	
	@Given("^Staying in home screen to validate balance$")
	public void staying_in_home_screen_to_validate_balance(){
	    
		ValidateBalanceSteps.validateHome();
	    
	}

	@When("^I add an income$")
	public void i_add_an_income(){
	    
		ValidateBalanceSteps.addIncome();
	    
	}

	@When("^I add an expense$")
	public void i_add_an_expense(){
	    
		ValidateBalanceSteps.addExpense();
	    
	}

	@Then("^The Balance have to print the difference between both records$")
	public void the_Balance_have_to_print_the_difference_between_both_records(){
			
		ValidateBalanceSteps.validateBalance();
	}

}
