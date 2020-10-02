package com.testSuiteMonefy.definition;

import com.testSuiteMonefy.steps.addIndividualExpensesSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addIndividualExpenses {
	
	addIndividualExpensesSteps AddIndividualExpensesSteps = new addIndividualExpensesSteps();

	@Given("^Staying in home screen for add individual expenses$")
	public void staying_in_home_screen_for_add_individual_expenses(){	    
		AddIndividualExpensesSteps.validateHome();	   
	}

	@When("^I add expenses individualy$")
	public void i_add_expenses_individualy(){	    
		AddIndividualExpensesSteps.addAllExpenses();	    
	}

	@Then("^All expenses have an associated ammount$")
	public void all_expenses_have_an_associated_ammount(){	   
		AddIndividualExpensesSteps.validateAllIndividualExpenses();	    
	}
	
}
