package  TestNG;
import org.testng.annotations.*;

public class LoginTest {

    @BeforeMethod
    void setUp() {System.out.println("Browser launched"); }

    @Test(description = "User login test")
    void loginTest() { System.out.println("Executing login test"); }

    @AfterMethod
    void tearDown() { System.out.println("Browser closed"); }
}

