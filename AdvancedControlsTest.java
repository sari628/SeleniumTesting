package TestNG;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class AdvancedControlsTest {

    @Test
    public void handleAdvancedControls() {

        // TODO 1: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // TODO 2: Create WebDriverWait with 10 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            driver.manage().window().maximize();

            // ==============================
            // JavaScript Alert
            // ==============================

            // TODO 3: Navigate to JavaScript Alerts page
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // TODO 4: Click "Click for JS Alert" button
            WebElement alertButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("button[onclick='jsAlert()']")
                    )
            );
            alertButton.click();

            // TODO 5: Wait for alert to be present
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            if (alert == null) {
                throw new NoAlertPresentException();
            }

            // ✅ Validate alert text before accepting
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "I am a JS Alert",
                    "Alert text validation failed");

            // TODO 6: Accept the alert
            alert.accept();

            // ==============================
            // Window Handling
            // ==============================

            // TODO 7: Navigate to Multiple Windows page
            driver.get("https://the-internet.herokuapp.com/windows");

            // TODO 9: Capture parent window handle
            String parentWindow = driver.getWindowHandle();

            // TODO 8: Click "Click Here" link
            WebElement clickHere = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("div.example > a")
                    )
            );
            clickHere.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            // TODO 10: Switch to the newly opened window
            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            // ✅ Validate new window content
            WebElement newWindowHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.tagName("h3")
                    )
            );

            String windowText = newWindowHeading.getText();
            Assert.assertEquals(windowText, "New Window",
                    "New window content validation failed");

            driver.close();
            driver.switchTo().window(parentWindow);

            // ==============================
            // Iframe Handling
            // ==============================

            // TODO 11: Navigate to Iframe page
            driver.get("https://the-internet.herokuapp.com/iframe");

            // TODO 12: Switch to iframe using id "mce_0_ifr"
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr"));

            // TODO 13: Locate editor element and retrieve text
            WebElement editor = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("tinymce"))
            );

            String iframeText = editor.getText();

            // ✅ Verify iframe content properly
            Assert.assertNotNull(iframeText, "Iframe text is null");
            Assert.assertFalse(iframeText.trim().isEmpty(),
                    "Iframe text is empty");
            Assert.assertEquals(iframeText, "Your content goes here.",
                    "Iframe content validation failed");

            // ✅ Print retrieved content
            System.out.println("Iframe Text Retrieved: " + iframeText);

            driver.switchTo().defaultContent();

        } catch (Exception e) {

            // TODO 14: Handle exception
            System.out.println("Test Failed: " + e.getMessage());
            throw e;

        } finally {

            // TODO 15: Quit the browser
            driver.quit();
        }
    }
}

