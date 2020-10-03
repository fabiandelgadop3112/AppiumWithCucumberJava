package com.testSuiteMonefy.pageObject;

import org.junit.Assert;
import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class addIndividualExpensesPageObject {
	
	AppiumDriver<MobileElement> driver;
	AppiumResources appiumResources = new AppiumResources();
	String initialValue;
	
	public void openAppium() {
		
		appiumResources.startServer();
		driver = appiumResources.connectionAppium();
		System.out.println("**********SCENARIO: Addinividualexpenses HAS BEEN STARTED**********");
	}

	public void validateHome() {

		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());
		System.out.println("Home validated");
		
		driver.findElementById("com.monefy.app.lite:id/overflow").click();
		driver.findElementById("com.monefy.app.lite:id/settings_panel").click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appiumResources.swipe(769,2080,775,256);
		driver.findElementById("com.monefy.app.lite:id/clear_database_button").click();		
		driver.findElementById("android:id/button1").click();
		System.out.println("Data base has been cleanned succesfully");
	}

	public void addAllExpenses() {
		
		initialValue = driver.findElementByXPath("//androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView[1]").getText();
		
		int count = 1;
		while (count<12) {
		for (int i = 1; i <= 12; i++) {
			
			if (initialValue.equals(driver.findElementByXPath("//androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView["+i+"]").getText())) {
				driver.findElementByXPath("//android.widget.ImageView["+i+"]").click();
				for (int j = 0; j < 6; ++j) {
					int valueCalculatorButton = (int) (Math.random() * (9));
					driver.findElementById("com.monefy.app.lite:id/buttonKeyboard"+valueCalculatorButton).click();	
					}
				String expenseName = driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").getText();
				driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
				System.out.println(expenseName+" has been added Succesfully");
				break;
			}
			else
			{
				count++;
			
			}
		}
		}

		System.out.println("All individual expenses has been created SUCCESFULLY");
		
		driver.quit();
		appiumResources.stopServer();
	}

}
