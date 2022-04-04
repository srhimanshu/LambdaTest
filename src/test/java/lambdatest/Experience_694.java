package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Experience_694 {
	RemoteWebDriver driver;
	String userName = "yash.jainsourcedigital";
	String accessKey = "R8wSXoVE0MlpUPXrslGw0bZdothPDwvKsX1AVIfTMqISD5dFNX";
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	
	
	@BeforeTest
	@Parameters(value= {"browser","version","platform"})
	void setUp(String browser, String version, String platform) throws MalformedURLException
	{
		//Set Capabilities for Lambda Test
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", platform);
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version); 
        capabilities.setCapability("build", "Experience_694");
        capabilities.setCapability("name", "Experience_694");
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true); 
        capabilities.setCapability("console", true); 
        capabilities.setCapability("terminal", true);
        
        //LambdaTest url for automation
        URL url = new URL("https://"+userName+":"+accessKey+"@hub.lambdatest.com/wd/hub");
        driver = new RemoteWebDriver(url,capabilities);

		// Explicit Wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		js = (JavascriptExecutor) driver;
		
		actions = new Actions(driver);

	}

	@Test
	public void launchURL() throws InterruptedException
	{
		// Launch Experience Engine URL
		driver.get("https://experience.sourcesync.io/694");
	}
	
	@Test(dependsOnMethods = {"launchURL"})
	public void playVideo() throws InterruptedException
	{
		// Play Video
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1439_4bf2c664-2204-45f5-9158-23ece304bc0f']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
//		click("//button[@class='plyr__control plyr__control--overlaid']");
	}
	
	@Test(groups = {"OneToTen"} , priority = 1)
	public void iframe01() throws InterruptedException
	{
		// Asserting iframe01 SAM
		assertSAM("//div[@data-instance-key='1439_4bf2c664-2204-45f5-9158-23ece304bc0f']/div");
	}
	
	@Test(groups = {"OneToTen"} , priority = 1)
	public void iframe02() throws InterruptedException
	{
		// Asserting iframe02 SAM
		assertSAM("//div[@data-instance-key='1713_ebb05286-168d-46a8-a25c-b4ed94c5381b']/div");
	}
	
	@Test(groups = {"OneToTen"} , priority = 1)
	public void action01() throws InterruptedException
	{
		// Asserting action01 SAM
		assertSAM("//div[@data-instance-key='1440_bfac8882-5cf6-408d-a9da-48e0e38ea795']/div");
	}
	
	@Test(groups = {"OneToTen"} , priority = 1)
	public void action02() throws InterruptedException
	{
    
		// Asserting action02 SAM
		assertSAM("//div[@data-instance-key='1714_d5674800-d2d7-4e26-a581-49957c02a9dd']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1443_65d98bed-8c77-40c1-8343-f9c186dd3ec5']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"ElevenToTwenty"} , priority = 2)
	public void image01() throws InterruptedException
	{
		// Asserting image01 SAM
		assertSAM("//div[@data-instance-key='1443_65d98bed-8c77-40c1-8343-f9c186dd3ec5']/div");
	}
	
	@Test(groups = {"ElevenToTwenty"} , priority = 2)
	public void image02() throws InterruptedException
	{
		// Asserting image02 SAM
		assertSAM("//div[@data-instance-key='1444_37ccd393-8fb7-4c49-a392-a17894836113']/div");
	}
	
	
	@Test(groups = {"ElevenToTwenty"} , priority = 2)
	public void image03() throws InterruptedException
	{
		// Asserting image03 SAM
		assertSAM("//div[@data-instance-key='1445_39d8ba14-1170-4b80-a61b-d97858e09135']/div");
	}
	
	@Test(groups = {"ElevenToTwenty"} , priority = 2)
	public void image04() throws InterruptedException
	{
		// Asserting image04 SAM
		assertSAM("//div[@data-instance-key='1446_3a4dfc46-09ec-423c-b891-fdc112bdcd96']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1449_c9e30241-ce20-4362-983d-16dd7ed27908']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"TwentyoneToThirty"} , priority = 3)
	public void markdown01() throws InterruptedException
	{
		// Asserting markdown01 SAM
		assertSAM("//div[@data-instance-key='1449_c9e30241-ce20-4362-983d-16dd7ed27908']/div");
	}
	
	@Test(groups = {"TwentyoneToThirty"} , priority = 3)
	public void markdown02() throws InterruptedException
	{
		// Asserting markdown02 SAM
		assertSAM("//div[@data-instance-key='1450_aa477d13-d9f8-4165-aa64-01b47630cda6']/div");
	}
	
	@Test(groups = {"TwentyoneToThirty"} , priority = 3)
	public void markdown03() throws InterruptedException
	{
		// Asserting markdown03 SAM
		assertSAM("//div[@data-instance-key='1715_a93ebb3e-7eff-4279-a045-399218092e11']/div");
	}
	
	@Test(groups = {"TwentyoneToThirty"} , priority = 3)
	public void image05() throws InterruptedException
	{
		// Asserting image05 SAM
		assertSAM("//div[@data-instance-key='1447_657c80d0-2673-4442-aab5-791bac499050']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1716_fc8902bc-c707-4a78-b977-a34840068df6']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"ThirtyoneToFourty"} , priority = 4)
	public void markdown04() throws InterruptedException
	{
		// Asserting markdown04 SAM
		assertSAM("//div[@data-instance-key='1716_fc8902bc-c707-4a78-b977-a34840068df6']/div");
	}
	
	@Test(groups = {"ThirtyoneToFourty"} , priority = 4)
	public void markdown05() throws InterruptedException
	{
		// Asserting markdown05 SAM
		assertSAM("//div[@data-instance-key='1717_b0f2b638-09e4-4775-b708-a4779b93e6cf']/div");
	}
	
	@Test(groups = {"ThirtyoneToFourty"} , priority = 4)
	public void markdown06() throws InterruptedException
	{
		// Asserting markdown06 SAM
		assertSAM("//div[@data-instance-key='1718_2836892c-6f89-426e-9ddb-ea29db8980da']/div");
	}
	
	@Test(groups = {"ThirtyoneToFourty"} , priority = 4)
	public void markdown07() throws InterruptedException
	{
		// Asserting markdown07 SAM
		assertSAM("//div[@data-instance-key='1719_45d2c3fc-94c0-4f24-a6b6-7118e091764b']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1451_c52ad90d-f4b3-4869-b86b-5c684329c559']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"FourtyoneToFifty"} , priority = 5)
	public void social01() throws InterruptedException
	{
		// Asserting social01 SAM
		assertSAM("//div[@data-instance-key='1451_c52ad90d-f4b3-4869-b86b-5c684329c559']/div");
	}
	
	@Test(groups = {"FourtyoneToFifty"} , priority = 5)
	public void social02() throws InterruptedException
	{
		// Asserting social02 SAM
		assertSAM("//div[@data-instance-key='1452_f6a0ed12-c343-4bcb-ba20-5eb2a5bc5971']/div");
	}
	
	@Test(groups = {"FourtyoneToFifty"} , priority = 5)
	public void social03() throws InterruptedException
	{
		// Asserting social03 SAM
		assertSAM("//div[@data-instance-key='1453_98d08d6a-3af5-4f0e-91c8-66f62954b3c7']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1454_3fd478d4-2cb8-4cd0-9a1f-6a3d8d06768a']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"FiftyoneToSixty"} , priority = 6)
	public void social04() throws InterruptedException
	{
		// Asserting social04 SAM
		assertSAM("//div[@data-instance-key='1454_3fd478d4-2cb8-4cd0-9a1f-6a3d8d06768a']/div");
	}
	
	@Test(groups = {"FiftyoneToSixty"} , priority = 6)
	public void video01() throws InterruptedException
	{
		// Asserting video01 SAM
		assertSAM("//div[@data-instance-key='1455_3a4accb7-a1f9-4617-b52c-1ee2637be372']/div");
	}
	
	@Test(groups = {"FiftyoneToSixty"} , priority = 6)
	public void video02() throws InterruptedException
	{
		// Asserting video02 SAM
		assertSAM("//div[@data-instance-key='1456_edc38803-c9ab-4b3e-b89a-1553070abb10']/div");
	}
	
	@Test(groups = {"FiftyoneToSixty"} , priority = 6)
	public void video03() throws InterruptedException
	{
		// Asserting video03 SAM
		assertSAM("//div[@data-instance-key='1457_ed15844b-8ec5-450a-8e02-d359fc06b468']/div");
		
		actions.sendKeys(Keys.chord(Keys.ARROW_RIGHT));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-instance-key='1458_80602e6a-ec41-4fdc-a2fb-6f9168bc1bd7']/div")));
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
	
	@Test(groups = {"SixtyoneToSeventy"} , priority = 7)
	public void video04() throws InterruptedException
	{
		// Asserting video04 SAM
		assertSAM("//div[@data-instance-key='1458_80602e6a-ec41-4fdc-a2fb-6f9168bc1bd7']/div");
	}
	
	@Test(groups = {"SixtyoneToSeventy"} , priority = 7)
	public void video05() throws InterruptedException
	{
		// Asserting video05 SAM
		assertSAM("//div[@data-instance-key='1459_8bc1359d-c393-4174-9e32-e4ffb96e7ceb']/div");
	}
	
	@Test(groups = {"SixtyoneToSeventy"} , priority = 7)
	public void video06() throws InterruptedException
	{
		// Asserting video06 SAM
		assertSAM("//div[@data-instance-key='1460_e7e6aed5-26eb-4ab3-a6cc-6530e7ada2cc']/div");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	void assertSAM(String clickableandWaitXpath) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
		driver.findElement(By.xpath(clickableandWaitXpath)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(text(),'close')]")));
		driver.findElement(By.xpath("//i[contains(text(),'close')]")).click();
		Thread.sleep(100);
	}

	void click(String clickableandWaitXpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickableandWaitXpath)));
		driver.findElement(By.xpath(clickableandWaitXpath)).click();
	}
	
	void forward(int seconds) throws InterruptedException
	{
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='plyr__controls']/button"))).click().perform();
	}
}
