package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Interactive_AD_11_LT 
{
		RemoteWebDriver driver;
		String userName = "yash.jainsourcedigital";
		String accessKey = "R8wSXoVE0MlpUPXrslGw0bZdothPDwvKsX1AVIfTMqISD5dFNX";
		WebDriverWait wait;
		String parentWindow;
		String actualURL;
		
		@BeforeTest
		void setUp() throws MalformedURLException
		{
			//Set Capabilities for Lambda Test
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platform", "Windows 11");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("version", "99.0"); 
            capabilities.setCapability("resolution", "1024x768");
            capabilities.setCapability("build", "Test THO Himanshu");
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
		}
		
		@Test
		void run() throws InterruptedException
		{
			//Launch URL
			driver.get("https://api-dev.sourcesync.io/interactives/11/package?type=distribution");
			parentWindow = driver.getWindowHandle();
			
			
			//Click on Interactive container to play video
			click("//img[@id='sd-interactive-banner']","//iframe");
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div")));
			System.out.println("Video has been started.");
			
			//Open First SAM
			click("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div","//div[@class='smart-block-list__item q-mt-md']/button");
			System.out.println("First SAM has been opened.");
			
			//Verify Button inside First SAM
			boolean isPassed = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/soft-chews-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			System.out.println("Button inside First SAM working is proper : "+isPassed);
			
			//Close First SAM
			click("//i[contains(text(),'close')]","//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div");
			System.out.println("First SAM has been closed.");
			
			//Open Second SAM
			click("//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div","//div[@class='smart-block-list__item q-mt-md']/button");
			System.out.println("Second SAM has been opened.");
			
			//Verify Button inside Second SAM
			boolean isPassed1 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/oil-tinctures-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			System.out.println("Button inside Second SAM working is proper : "+isPassed1);
			
			//Close Second SAM
			click("//i[contains(text(),'close')]","//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
			System.out.println("Second SAM has been closed.");
			
			//Open Third SAM
			click("//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div","//div[@class='smart-block-list__item q-mt-md']/button");
			System.out.println("Third SAM has been opened.");
			
			//Verify Button inside Third SAM
			boolean isPassed2 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/all-products?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
			System.out.println("Button inside Third SAM working is proper : "+isPassed2);
			
			//Close Third SAM
			click("//i[contains(text(),'close')]","//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
			System.out.println("Third SAM has been closed.");
		}
		
		@AfterTest
		void end()
		{
			System.out.println("With All Passed Test Cases this interactive ad has been tested.");
			driver.quit();
		}
		
		//Recursively used method to run the test.
			void click(String clickableXpath,String waitXpath) throws InterruptedException
			{
				driver.findElement(By.xpath(clickableXpath)).click();
				Thread.sleep(10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitXpath)));
			}
			
			//This verifyButton method verify that whether this button is redirecting to expected URL or not.
			boolean verifyButton(String clickableXpath,String expectedURL) throws InterruptedException
			{
				driver.findElement(By.xpath(clickableXpath)).click();
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
