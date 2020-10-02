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
		
		driver = appiumResources.connectionAppium();
		
	}
	

	public void validateHome() {	
		
		
		String inicialIncome;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());

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
		

	}

	public void enterIncomeValue() {
		
		driver.findElementById("com.monefy.app.lite:id/buttonKeyboard1").click();
		for (int i = 0; i < 4; ++i) {
			driver.findElementById("com.monefy.app.lite:id/buttonKeyboard0").click();
			}
		
		String enterIncome = driver.findElementById("com.monefy.app.lite:id/amount_text").getText();
		incomeEnterValue = Double.parseDouble(enterIncome);

	}
	
	public void chooseCategory() {
		driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
		driver.findElementById("com.monefy.app.lite:id/imageView").click();
	}
	
	public void validateIncomesLabel() {
		
		String finalIncome;
		
		Double expectedIncomeValue = inicialIncomeValue + incomeEnterValue;
		
		finalIncome = driver.findElementById("com.monefy.app.lite:id/income_amount_text").getText();
		finalIncome = finalIncome.replaceAll("[^\\d.]", "");
		finalIncomeValue = Double.parseDouble(finalIncome);
		
		Assert.assertEquals("The income doesn't match \r\n Test have been failed",finalIncomeValue, expectedIncomeValue);
		
		driver.quit();
	}
}
