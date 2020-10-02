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

public class addIndividualExpensesPageObject {
	
	AppiumDriver<MobileElement> driver;
	
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

		Assert.assertTrue(driver.findElementById("com.monefy.app.lite:id/income_amount_text").isDisplayed());
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
	}

}
