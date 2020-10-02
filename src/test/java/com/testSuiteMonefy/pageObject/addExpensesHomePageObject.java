package com.testSuiteMonefy.pageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class addExpensesHomePageObject {
	
	   AppiumDriver<MobileElement> driver;
	   Double initialExpensesValues;
	   Double expensesEnterValue;
	   Double finalExpensesValue;
	
	   AppiumResources appiumResources = new AppiumResources();
	   
	public void openAppium() {
		
		driver = appiumResources.connectionAppium();
			
	}

	public void validateHome() {
		
		String initialExpense;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/expense_amount_text").isDisplayed());
		
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

		
		
	}

	public void enterExpenseValue() {
		
		driver.findElementById("com.monefy.app.lite:id/buttonKeyboard1").click();
		for (int i = 0; i < 4; ++i) {
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard0").click();
			}
		
		String enterExpense = driver.findElementById("com.monefy.app.lite:id/amount_text").getText();
		expensesEnterValue = Double.parseDouble(enterExpense);
		
	}

	public void chooseCategory() {
		
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
		
	}

	public void validateExpensesLabel() {
		
		String finalExpense;
		
		Double expectedFinalExpense = initialExpensesValues + expensesEnterValue;
		
		finalExpense = driver.findElementById("com.monefy.app.lite:id/expense_amount_text").getText();
		finalExpense = finalExpense.replaceAll("[^\\d.]", "");
		
		finalExpensesValue = Double.parseDouble(finalExpense);
		
		Assert.assertEquals("The Expense doesn't match \\r\\n Test have been failed", finalExpensesValue, expectedFinalExpense);
		driver.quit();
	}


}