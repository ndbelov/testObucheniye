package framework.elements;

import com.microsoft.playwright.Locator;
import framework.browser.BrowserManager;
import framework.browser.BrowserSingleton;
import framework.utils.LoggerUtils;

public abstract class BaseElement {
    protected static final BrowserSingleton singleton = BrowserSingleton.getInstance();
    protected final String locator;
    protected final String name;

    BaseElement(String locator, String name) {

        this.locator = locator;
        this.name = name;
    }

    public void waitForDisplayed() {
        LoggerUtils.makeLog("Wait for displaying of " + name);
        BrowserManager.getPage().waitForSelector(locator);
    }
//
//    public void waitForInvisible() {
//        LoggerUtils.makeLog("Wait for invisibility of " + name);
//        WaitUtils.waitForElementInvisibility(locator);
//    }

    public void click() {
        LoggerUtils.makeLog("Click on " + name);
        BrowserManager.getPage().waitForSelector(locator);
        find().click();
    }

//    public String getAttribute(String attribute){
//        LoggerUtils.makeLog("Get " + attribute + " attribute of " + name);
//        WaitUtils.waitForElementVisibility(locator);
//        return find().getAttribute(attribute);
//    }

//    public void focus() {
//        LoggerUtils.makeLog("Focus on " + name);
//        WaitUtils.waitForElementToBeClickable(locator);
//        new Actions(BrowserManager.getBrowser()).moveToElement(find()).perform();
//    }

    public String getText() {
        LoggerUtils.makeLog("Get text of " + name);
        BrowserManager.getPage().waitForSelector(locator);
        return find().textContent();
    }

//    public File makeScreenshot() {
//        LoggerUtils.makeLog("Get screenshot of" + name);
//        return find().getScreenshotAs(OutputType.FILE);
//    }

//    public void scroll() {
//        LoggerUtils.makeLog("Scroll to " + name);
//        WaitUtils.waitForElementVisibility(locator);
//        ((JavascriptExecutor) BrowserManager.getBrowser()).executeScript("arguments[0].scrollIntoView(true);", find());
//    }

    public boolean isElementDisplayed(){
        LoggerUtils.makeLog("Check that " + name + " is enabled");
        return find().isVisible();
    }

//    public boolean isElementExist(){
//        LoggerUtils.makeLog("Check that " + name + " is displayed");
//        return BrowserManager.getBrowser().findElements(locator).size() > 0;
//    }

    protected Locator find() {
        return BrowserManager.getElement(locator);
    }

    public String getLocator() {
        return locator;
    }
}