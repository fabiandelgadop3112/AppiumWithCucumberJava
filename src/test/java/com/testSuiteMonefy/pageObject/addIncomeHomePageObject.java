package com.testSuiteMonefy.pageObject;

import org.junit.Assert;
import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class addIncomeHomePageObject {


	AppiumDriver<MobileElement> driver;
	Double inicialIncomeValue;
	Double incomeEnterValue;
	Double finalIncomeValue;
	
	AppiumResources appiumResources = new AppiumResources();
	
	public void openAppium() {
		
		appiumResources.startServer();
		driver = appiumResources.connectionAppium();
		System.out.println("**********SCENARIO: Addincomes HAS BEEN STARTED**********");
	}
	

	public void validateHome() {	
		
		
		String inicialIncome;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());
		System.out.println("Home validated");
		inicialIncome = driver.findElementById("com.monefy.app.lite:id/income_amount_text").getText();
		inicialIncome = inicialIncome.replaceAll("[^\\d.]", "");

		inicialIncomeValue = Double.parseDouble(inicialIncome);
		
	}

	public void selectAddIncome() {
		
		try {
			driver.findElementById("com.monefy.app.lite:id/income_button").click();
			}
			catch(Exception e) {
				driver.findElementById("com.monefy.app.lite:id/income_button_title").click();
			}
		System.out.println("Income button has been selected");

	}

	public void enterIncomeValue() {
		
		for (int i = 0; i < 6; ++i) {
			int valueCalculatorButton = (int) (Math.random() * (9));
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+valueCalculatorButton).click();	
			}
		String enterIncome = driver.findElementById("com.monefy.app.lite:id/amount_text").getText();
		incomeEnterValue = Double.parseDouble(enterIncome);
		System.out.println("Income Value has been writed");

	}
	
	public void chooseCategory() {
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
		System.out.println("Category has been selected");
	}
	
	public void validateIncomesLabel() {
		
		String finalIncome;
		
		Double expectedIncomeValue = inicialIncomeValue + incomeEnterValue;
		
		finalIncome = driver.findElementById("com.monefy.app.lite:id/income_amount_text").getText();
		finalIncome = finalIncome.replaceAll("[^\\d.]", "");
		finalIncomeValue = Double.parseDouble(finalIncome);
		
		Assert.assertEquals("The income doesn't match \r\n Test have been failed",finalIncomeValue, expectedIncomeValue);
		System.out.println("Income value has been validated SUCCESFULLY");
		
		driver.quit();
		appiumResources.stopServer();
	}
}
