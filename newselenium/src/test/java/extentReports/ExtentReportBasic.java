package extentReports;

import java.util.List;

import org.jsoup.select.Evaluator.AttributeStarting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasic{
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		 // Create Object of ExtentHtmlReporter and provide the path where you want to generate
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("ExtentReports1.html");
		 
		// Create object of ExtentReports class- This is main class which will create report
		ExtentReports extent = new ExtentReports();
		
		// attach the reporter which we created in Step 1
	    extent.attachReporter(htmlReporter);
	    
	    // call createTest method and pass the name of TestCase- Based on your requirement
	    ExtentTest test1=extent.createTest("Google search Test 1","this is the test to valodate google search functionality");
	    
	    System.setProperty("webdriver.chrome.driver", "F://selenium//chromedriver.exe");
		 driver=new ChromeDriver();
		test1.log(Status.INFO, "Starting test1 case");
		driver.get("https://www.google.com/");
		test1.pass("navigating to google page");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation");
		test1.pass("entered text in search box");
		
		List<WebElement> lists=driver.findElements(By.xpath("//ul[@class='erkvQe']"));
		Thread.sleep(2000);
		for(WebElement ll:lists)
		{
			if(ll.getText().equalsIgnoreCase("autoamtion"))
				ll.click();
			Thread.sleep(2000);
			break;
		}
		
		test1.pass("pressed keyboard enter key");
		test1.info("test completed");
		
		
		 ExtentTest test2=extent.createTest("Google search Test 2","this is the test to valodate google search functionality");
		    
		    System.setProperty("webdriver.chrome.driver", "F://selenium//chromedriver.exe");
		driver=new ChromeDriver();
			test2.log(Status.INFO, "Starting test2 case");
			driver.get("https://www.google.com/");
			test2.pass("navigating to google page");
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation");
			test2.pass("entered text in search box");
			
			//driver.findElement(By.xpath("//span[text()='automation']")).click();;
			//test1.pass("pressed keyboard enter key");
			test2.info("test completed");
			
			 ExtentTest test3=extent.createTest("Google search Test 3","this is the test to valodate google search functionality");
			    
			    System.setProperty("webdriver.chrome.driver", "F://selenium//chromedriver.exe");
				 driver=new ChromeDriver();
				test3.log(Status.INFO, "Starting test3 case");
				driver.get("https://www.google.com/");
				test3.pass("navigating to google page");
				driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation");
				test3.fail("entered text in search box");
				//driver.findElement(By.xpath("//span[text()='automation']")).click();;
				//test1.pass("pressed keyboard enter key");
				test3.info("test completed");
		extent.flush();
	    
	}
}
