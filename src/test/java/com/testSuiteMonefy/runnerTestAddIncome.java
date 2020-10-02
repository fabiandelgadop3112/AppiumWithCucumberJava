package com.testSuiteMonefy;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/features/home.feature", tags="@Addinividualexpenses") 
public class runnerTestAddIncome 
{
	
}
