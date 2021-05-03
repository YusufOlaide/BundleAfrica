package bundle;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilitySetup();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.android.permissioncontroller:id/grant_singleton").click();
		
		MobileElement element = (MobileElement) driver.findElementByClassName("//android.widget.EditText");
		if(element.isDisplayed()) {
			element.sendKeys("path");
		} else {
			System.out.println("Locator not found");
		}
		
		
		//driver.findElementByXPath("//android.widget.EditText[@index='2']").sendKeys("/Internal storage/WhatsApp/Media/WhatsApp Documents/Sent/sample2.csv");
		
		driver.findElementByXPath("//android.view.View[@text='Continue']").click();
		
		driver.quit();
		

	}

}
