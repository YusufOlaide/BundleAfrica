package bundle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends Base{

	public static void main(String[] args) throws IOException {
		
		AndroidDriver<AndroidElement> driver = capabilitySetup();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.android.permissioncontroller:id/grant_singleton").click();
		
		//UIAUtomatorViewer shows only className-- XPath was generated with it with the absence of resource-id
		
		MobileElement element = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='2']");
		if(element.isDisplayed()) {
			element.sendKeys(property.getProperty("path"));
		} else {
			System.out.println("Locator not found");
		}
		
		driver.findElementByXPath("//android.view.View[@text='Continue']").click();
		
		driver.quit();
		

	}

}
