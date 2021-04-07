package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Optional
public class PricingPage {

    //---- Fields
    private final WebDriver driver;

    private final By loc_page_banner = By.xpath("//h1");
    private final By loc_price_free = By.xpath("//h2[text()='Free']");
    private final By loc_price_biz = By.xpath("//h2[text()='Business Class']");
    private final By loc_price_entp = By.xpath("//h2[text()='Enterprise']");
    private final By loc_price_biz_monthly = By.xpath("(//div[contains(@class,'dRnxNh')])[2]");
    private final By loc_try_free_bttn = By.xpath("//span[text()='Try for free']");

    //---- Constructors
    public PricingPage(WebDriver inputDriver) {
        driver = inputDriver;
    }


    //---- Methods
    public boolean isPageDisplayed() {
        WebElement pageBanner = driver.findElement(loc_page_banner);
        return pageBanner.isDisplayed();
    }

    public boolean isPricingCategoryDisplayed() {
        WebElement freeTier = driver.findElement(loc_price_free);
        WebElement bizTier = driver.findElement(loc_price_biz);
        WebElement entpTier = driver.findElement(loc_price_entp);

        boolean isFreeTierThere = freeTier.isDisplayed();
        boolean isBizTierThere = bizTier.isDisplayed();
        boolean isEntpTierThere = entpTier.isDisplayed();

        return (isFreeTierThere && isBizTierThere && isEntpTierThere);
    }

    public boolean verifyBizMonthlyPrice(String expectedPrice) {
        WebElement bizMonthlyPrice = driver.findElement(loc_price_biz_monthly);
        String actualPrice = bizMonthlyPrice.getText();
        return actualPrice.equals(expectedPrice);
    }
}
