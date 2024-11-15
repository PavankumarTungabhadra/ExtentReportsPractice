package SeleniumPractice.ExtentReportsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport2 {
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeTest
	public void Config()
	{
		//ExtentSparkReporter-->> used to specify the the path of the folder needs to be created.
		String Path = System.getProperty("user.dir")+"//Reports1//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(Path);
		reporter.config().setReportName("Anushka");
		reporter.config().setDocumentTitle("Prabhas");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Love", "Birds");
	}
	@Test
	public void Initilizer()
	{
		extent.createTest("lovebirds story");
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.get("https://facebook.com");
		
	}
	@AfterTest
	public void Teardown()
	{
		extent.flush();
		driver.close();
	}

}
