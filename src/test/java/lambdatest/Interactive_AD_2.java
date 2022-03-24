package lambdatest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interactive_AD_2 
{
	WebDriverWait wait;
	WebDriver driver;
	
	@BeforeTest
	void setup()
	{
		//Browser Setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://api.sourcesync.io/interactives/2/package?type=distribution");
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='sd-interactive-banner']")));
	}
	
	//Recursively used method to run the test.
	void click(String clickableXpath,String waitXpath) throws InterruptedException
	{
		driver.findElement(By.xpath(clickableXpath)).click();
		Thread.sleep(10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitXpath)));
	}
	
	@Test
	void run() throws InterruptedException
	{
		//Click on Interactive container to play video
		click("//img[@id='sd-interactive-banner']","//iframe[@id='sd-interactive-iframe']");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='sd-interactive-iframe']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1826_f7ec9b92-456b-434a-be36-dd4089907101']/div")));
		System.out.println("Video has been started.");
		
		//Open First SAM
		click("//div[@data-instance-key='1826_f7ec9b92-456b-434a-be36-dd4089907101']/div","//i[contains(text(),'close')]");
		System.out.println("First SAM has been opened.");
		
		//Close First SAM
		click("//i[contains(text(),'close')]","//div[@data-instance-key='2091_65a9375e-4ade-4e6a-a257-e707e4fe820d']/div");
		System.out.println("First SAM has been closed.");
		
		//Open Second SAM
		click("//div[@data-instance-key='2091_65a9375e-4ade-4e6a-a257-e707e4fe820d']/div","//i[contains(text(),'close')]");
		System.out.println("Second SAM has been opened.");
		
		//Close Second SAM
		click("//i[contains(text(),'close')]","//div[@data-instance-key='2092_5f1a783e-bc3d-4c82-8a94-6716d645673f']/div");
		System.out.println("Second SAM has been closed.");
		
		//Open Third SAM
		click("//div[@data-instance-key='2092_5f1a783e-bc3d-4c82-8a94-6716d645673f']/div","//i[contains(text(),'close')]");
		System.out.println("Third SAM has been opened.");
		
		//Close Third SAM
		click("//i[contains(text(),'close')]","//div[@data-instance-key='2092_5f1a783e-bc3d-4c82-8a94-6716d645673f']/div");
		System.out.println("Third SAM has been closed.");
	}
	
	@AfterTest
	void end()
	{
		System.out.println("With All Passed cases this interactive ad has been tested.");
		driver.quit();
	}
}
