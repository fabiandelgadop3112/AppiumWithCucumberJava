package com.testSuiteMonefy.definition;
import com.testSuiteMonefy.steps.addIncomeHomeSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addIncomeHomeDefinition {
	
	addIncomeHomeSteps AddIncomeHomeSteps = new addIncomeHomeSteps();
	
	@Given("^Staying in home screen$")
	public void staying_in_home_screen(){
		AddIncomeHomeSteps.validateHome();
	}

	@When("^I push button plus$")
	public void i_push_button_plus() {
		 AddIncomeHomeSteps.selectAddIncome();
	}
	
	@And("^I enter a value in the calculator$")
	public void i_enter_a_value_in_the_calculator()
	{	
		AddIncomeHomeSteps.enterIncomeValue();
	}
	
	@And("^I Choose a category$")
	public void i_choose_a_category()
	{	
		AddIncomeHomeSteps.chooseCategory();
	}

	@Then("^I View the amount reflected on the label to incomes$")
	public void i_view_the_amount_reflected_on_the_label_to_incomes() {
		AddIncomeHomeSteps.validateIncomesLabel();
	}

}
