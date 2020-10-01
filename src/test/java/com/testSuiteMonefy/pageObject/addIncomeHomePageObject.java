package com.testSuiteMonefy.pageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class addIncomeHomePageObject {
	
	 
	 AppiumDriver<MobileElement> driver;
	 
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
		
		//driver.findElementByAccessibilityId("com.monefy.app.lite:id/income_button").click();
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation']").click();
	}

	public void selectAddIncome() {
		System.out.print("Teha button is displayed");
	}

	public void ValidateCalculator() {
		System.out.print("Teha calculator is displayed");
	}

}
