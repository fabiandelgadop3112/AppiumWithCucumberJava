package com.testSuiteMonefy.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addExpensesHomeDefinition {
	

	
	@Given("^Staying in home screen for add expense$")
	public void staying_in_home_screen_for_add_expense(){
		System.out.print("Hello World\r\n");
	}

	@When("^I push button minus$")
	public void i_push_button_minus() {
		System.out.print("Minus pushed\r\n");
	}
	
	@And("^I enter a value in the expenses calculator$")
	public void i_enter_a_value_in_the_expenses_calculator()
	{	
		System.out.print("Calculator Init\r\n");
	}
	
	@And("^I Choose a category of expense$")
	public void i_choose_a_category_of_expense()
	{	
		System.out.print("Catgegory Selectt\r\n");
	}

	@Then("^I view the amount reflected on the label to expenses$")
	public void i_view_the_amount_reflected_on_the_label_to_expenses() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.print("Catgegory label expenses\r\n");
	}


}