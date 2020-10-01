package com.testSuiteMonefy.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addIncomeHomeDefinition {
	@Given("^Staying in home screen$")

	public void staying_in_home_screen() throws Throwable {
	    System.out.print("Given Works \r\n");
	}

	@When("^I push button plus$")
	public void i_push_button_plus() throws Throwable {
		 System.out.print("When works \r\n");
	}

	@Then("^I see the calculator$")
	public void i_see_the_calculator() throws Throwable {
		System.out.print("When works \r\n");
	}

}
