package SeleniumPractice.ExtentReportsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
 ExtentReports extent;
	@Test
	public void InitilizeApplication() {
		extent.createTest("Execution");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://youtube.com");
		extent.flush();
		
		
	}
	@BeforeTest
	public void config()
	{
		//extentSperkReporter---> is used to create the reports path
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Execution");
		reporter.config().setDocumentTitle("Automation Test result");
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Author", "Prarthana");
		
		
	}

}
