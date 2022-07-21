package orgHRMassesment;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class orglogin {
	
		WebDriver driver;
		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "/home/akshat.shri/.nvm/versions/node/v12.18.3/bin/chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			Thread.sleep(1000);
		}
		@Test(dataProvider="dataset")
		public void loginSetup(String usrName, String pasword) throws InterruptedException {
			
			Thread.sleep(1000);
			driver.findElement(By.name("txtUsername")).sendKeys(usrName);
			driver.findElement(By.name("txtPassword")).sendKeys(pasword);
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(2000);
			
			try {
				
				driver.findElement(By.partialLinkText("Welcome")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Logout")).click();
				System.out.println(usrName + " Valid user");
				
				}catch(Exception e) {
					System.out.println(usrName + " Invalid User");
				}
		
		}
		
		@AfterTest
		public void closing() {
			driver.close();
		}
		
		@DataProvider(name="dataset")
		public Object[][] datObj(){
			return new Object[][] {
				{"Admin","admin123"},
				{"Akshat","aks123"},
				{"Virat", "71kohli"}
			};
		}
		
	}
	


