package com.testSuiteMonefy.pageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class addExpensesHomePageObject {
	
	   AppiumDriver<MobileElement> driver;
	   Double initialExpensesValues;
	   Double expensesEnterValue;
	   Double finalExpensesValue;
		   
	public void openAppium() {
		
		String apkPath = "src/apk/com.monefy.app.lite.apk";
		File appPath = new File(apkPath);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.UDID, "ZY2278CHMJ");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(8) plus");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
			
	}

	public void validateHome() {
		
		String initialExpense;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/expense_amount_text").isDisplayed());
		
		initialExpense = driver.findElementById("com.monefy.app.lite:id/expense_amount_text").getText();
		initialExpense = initialExpense.replaceAll("[^\\d.]", "");		
		initialExpensesValues = Double.parseDouble(initialExpense);
	}

	public void selectAddExpense() {
		
		driver.findElementById("com.monefy.app.lite:id/expense_button_title").click();
		
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
		
	}


}
