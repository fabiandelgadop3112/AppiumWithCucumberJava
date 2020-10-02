package com.testSuiteMonefy.pageObject;

import org.junit.Assert;
import com.testSuiteMonefy.AppiumResources;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class addIndividualExpensesPageObject {
	
	AppiumDriver<MobileElement> driver;
	
	
	AppiumResources appiumResources = new AppiumResources();
	
	public void openAppium() {
		
		driver = appiumResources.connectionAppium();
	}

	public void validateHome() {

		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());
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
	}

	public void addAllExpenses() {
		
		String initialValue = driver.findElementByXPath("//androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView[1]").getText();
		
		int count = 1;
		while (count<12) {
		for (int i = 1; i <= 12; i++) {
			
			if (initialValue.equals(driver.findElementByXPath("//androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView["+i+"]").getText())) {
				driver.findElementByXPath("//android.widget.ImageView["+i+"]").click();
				driver.findElementById("com.monefy.app.lite:id/buttonKeyboard1").click();
				driver.findElementById("com.monefy.app.lite:id/keyboard_action_button").click();
				break;
			}
			else
			{
				count++;
			
			}
		}
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void validateAllIndividualExpenses() {
	
		System.out.print("ValidateAllIndividualExpenses");
		driver.quit();
	}

}
