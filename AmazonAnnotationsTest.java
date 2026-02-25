package TestNG;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class AmazonAnnotationsTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Test Suite Started");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test Class Started");
    }

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.in");

        // Explicit wait for Amazon logo
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("nav-logo-sprites")));

        System.out.println("Amazon Page Loaded Successfully");
    }

    @Test(priority = 1)
    public void verifyTitle() {

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertTrue(title.contains("Amazon"));
    }

    @Test(priority = 2)
    public void clickLogin() {

        driver.findElement(By.id("nav-link-accountList")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
        System.out.println("Login Page Opened");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000); // just to see browser clearly
        driver.quit();

        System.out.println("Browser Closed");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Test Class Finished");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test Suite Finished");
    }
}
     


