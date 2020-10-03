package com.testSuiteMonefy.pageObject;

import org.junit.Assert;
import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class addExpensesHomePageObject {
	
	   AppiumDriver<MobileElement> driver;
	   Double initialExpensesValues;
	   Double expensesEnterValue;
	   Double finalExpensesValue;
	
	   AppiumResources appiumResources = new AppiumResources();
	   
	public void openAppium() {
		
		appiumResources.startServer();
		driver = appiumResources.connectionAppium();
		System.out.println("**********SCENARIO: Addexpenses HAS BEEN STARTED**********");
			
	}

	public void validateHome() {
		
		String initialExpense;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/expense_amount_text").isDisplayed());
		System.out.println("Home has been validated");
		initialExpense = driver.findElementById("com.monefy.app.lite:id/expense_amount_text").getText();
		initialExpense = initialExpense.replaceAll("[^\\d.]", "");		
		initialExpensesValues = Double.parseDouble(initialExpense);
	}

	public void selectAddExpense() {
		
		try {
			driver.findElementById("com.monefy.app.lite:id/expense_button").click();
			}
			catch(Exception e) {
				driver.findElementById("com.monefy.app.lite:id/expense_button_title").click();
			}

		System.out.println("Expenses button has been selected");
		
	}

	public void enterExpenseValue() {
		
		driver.findElementById("com.monefy.app.lite:id/buttonKeyboard1").click();
		for (int i = 0; i < 6; ++i) {
			int valueCalculatorButton = (int) (Math.random() * (9));
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+valueCalculatorButton).click();	
			}
		
		String enterExpense = driver.findElementById("com.monefy.app.lite:id/amount_text").getText();
		expensesEnterValue = Double.parseDouble(enterExpense);
		System.out.println("Expenses has been writted");
	}

	public void chooseCategory() {
		
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
		System.out.println("Category has been selected");
		
	}

	public void validateExpensesLabel() {
		
		String finalExpense;
		
		Double expectedFinalExpense = initialExpensesValues + expensesEnterValue;
		
		finalExpense = driver.findElementById("com.monefy.app.lite:id/expense_amount_text").getText();
		finalExpense = finalExpense.replaceAll("[^\\d.]", "");
		
		finalExpensesValue = Double.parseDouble(finalExpense);
		
		Assert.assertEquals("The Expense doesn't match \\r\\n Test have been failed", finalExpensesValue, expectedFinalExpense);
		System.out.println("Expenses has been validated SUCCESFULLY");
		driver.quit();
		appiumResources.stopServer();
	}


}
