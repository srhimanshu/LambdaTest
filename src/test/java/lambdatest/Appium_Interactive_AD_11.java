package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium_Interactive_AD_11 
{
	WebDriverWait wait;
	String parentWindow;
	String actualURL;
	By iFrame = By.tagName("iframe");
	Actions actions;
	AppiumDriver driver;
	
	@BeforeSuite
	void setUp() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("chromedriverExecutable", "C:\\Users\\Himanshu\\Downloads\\chromedriver_98\\chromedriver.exe");
		driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		actions = new Actions(driver);
	}
	
	@BeforeTest
	void run() 
	{
		//Launch URL
		driver.get("https://api-dev.sourcesync.io/interactives/11/package?type=distribution");
		parentWindow = driver.getWindowHandle();
	}	
		
	@Test
	void playVideo() throws InterruptedException 
	{
		//Click on Interactive container to play video
		click("//img[@id='sd-interactive-banner']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
		driver.switchTo().frame(driver.findElement(iFrame));
		
		//To Pause the video because currently video pause issue is available
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button[1]"))).click().release().perform();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo"} , enabled = true)
	void openFirstSAM() 
	{
		//Open First SAM
		click("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div");
	}
	
	@Test(priority = 2 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo","openFirstSAM"} , enabled = true)
	void verifyFirstSAMButton() 
	{
		//Verify Button inside First SAM
		boolean isPassed = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/soft-chews-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside First SAM working is proper : "+isPassed);
	}
	
	@Test(priority = 3 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo","openFirstSAM"} , enabled = true)
	void closeFirstSAM() 
	{
		//Close First SAM
		click("//i[contains(text(),'close')]");
	}
	
	@Test(priority = 1 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","closeFirstSAM"} , enabled = true)
	void openSecondSAM() 
	{
		//Open Second SAM
		click("//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div");
	}
	
	@Test(priority = 2 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","openSecondSAM"} , enabled = true)
	void verifySecondSAMButton() 
	{
		//Verify Button inside Second SAM
		boolean isPassed1 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/oil-tinctures-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Second SAM working is proper : "+isPassed1);
	}
	
	@Test(priority = 3 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","openSecondSAM"} , enabled = true)
	void closeSecondSAM() 
	{
		//Close Second SAM
		click("//i[contains(text(),'close')]");
	}
	
	@Test(priority = 1 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","closeFirstSAM","closeSecondSAM"} , enabled = true)
	void openThirdSAM() 
	{
		//Open Third SAM
		click("//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
	}
	
	@Test(priority = 2 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","openThirdSAM"} , enabled = true)
	void verifyThirdSAMButton() 
	{
		//Verify Button inside Third SAM
		boolean isPassed2 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/all-products?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Third SAM working is proper : "+isPassed2);
	}
	
	@Test(priority = 3 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","openThirdSAM"} , enabled = true)
	void closeThirdSAM() 
	{
		//Close Third SAM
		click("//i[contains(text(),'close')]");
	}
	
	@AfterTest
	void end()
	{
		driver.quit();
	}
	
	//This method is used to wait for same element before click and click the same element
	void click(String waitAndClickableXpath) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitAndClickableXpath)));
		driver.findElement(By.xpath(waitAndClickableXpath)).click();
	}
		
	//This verifyButton method verify that whether this button is redirecting to expected URL or not.
	boolean verifyButton(String waitAndClickableXpath,String expectedURL) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitAndClickableXpath)));
		driver.findElement(By.xpath(waitAndClickableXpath)).click();
		List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
		for(String childWindow : allWindows)
		{
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				actualURL = driver.getCurrentUrl();
			}
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(driver.findElement(iFrame));
		if(actualURL.equals(expectedURL))
			return true;
		else
			return false;
	}

}
