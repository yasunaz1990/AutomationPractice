package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    // ---- Fields
    private WebDriver driver;
    private By loc_page_banner = By.xpath("//h1");
    private By loc_email_input = By.id("email");
    private By loc_continue_bttn = By.id("signup-submit");

    // ---- Constructor
    public SignupPage(WebDriver inputDriver) {
        driver = inputDriver;
    }

    // ---- Methods
    public boolean isSignUpPageDisplayed() {
        WebElement bannerText = driver.findElement(loc_page_banner);
        return bannerText.isDisplayed();
    }
}
