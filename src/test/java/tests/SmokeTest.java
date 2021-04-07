package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;
import pages.HomePage;

public class SmokeTest extends TestBase {

    @Test
    public void verifyHomePageIsDisplayed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        boolean result = homePage.isPageVisible();
        Assert.assertTrue(result);
    }


    @Test
    public void verifyLoginPageIsDisplayed() throws InterruptedException {
        // Test Data
        HomePage homePage = new HomePage(getDriver());
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
        HomePage homePage = new HomePage(getDriver());
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