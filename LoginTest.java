package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        // TODO 1: Initialize ChromeDriver
        driver = new ChromeDriver();

        // TODO 2: Maximize browser window
        driver.manage().window().maximize();

        // TODO 3: Navigate to https://the-internet.herokuapp.com/login
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyValidLogin() {

        // TODO 4: Locate username field using By.id and enter username
        driver.findElement(By.id("username"))
              .sendKeys("tomsmith");

        // TODO 5: Locate password field using By.name and enter password
        driver.findElement(By.name("password"))
              .sendKeys("SuperSecretPassword!");

        // TODO 6: Locate login button using By.xpath and click it
        driver.findElement(By.xpath("//button[@type='submit']"))
              .click();

        // TODO 7: Capture the success message displayed after login
        String successMessage = driver.findElement(By.id("flash"))
                                      .getText();

        // TODO 8: Verify success message contains
        // "You logged into a secure area" using TestNG Assert
        Assert.assertTrue(successMessage.contains("You logged into a secure area"),
                "Login failed - Success message not displayed.");
    }

    @AfterMethod
    public void tearDown() {

        // TODO 9: Close the browser
        driver.quit();
    }
}

