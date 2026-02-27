package TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {

    @Test(description = "Verify that the title matches the expected value")
    public void verifyTitle() {
        String actual = "Google";
        String expected = "Google";

        // TestNG assertion
        Assert.assertEquals(actual, expected, "Title does not match!");

        System.out.println("Title verification passed: " + actual);
    }
}

