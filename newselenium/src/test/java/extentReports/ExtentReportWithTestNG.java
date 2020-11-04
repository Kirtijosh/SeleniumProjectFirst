package extentReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		// Create Object of ExtentHtmlReporter and provide the path where you want to generate
		htmlReporter=new ExtentHtmlReporter("ExtentReports2.html");

		// Create object of ExtentReports class- This is main class which will create report
		extent = new ExtentReports();

		// attach the reporter which we created in Step 1
		extent.attachReporter(htmlReporter);
		 
	}
	@BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "F://selenium//chromedriver.exe");
		 driver=new ChromeDriver();
	}
	@Test
	public void test() throws IOException
	{
		ExtentTest test=extent.createTest("first testng extent reports","description is here");
		driver.get("https://www.google.com/");
		test.pass("navigating to google page");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");


	}
	@AfterTest
	public void AfterTest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	@AfterClass
	public void teardown()
	{
		extent.flush();
	}

}
