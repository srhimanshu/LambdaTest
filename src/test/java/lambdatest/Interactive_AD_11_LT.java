package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Interactive_AD_11_LT 
{
		RemoteWebDriver driver;
		String userName = "yash.jainsourcedigital";  /*yash.jainsourcedigital*/
		String accessKey = "R8wSXoVE0MlpUPXrslGw0bZdothPDwvKsX1AVIfTMqISD5dFNX"; /*R8wSXoVE0MlpUPXrslGw0bZdothPDwvKsX1AVIfTMqISD5dFNX*/
		WebDriverWait wait;
		String parentWindow;
		String actualURL;
		Actions actions;
		
		@BeforeTest
//		@Parameters(value= {"version","platform","device"})
		void setUp() throws MalformedURLException
		{
			//Set Capabilities for Lambda Test
			DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "Interactive_AD_11_Himanshu");
            capabilities.setCapability("name", "Partial Build");
            capabilities.setCapability("network", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("video", true); 
            capabilities.setCapability("console", true); 
            
            //LambdaTest url for automation
            URL url = new URL("https://"+userName+":"+accessKey+"@hub.lambdatest.com/wd/hub");
            driver = new RemoteWebDriver(url,capabilities);
            
            //Explicit Wait
            wait = new WebDriverWait(driver,Duration.ofSeconds(50));
            
            actions = new Actions(driver);
		}
		
		@Test
		void run() 
		{
			//Launch URL
			driver.get("https://api-dev.sourcesync.io/interactives/11/package?type=distribution");
			parentWindow = driver.getWindowHandle();
			
			//Click on Interactive container to play video
			click("//img[@id='sd-interactive-banner']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			
			//To Pause the video because currently video pause issue is available
			actions.moveByOffset(50,50).click().perform();
			
			//Open First SAM
			click("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div");
			
			//Verify Button inside First SAM
			verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/soft-chews-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			
			//Close First SAM
			click("//i[contains(text(),'close')]");
			
			//Open Second SAM
			click("//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div");
			
			//Verify Button inside Second SAM
			verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/oil-tinctures-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			
			//Close Second SAM
			click("//i[contains(text(),'close')]");
			
			//Open Third SAM
			click("//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
			
			//Verify Button inside Third SAM
			verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/all-products?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			
			//Close Third SAM
			click("//i[contains(text(),'close')]");
		}
		
		@AfterClass
		void end()
		{
			driver.quit();
		}
		
		//Recursively used method to run the test.
			void click(String clickableandWaitXpath) 
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
				driver.findElement(By.xpath(clickableandWaitXpath)).click();
			}
			
			//This verifyButton method verify that whether this button is redirecting to expected URL or not.
			boolean verifyButton(String clickableandWaitXpath,String expectedURL) 
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
				driver.findElement(By.xpath(clickableandWaitXpath)).click();
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
				driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
				if(actualURL.equals(expectedURL))
					return true;
				else
					return false;
			}
	
}
