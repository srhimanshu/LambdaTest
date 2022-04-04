package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
class Interactive_AD 
{
	WebDriver driver;
	WebDriverWait wait;
	String parentWindow;
	String actualURL;
	Actions actions;
	
	Interactive_AD(WebDriver driver)
	{
		this.driver = driver;
	}
	
	void setup()
	{
		this.driver.manage().window().maximize();
		
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(20));
		
		actions = new Actions(this.driver);
	}
	
	void perform() 
	{
		//Launch URL
		this.driver.get("https://api-dev.sourcesync.io/interactives/11/package?type=distribution");
		parentWindow = this.driver.getWindowHandle();
		
		//Click on Interactive container to play video
		click("//img[@id='sd-interactive-banner']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		this.driver.switchTo().frame(this.driver.findElement(By.tagName("iframe")));
		
		//To Pause the video because currently video pause issue is available
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@tabindex='0']/button"))).doubleClick().release().perform();
		
		//Open First SAM
		click("//div[@data-instance-key='202_229cac43-9830-486a-aa14-1f30dbec3dff']/div");
		
		//Verify Button inside First SAM
		boolean isPassed = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/soft-chews-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside First SAM working is proper : "+isPassed);
		
		//Close First SAM
		click("//i[contains(text(),'close')]");
		
		//Open Second SAM
		click("//div[@data-instance-key='201_1b21dd32-b6a4-44b1-a3b0-222c9170ae91']/div");
		
		//Verify Button inside Second SAM
		boolean isPassed1 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/cats/oil-tinctures-for-cats.html?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Second SAM working is proper : "+isPassed1);
		
		//Close Second SAM
		click("//i[contains(text(),'close')]");
		
		//Open Third SAM
		click("//div[@data-instance-key='197_0233552f-83c1-4206-987e-506ee484ddee']/div");
		
		//Verify Button inside Third SAM
		boolean isPassed2 = verifyButton("//div[@class='smart-block-list__item q-mt-md']/button","https://www.pawcbd.com/all-products?utm_source=sourcedigital&utm_medium=video&utm_campaign=tripadvisor");
		System.out.println("Button inside Third SAM working is proper : "+isPassed2);
		
		//Close Third SAM
		click("//i[contains(text(),'close')]");
	}
	
	void end()
	{
		this.driver.quit();
	}
	
	//Recursively used method to run the test.
		void click(String clickableandWaitXpath)  
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
			this.driver.findElement(By.xpath(clickableandWaitXpath)).click();
		}
		
		//This verifyButton method verify that whether this button is redirecting to expected URL or not.
		boolean verifyButton(String clickableandWaitXpath,String expectedURL) 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
			this.driver.findElement(By.xpath(clickableandWaitXpath)).click();
			List<String> allWindows = new ArrayList<String>(this.driver.getWindowHandles());
			for(String childWindow : allWindows)
			{
				if(!parentWindow.equals(childWindow))
				{
					this.driver.switchTo().window(childWindow);
					actualURL = this.driver.getCurrentUrl();
				}
			}
			this.driver.close();
			this.driver.switchTo().window(parentWindow);
			this.driver.switchTo().frame(this.driver.findElement(By.tagName("iframe")));
			if(actualURL.equals(expectedURL))
				return true;
			else
				return false;
		}
}

class chromeBrowser extends Thread
{
	WebDriver driver;
	
	public void run()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Interactive_AD iad = new Interactive_AD(driver);
		iad.setup();
		iad.perform();
		iad.end();
	}
}

class firefoxBrowser extends Thread
{
	WebDriver driver;
	
	public void run()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		Interactive_AD iad1 = new Interactive_AD(driver);
		iad1.setup();
		iad1.perform();
		iad1.end();
	}
}

class operaBrowser extends Thread
{
	WebDriver driver;
	
	public void run()
	{
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		Interactive_AD iad2 = new Interactive_AD(driver);
		iad2.setup();
		iad2.perform();
		iad2.end();
	}
}

class androidDevice extends Thread
{
	WebDriver driver;
	
	public void run()
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("chromedriverExecutable", "C:\\Users\\Himanshu\\Downloads\\chromedriver_98\\chromedriver.exe");
		try 
		{
			driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		Interactive_AD iad3 = new Interactive_AD(driver);
		iad3.setup();
		iad3.perform();
		iad3.end();
	}
}

public class Interactive_AD_11
{
	public static void main(String[] args)
	{
		chromeBrowser cb = new chromeBrowser();
		cb.start();
		firefoxBrowser fb = new firefoxBrowser();
		fb.start();
		operaBrowser ob = new operaBrowser();
		ob.start();
		androidDevice ad = new androidDevice();
		ad.start();
	}
}
