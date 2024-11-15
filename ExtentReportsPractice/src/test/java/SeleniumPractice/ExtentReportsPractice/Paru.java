package SeleniumPractice.ExtentReportsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Paru {
ExtentReports extent;
WebDriver driver;
@Test
public void InitilizeApplication() {
	extent.createTest("Revision");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://instagram.com");
	
}

@BeforeTest
public void config() {
	String Path = System.getProperty("user.dir")+"//Reportsfor3//index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(Path);
	reporter.config().setReportName("ExtentReportPractice");
	reporter.config().setDocumentTitle("PracticeMakesManPerfect");
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Pavankumar T");
	
	
	
	
}
@AfterTest
public void tearDown() {
	driver.close();
	extent.flush();
}

}
