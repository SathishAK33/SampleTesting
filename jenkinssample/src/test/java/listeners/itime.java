package listeners;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test

@Listeners(listeners.listener.class)
public class itime {

	public void testHCL() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\software\\Eclipse Mars\\eclipse\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.myhcl.com/bprhome/Home/Index");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// implicitlyWaitwait
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sathish.ak@hcl.com");// sendkeys
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("i0118")).sendKeys("Model@k33");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.id("idBtn_Back")).click();
		// from itime to save bbtn
		WebElement txt = driver.findElement(By.id("txtSearch"));
		txt.click();
		txt.sendKeys("iTime (Time Sheet Management System)");

		driver.findElement(By.xpath("/html/body/ul/li/table/tbody/tr/td[1]/a")).click();

		Thread.sleep(3000);

		Thread.sleep(5000);
		WebElement click = driver.findElement(By.xpath(
				"//*[@id='mCSB_5_container']/span/div[2]/div/div/div/div/div/div[2]/div/div/div/div/input"));
		click.click();
		click.sendKeys("09:00");

		driver.findElement(By.xpath("//*[@id='le_apply']")).click();

	}
}
