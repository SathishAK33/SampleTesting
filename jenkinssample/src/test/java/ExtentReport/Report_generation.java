package ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report_generation {

	ExtentReports EXT;
	ExtentTest test;
	WebDriver wb;

	@BeforeTest
	public void StartReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport.html");

		EXT = new ExtentReports();

		EXT.attachReporter(reporter);
	}

	@AfterTest
	public void StopReport() {
		EXT.flush();
	}

	@Test
	public void CreateTest() {
		test = EXT.createTest("Test_2");

		test.assignAuthor("AK");

		test.assignCategory("Smoke Testing");

	}

	@Test
	public void Test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\software\\Eclipse Mars\\eclipse\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myhcl.com/bprhome/Home/Index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myhcl.com/bprhome/Home/Index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// implicitlyWaitwait
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sathish.ak@hcl.com");// sendkeys
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("i0118")).sendKeys("Model@k33");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.id("idBtn_Back")).click();
		WebElement txt = driver.findElement(By.id("txtSearch"));
		txt.click();
		txt.sendKeys("iTime (Time Sheet Management System)");
		driver.findElement(By.xpath("/html/body/ul/li/table/tbody/tr/td[1]/a")).click();
		Thread.sleep(3000);
		WebElement TimeEnter = driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/section/div[4]/div[1]/div/div/div/div[2]/div/div[1]/span/div[2]/div/div/div/div/div/div[2]/div/div/div/div/input"));
		Thread.sleep(5000);
		TimeEnter.click();
		Thread.sleep(5000);
		TimeEnter.sendKeys("09:00");
		driver.get("https://wf24.myhcl.com/iTime/iTime/index.html?v=35#/TimeSheet");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(300,800)", "");
		driver.findElement(By.id("le_apply")).click();

	}

	@Test
	void StatusReport() {
		test.pass("Enter the login details");

		test.pass("Click on save button");

		test.pass("Search the itime in myhcl page");

		test.pass("Enter the tie sheet data");
	}

}
