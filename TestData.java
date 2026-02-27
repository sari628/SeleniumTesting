package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {


	@Test (dataProvider="loginData")
	public void loginTest(String username, String password)
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login");
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		System.out.println("Message:" + username);
		
		driver.findElement(By.id("submit")).click();
		
		driver.quit();
	}
		@DataProvider(name="loginData")
		public Object[][] getData()
		{
			return new Object[][]
		{
				{"user1", "pass1"},	
				{"user2", "pass2"},	
				{"user3", "pass3"}	
 
		};
		
	}
	
	
}

