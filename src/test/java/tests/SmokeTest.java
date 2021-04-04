package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test
    public void verifyHomePageIsDisplayed() {
        getDriver().get("https://trello.com");

        // Banner Text Element
        By loc_homepage_banner = By.xpath("//h1");
        WebElement homepageBannerElement = getDriver().findElement(loc_homepage_banner);

        boolean isBannerVisible = homepageBannerElement.isDisplayed();

        // Assertions
        Assert.assertTrue(isBannerVisible);
    }


    @Test
    public void verifyLoginPageIsDisplayed() throws InterruptedException {
        getDriver().get("https://trello.com");

        // Go to login page
        By loc_login_link = By.linkText("Log in");
        WebElement loginElement = getDriver().findElement(loc_login_link);
        loginElement.click();

        Thread.sleep(1000);

        // Grab login banner text
        By loc_loing_banner = By.xpath("//h1");
        WebElement loginBanner = getDriver().findElement(loc_loing_banner);
        String actualText = loginBanner.getText();   // code extracting the text

        Assert.assertEquals(actualText, "Log in to Trello!");
    }
}
