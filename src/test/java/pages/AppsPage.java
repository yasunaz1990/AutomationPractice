package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppsPage {

    //---- Fields
    private WebDriver driver;
    private By loc_page_banner = By.xpath("//h1");

    // platform related elem locations
    private By loc_web_board = By.cssSelector("img[alt*='Web board']");
    private By loc_mobile_board = By.cssSelector("img[alt*='Mobile']");
    private By loc_desktop_board = By.cssSelector("img[alt*='Desktop']");

    // browser related elem locations
    private By loc_chrome = By.cssSelector("img[alt*='Chrome']");
    private By loc_firefox = By.cssSelector("img[alt*='Firefox']");
    private By loc_edge = By.cssSelector("img[alt*='Edge']");
    private By loc_safari = By.cssSelector("img[alt*='Safari']");

    // download buttons
    private By loc_browser_downloads = By.xpath("//a/span[text()='Download']");


    //---- Constructors
    public AppsPage(WebDriver inputDriver) {
        driver = inputDriver;
    }

    //---- Methods
    public boolean isPlatformImgsDisplayed() {
        WebElement webBoardElem = driver.findElement(loc_web_board);
        WebElement mobileBoardElem = driver.findElement(loc_mobile_board);
        WebElement desktopBoardElem = driver.findElement(loc_desktop_board);

        // validating that each platform images are displayed
        boolean isWebBoardImgThere = webBoardElem.isDisplayed();
        boolean isMobileBoardImgThere = mobileBoardElem.isDisplayed();
        boolean isDesktopBoardImgThere = desktopBoardElem.isDisplayed();

        return (isWebBoardImgThere && isMobileBoardImgThere && isDesktopBoardImgThere);
    }

    public boolean isSupportedBrowserImgsDisplayed() {
        WebElement chromeBrowserElem = driver.findElement(loc_chrome);
        WebElement firefoxBrowserElem = driver.findElement(loc_firefox);
        WebElement edgeBrowserElem = driver.findElement(loc_edge);
        WebElement safariElem = driver.findElement(loc_safari);

        return chromeBrowserElem.isDisplayed() &&
                firefoxBrowserElem.isDisplayed() &&
                edgeBrowserElem.isDisplayed() &&
                safariElem.isDisplayed();
    }

    public boolean isBrowserDownloadsFunctional() {
        List<WebElement> browserDownloadButtons = driver.findElements(loc_browser_downloads);
        boolean result = true;
        for(int i = 0; i < browserDownloadButtons.size(); i++) {
            boolean isDisplayed = browserDownloadButtons.get(i).isEnabled();
            result = result && isDisplayed;
        }
        return result;
    }
}
