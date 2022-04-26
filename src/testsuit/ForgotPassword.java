package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPassword extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToForgotPasswordpageSuccessfully() {
        //click on Password
        clickOnElement(By.id("btnLogin"));

        //This is from requirement
        String expectedMessage = "Forgot your password?";
        String actualMessage = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[5]/div[1]/a[1]"));
        //validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


