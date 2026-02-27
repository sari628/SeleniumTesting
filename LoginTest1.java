package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest1 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Launching Browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com"); // replace with real URL
    }

    @Test
    public void testLogin() {
        System.out.println("Executing Login Test...");
        
        // Add real login steps here
        // driver.findElement(By.id("username")).sendKeys("user");
        // driver.findElement(By.id("password")).sendKeys("pass");
        // driver.findElement(By.id("login")).click();
    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing Browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}


