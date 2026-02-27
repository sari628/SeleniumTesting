package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionTest1 {
    
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initializes the browser before any tests run
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void verifyTitle() {
        String expectedTitle = "Google";
        
        // Fetching the actual title from the browser
        String actualTitle = driver.getTitle();
        
        // Optimization: Added a custom error message for the report
        Assert.assertEquals(actualTitle, expectedTitle, "The page title does not match!");
    }

    @AfterClass
    public void tearDown() {
        // Closes the browser after the test class is finished
        if (driver != null) {
            driver.quit();
        }
    }
}


