package com.testSuiteMonefy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumResources {

	AppiumDriver<MobileElement> driver;
		
public AppiumDriver<MobileElement> connectionAppium() {
		
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
			return driver;
	}

	public void swipe (int inicialx, int inicialy, int finx, int finy) {
		
		new TouchAction((PerformsTouchActions) driver).longPress(
			new PointOption<>().withCoordinates(inicialx,inicialy)).
			moveTo(new PointOption<>().withCoordinates(finx,finy)).release().perform();
	}
	
}
