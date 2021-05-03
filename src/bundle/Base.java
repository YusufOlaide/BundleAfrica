package bundle;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> capabilitySetup() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File f = new File("src");
		
		File fs = new File(f, "app-arm64-v8a-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		cap.setCapability("appPackage", "com.bundle.billable_hours_app");
		
		cap.setCapability("appActivity", "com.bundle.billable_hours_app.MainActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
	}

}
