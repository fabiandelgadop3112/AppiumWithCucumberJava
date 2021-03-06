package com.testSuiteMonefy.pageObject;

import org.junit.Assert;

import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class validateBalancePageObject {
	
	AppiumDriver<MobileElement> driver;
	
	AppiumResources appiumResources = new AppiumResources();
	
	
	public void openAppium() {
	
		appiumResources.startServer();
		driver = appiumResources.connectionAppium();
		System.out.println("**********SCENARIO: Balancevalidation HAS BEEN STARTED**********");
		
	}
	
	public void validateHome() {
		
		
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/balance_container").isDisplayed());
		System.out.println("HomePage has been validated");
	}

	public void addIncome() {
		
		
		
		try {
			driver.findElementById("com.monefy.app.lite:id/income_button").click();
			}
			catch(Exception e) {
				driver.findElementById("com.monefy.app.lite:id/income_button_title").click();
			}
		
		for (int i = 0; i < 6; ++i) {
			int valueCalculatorButton = (int) (Math.random() * (9));
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+valueCalculatorButton).click();	
			}
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
		System.out.println("Income has been added");
	} 

	public void addExpense() {
		
		try {
			driver.findElementById("com.monefy.app.lite:id/expense_button").click();
			}
			catch(Exception e) {
				driver.findElementById("com.monefy.app.lite:id/expense_button_title").click();
			}
		for (int i = 0; i < 6; ++i) {
			int valueCalculatorButton = (int) (Math.random() * (9));
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+valueCalculatorButton).click();	
			}
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
		System.out.println("Expense has been added");
	}

	public void validateBalance() {
		
		
		String textIncomes = driver.findElementById("com.monefy.app.lite:id/income_amount_text").getText();
		Double valueIncomes = Double.parseDouble(textIncomes.replaceAll("[^\\d.]", ""));
		
		
		String textExpenses = driver.findElementById("com.monefy.app.lite:id/expense_amount_text").getText();
		Double valueExpenses = Double.parseDouble(textExpenses.replaceAll("[^\\d.]", ""));
		
		
		Double valueBalance;
		String textBalance = driver.findElementById("com.monefy.app.lite:id/balance_amount").getText();
		if(textBalance.contains("-")) {
			valueBalance = Double.parseDouble(textBalance.replaceAll("[^\\d.]", "")); 	
			valueBalance *= -1;
		}
		else {
			valueBalance = Double.parseDouble(textBalance.replaceAll("[^\\d.]", ""));
		}
	
		Double expectedBalance = valueIncomes - valueExpenses;
		Assert.assertEquals("The balance value doesn't match \r\n Test have been failed",expectedBalance, valueBalance);
		System.out.println("Balance has been validated SUCCESFULLY");
		driver.quit();
		appiumResources.stopServer();
	}

}
