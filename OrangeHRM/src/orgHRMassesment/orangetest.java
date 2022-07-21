package orgHRMassesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class orangetest {
	WebDriver driver;
	
	@Test
	public void logintest() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "/home/akshat.shri/.nvm/versions/node/v12.18.3/bin/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Admin")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("My Info")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Directory")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		
				
	}
	@AfterTest
	public void close() {
		driver.close();

}
	
}
