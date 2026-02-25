package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_withoutMaven {

    @Test
    public void openGoogle() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        }
}
