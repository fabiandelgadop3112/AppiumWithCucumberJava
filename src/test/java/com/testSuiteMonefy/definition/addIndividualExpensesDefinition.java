package com.testSuiteMonefy.definition;

import com.testSuiteMonefy.steps.addIndividualExpensesSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addIndividualExpensesDefinition {
	
	addIndividualExpensesSteps AddIndividualExpensesSteps = new addIndividualExpensesSteps();

	@Given("^Staying in home screen for add individual expenses$")
	public void staying_in_home_screen_for_add_individual_expenses(){	    
		AddIndividualExpensesSteps.validateHome();	   
	}

	@Then("^I could add expenses individualy$")
	public void i_could_add_expenses_individualy(){	    
		AddIndividualExpensesSteps.addAllExpenses();	    
	}
	
}
