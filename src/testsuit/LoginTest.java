package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    private String expectedMessage;

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {


        clickOnElement(By.id("txtUsername"));
        clickOnElement(By.name("txtPassword"));
        clickOnElement(By.className("button"));

        sendTextToElement(By.id("txtUsername"), "Admin");
        sendTextToElement(By.name("txtPassword"), "admin123");


        //This is from requirement
        String expectedMessage = "Welcome paul";
        String actualMessage = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/a[2]"));
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
        //validate actual and expected message

    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

