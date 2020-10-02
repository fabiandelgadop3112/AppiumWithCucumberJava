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


public class addIncomeHomePageObject {
	
	
	AppiumDriver<MobileElement> driver;
	Double inicialIncomeValue;
	Double incomeEnterValue;
	Double finalIncomeValue;
	
	public void openAppium() {
		String apkPath = "src/apk/com.monefy.app.lite.apk";
		File appPath = new File(apkPath);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.UDID, "ZY2278CHMJ");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(8) plus");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.NO_RESET,"true");
		caps.setCapability(MobileCapabilityType.FULL_RESET, "false");
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
		
		
		String inicialIncome;
		
		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());

		inicialIncome = driver.findElementById("com.monefy.app.lite:id/income_amount_text").getText();
		inicialIncome = inicialIncome.replaceAll("[^\\d.]", "");

		inicialIncomeValue = Double.parseDouble(inicialIncome);
		
	}

	public void selectAddIncome() {
		driver.findElementById("com.monefy.app.lite:id/income_button_title").click();

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
