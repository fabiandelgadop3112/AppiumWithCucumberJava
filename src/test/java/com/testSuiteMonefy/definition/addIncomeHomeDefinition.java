package com.testSuiteMonefy.definition;
import com.testSuiteMonefy.steps.addIncomeHomeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addIncomeHomeDefinition {
	
	addIncomeHomeSteps AddIncomeHomeSteps = new addIncomeHomeSteps();
	
	@Given("^Staying in home screen$")
	public void staying_in_home_screen(){
		System.out.print("When works \r\n");
		AddIncomeHomeSteps.validateHome();
	}

	@When("^I push button plus$")
	public void i_push_button_plus() {
		 System.out.print("When works \r\n");
		 AddIncomeHomeSteps.selectAddIncome();
	}

	@Then("^I see the calculator$")
	public void i_see_the_calculator() {
		System.out.print("When works \r\n");
		AddIncomeHomeSteps.validateCalculator();
	}

}
