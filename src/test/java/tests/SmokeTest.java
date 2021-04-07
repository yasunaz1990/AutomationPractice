package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;
import pages.TrelloHomePage;

public class SmokeTest extends TestBase {

    @Test
    public void verifyHomePageIsDisplayed() {
        TrelloHomePage homePage = new TrelloHomePage(getDriver());
        homePage.open();
        boolean result = homePage.isPageVisible();
        Assert.assertTrue(result);
    }


    @Test
    public void verifyLoginPageIsDisplayed() throws InterruptedException {
        // Test Data
        TrelloHomePage homePage = new TrelloHomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        // Test Steps
        homePage.open();
        homePage.gotoLoginPage();
        Thread.sleep(4000);
        boolean result = loginPage.isLoginPageVisible();

        // Test Assertion
        Assert.assertTrue(result);
    }

    @Test
    public void verifySignUpPageIsDisplayed() throws InterruptedException {
        // Test Data
        TrelloHomePage homePage = new TrelloHomePage(getDriver());
        SignupPage signupPage = new SignupPage(getDriver());

        // Test Steps
        homePage.open();
        homePage.gotoSignUpPage();
        Thread.sleep(2000);
        boolean result = signupPage.isSignUpPageDisplayed();

        // Test Assert
        Assert.assertTrue(result);
    }
}