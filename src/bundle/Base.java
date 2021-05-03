package bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	static Properties property;
	static FileInputStream s;

	public static AndroidDriver<AndroidElement> capabilitySetup() throws IOException {
		// TODO Auto-generated method stub
		
		s = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		
		property = new Properties();
		
		property.load(s);
		
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
