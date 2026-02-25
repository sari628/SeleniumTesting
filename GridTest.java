package TestNG;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {

    public static void main(String[] args) {
        try {
            // Step 1: Selenium Grid Hub URL
            URL gridurl = new URL("http://localhost:4444/wd/hub");

            // Step 2: Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            // Step 3: Create RemoteWebDriver
            WebDriver driver = new RemoteWebDriver(gridurl, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            // Step 4: Navigate to Google
            driver.get("https://www.google.com");  // Fixed typo

            // Step 5: Print page title
            System.out.println("Page Title: " + driver.getTitle());

            // Step 6: Quit driver
            driver.quit();

       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


