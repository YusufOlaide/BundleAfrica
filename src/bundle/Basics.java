package bundle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends Base{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void initiation() throws IOException{
		driver = capabilitySetup();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void uploadFile() {
		driver.findElementById("com.android.permissioncontroller:id/grant_singleton").click();
		
		//UIAUtomatorViewer shows only className-- XPath was generated with it with the absence of resource-id (Still returning 404 in the node server)
		
		AndroidElement app = driver.findElementByXPath("android.view.View[@text='Billable Hours']");
		
		Assert.assertEquals(app, "Billable Hours");
		
		AndroidElement actual = driver.findElementByXPath("android.view.View[@text='Enter the file path below']");
		
		Assert.assertEquals(actual, "Enter the file path below");
		
		
		MobileElement element = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='2']");
		if(element.isDisplayed()) {
			element.sendKeys(property.getProperty("path"));
		} else {
			System.out.println("Locator not found");
		}
		
		driver.findElementByXPath("//android.view.View[@text='Continue']").click();
	}
	
}
