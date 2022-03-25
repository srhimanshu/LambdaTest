package lambdatest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interactive_AD_11_Copy 
{
	WebDriverWait wait;
	WebDriver driver;
	String parentWindow;
	String actualURL;
	Actions actions;
	
	@BeforeSuite
	void setup()
	{
		//Browser Setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://api-dev.sourcesync.io/interactives/11/package?type=distribution");
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		parentWindow = driver.getWindowHandle();
		actions = new Actions(driver);
	}
	
	@Test
	void playVideo() throws InterruptedException
	{
		//Click on Interactive container to play video
		click("//img[@id='sd-interactive-banner']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println("Video has been started.");
	}
	
	@Test(dependsOnMethods = {"playVideo"})
	void pauseVideo() throws InterruptedException
	{
		actions.moveByOffset(50,50).click().perform();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo"} , enabled = true)
	void openFirstSAM() throws InterruptedException
	{
		//Open First SAM
		click("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div");
		System.out.println("First SAM has been opened.");
	}
	
	@Test(priority = 2 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo","openFirstSAM"} , enabled = true)
	void verifyFirstSAMButton() throws InterruptedException
	{
		//Verify Button inside First SAM
		boolean isPassed = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/soft-chews-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside First SAM working is proper : "+isPassed);
	}
	
	@Test(priority = 3 , groups = {"FirstSAM"} , dependsOnMethods = {"playVideo","openFirstSAM"} , enabled = true)
	void closeFirstSAM() throws InterruptedException
	{
		//Close First SAM
		click("//i[contains(text(),'close')]");
		System.out.println("First SAM has been closed.");
	}
	
	@Test(priority = 1 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","closeFirstSAM"} , enabled = true)
	void openSecondSAM() throws InterruptedException
	{
		//Open Second SAM
		click("//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div");
		System.out.println("Second SAM has been opened.");
	}
	
	@Test(priority = 2 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","openSecondSAM"} , enabled = true)
	void verifySecondSAMButton() throws InterruptedException
	{
		//Verify Button inside Second SAM
		boolean isPassed1 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/oil-tinctures-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Second SAM working is proper : "+isPassed1);
	}
	
	@Test(priority = 3 , groups = {"SecondSAM"} , dependsOnMethods = {"playVideo","openSecondSAM"} , enabled = true)
	void closeSecondSAM() throws InterruptedException
	{
		//Close Second SAM
		click("//i[contains(text(),'close')]");
		System.out.println("Second SAM has been closed.");
	}
	
	@Test(priority = 1 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","closeFirstSAM","closeSecondSAM"} , enabled = true)
	void openThirdSAM() throws InterruptedException
	{
		//Open Third SAM
		click("//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
		System.out.println("Third SAM has been opened.");
	}
	
	@Test(priority = 2 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","openThirdSAM"} , enabled = true)
	void verifyThirdSAMButton() throws InterruptedException
	{
		//Verify Button inside Third SAM
		boolean isPassed2 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/all-products?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Third SAM working is proper : "+isPassed2);
	}
	
	@Test(priority = 3 , groups = {"ThirdSAM"} , dependsOnMethods = {"playVideo","openThirdSAM"} , enabled = true)
	void closeThirdSAM() throws InterruptedException
	{
		//Close Third SAM
		click("//i[contains(text(),'close')]");
		System.out.println("Third SAM has been closed.");
	}
	
	@AfterSuite
	void end()
	{
		System.out.println("With All Passed Test Cases this interactive ad has been tested.");
		driver.quit();
	}
	
	//This method is used to click on any element and wait for another element
	void click(String waitAndClickableXpath) throws InterruptedException
	{
		Thread.sleep(10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(waitAndClickableXpath)));
		driver.findElement(By.xpath(waitAndClickableXpath)).click();
	}
		
	//This verifyButton method verify that whether this button is redirecting to expected URL or not.
	boolean verifyButton(String waitAndClickableXpath,String expectedURL) throws InterruptedException
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
		Thread.sleep(10);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		if(actualURL.equals(expectedURL))
			return true;
		else
			return false;
		}
}
