package Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_THO {

	public String username = "yash.jainsourcedigital";
	public String accesskey = "R8wSXoVE0MlpUPXrslGw0bZdothPDwvKsX1AVIfTMqISD5dFNX";
	
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	@BeforeClass
	@Parameters(value={"browser","version","platform"})
	public void setUp(String browser, String version, String platform) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform", platform);// If this cap isn't specified, it will just get the any available one
		capabilities.setCapability("build", "THO's Automation");
		capabilities.setCapability("name", "TodaysHomeOwner");
		capabilities.setCapability("network", true); 
		capabilities.setCapability("visual", true); 
		capabilities.setCapability("video", true); 
		capabilities.setCapability("console", true); 
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Test
	public void action() throws Exception {
		driver.get("https://todayshomeowner.com/dev/video/19-tips-to-maintain-your-home-this-winter-season/");

		//Password Page
				driver.findElement(By.xpath("//input[@class='input']")).sendKeys("TEST");
				driver.findElement(By.xpath("//input[@name='wp-submit']")).click();
				//Popup cancel
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")).click();
				//Video Play
				driver.findElement(By.xpath("//button[@class='vjs-big-play-button']")).click();
				//First SAM
				Thread.sleep(16000);
				driver.switchTo().frame("sourceElementId");
				driver.findElement(By.xpath("//img[@src='https://storage.googleapis.com/source-uploads-production/uploads/thumbnail_Home_Depot_Logo_45f706b63c/thumbnail_Home_Depot_Logo_45f706b63c.jpg']")).click();
				Thread.sleep(2000);
				String parent=driver.getWindowHandle();
				//Clicking on First SAM
				driver.findElement(By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--round q-btn--actionable q-focusable q-hoverable q-btn--wrap']")).click();
				Thread.sleep(2000);
				driver.switchTo().window(parent);
				driver.switchTo().frame("sourceElementId");
				//Closing First SAM
				driver.findElement(By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--round bg-black text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']")).click();
				Thread.sleep(15000);
				//Second SAM
				driver.findElement(By.xpath("//img[@src='https://storage.googleapis.com/source-uploads-production/uploads/thumbnail_Home_Depot_Logo_45f706b63c/thumbnail_Home_Depot_Logo_45f706b63c.jpg']")).click();
				Thread.sleep(2000);
				//Closing of Second SAM
				driver.findElement(By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--round bg-black text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']")).click();
				Thread.sleep(15000);
				//Third SAM
				driver.findElement(By.xpath("//img[@src='https://storage.googleapis.com/source-uploads-production/uploads/thumbnail_Home_Depot_Logo_45f706b63c/thumbnail_Home_Depot_Logo_45f706b63c.jpg']")).click();
				Thread.sleep(2000);
				//Closing of Third SAM
				driver.findElement(By.xpath("//button[@class='q-btn q-btn-item non-selectable no-outline q-btn--standard q-btn--round bg-black text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']")).click();
				Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
