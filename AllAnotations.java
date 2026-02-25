package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnotations {
	WebDriver driver;
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@Test(priority = 1)
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Google Opened");
    }

    @Test(priority = 2)
    public void openAmazon() {
        driver.get("https://www.amazon.in");
        System.out.println("Amazon Opened");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Each Test");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}

