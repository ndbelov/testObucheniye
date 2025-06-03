package framework.browser;

import com.microsoft.playwright.*;
import framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserManager {
    private static final BrowserSingleton singleton = BrowserSingleton.getInstance();
    private static Browser browser;
    private static Page page;

    private BrowserManager() {
    }

    public static Browser initializeWebDriver(Playwright playwright) {

            LoggerUtils.makeLog("Initialization of driver object");
            browser = singleton.getDriver(playwright);
            page = browser.newPage();
            return browser;
    }

    public static Browser getBrowser() {
        return browser;
    }
    public static Page getPage() {return page;}

    public static Locator getElement(String locator){
        return page.locator(locator);
    }

//    public static void switchToFrameByXpath(String xpath){
//        LoggerUtils.makeLog("Switch to frame by xpath: " + xpath);
//        WaitUtils.waitForElementVisibility(By.xpath(xpath));
//        WebElement frameElement = browser.findElement(By.xpath(xpath));
//        browser.switchTo().frame(frameElement);
//    }
//
//    public static void returnToDefaultFrame(){
//        LoggerUtils.makeLog("Return to default frame");
//        browser.switchTo().defaultContent();
//    }
//
//    public static void acceptAlert() {
//        LoggerUtils.makeLog("Acept current alert");
//        browser.switchTo().alert().accept();
//    }

    public static void quitBrowser() {
        LoggerUtils.makeLog("Closing browser");
        browser.close();
        singleton.setDriverNull();
    }
}